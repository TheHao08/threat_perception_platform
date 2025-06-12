package com.tpp.threat_perception_platform.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AESDecryptUtil {
    // 和 Agent 端保持一致的 16 字节密钥
    private static final String KEY = "thisIsASecretKey";

    public static String decrypt(String base64Encrypted) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(base64Encrypted);
        // 前 16 字节是 IV
        byte[] iv = Arrays.copyOfRange(decoded, 0, 16);
        byte[] cipherBytes = Arrays.copyOfRange(decoded, 16, decoded.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decrypted = cipher.doFinal(cipherBytes);

        return new String(decrypted, "UTF-8");
    }
}
