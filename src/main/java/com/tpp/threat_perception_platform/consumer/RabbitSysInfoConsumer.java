package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.*;
import com.tpp.threat_perception_platform.service.*;
import com.tpp.threat_perception_platform.utils.AESDecryptUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class RabbitSysInfoConsumer {

    @Autowired
    private HostService hostService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private AppService appService;

    @RabbitListener(queues = "sysinfo_queue")

    public void receive(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
         //将数据存储到数据库
        try {
            Host host = JSON.parseObject(message, Host.class);
            // 存储到数据库
            int res = hostService.saveHost(host);

            if (res > 0){
                // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
                // ACK
                channel.basicAck(deliveryTag,false);
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues ="status_queue")
    public void receiveStatus(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        Host host = JSON.parseObject(message, Host.class);
        //将数据存储到数据库
        try {
            //反序列化数据
            //根据macAddress查询主机信息

            // 存储到数据库
            int res = hostService.updateByMacAddress(host);

            if (res > 0){
                // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
                // ACK
                channel.basicAck(deliveryTag,false);
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues = "account_queue")
    public void receiveAccount(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Encrypted message received!\n"+ message );

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        try {
            //AES解密
            String decryptedJson = AESDecryptUtil.decrypt(message);
            System.out.println("Decrypted JSON:\n" + decryptedJson);

            //JSON转对象
            List<Account> accounts = JSON.parseArray(decryptedJson, Account.class);

            //存储到数据库
            int successCount = 0;
            for (Account account : accounts) {
                int res = accountService.save(account);
                if (res > 0) {
                    successCount++;
                }
            }
            System.out.println("成功保存账号数量: " + successCount);
            //ACK
            channel.basicAck(deliveryTag, false);

        } catch (Exception e) {
            System.err.println("解密或处理账号信息失败: " + e.getMessage());

            channel.basicAck(deliveryTag, false);
        }
    }

    @RabbitListener(queues = "service_queue")
    public void receiveService(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Encrypted message received!\n" + message);

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        try {
            //AES解密
            String decryptedJson = AESDecryptUtil.decrypt(message);
            System.out.println("Decrypted JSON:\n" + decryptedJson);

            //JSON转对象
            List<Account> accounts = JSON.parseArray(decryptedJson, Account.class);

            //存储到数据库
            int successCount = 0;
            for (Account account : accounts) {
                int res = accountService.save(account);
                if (res > 0) {
                    successCount++;
                }
            }
            System.out.println("成功保存服务数量: " + successCount);
            //ACK
            channel.basicAck(deliveryTag, false);

        } catch (Exception e) {
            System.err.println("解密或处理服务信息失败: " + e.getMessage());

            channel.basicAck(deliveryTag, false);
        }
    }

    @RabbitListener(queues = "process_queue")
    public void receiveProcess(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Encrypted message received!\n" + message);

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        try {
            //AES解密
            String decryptedJson = AESDecryptUtil.decrypt(message);
            System.out.println("Decrypted JSON:\n" + decryptedJson);

            //JSON转对象
            List<Account> accounts = JSON.parseArray(decryptedJson, Account.class);

            //存储到数据库
            int successCount = 0;
            for (Account account : accounts) {
                int res = accountService.save(account);
                if (res > 0) {
                    successCount++;
                }
            }
            System.out.println("成功保存进程数量: " + successCount);
            //ACK
            channel.basicAck(deliveryTag, false);

        } catch (Exception e) {
            System.err.println("解密或处理进程信息失败: " + e.getMessage());

            channel.basicAck(deliveryTag, false);
        }
    }

    @RabbitListener(queues="app_queue")
    public void receiveApp(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Encrypted message received!\n" + message);

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        try {
            //AES解密
            String decryptedJson = AESDecryptUtil.decrypt(message);
            System.out.println("Decrypted JSON:\n" + decryptedJson);

            //JSON转对象
            List<Account> accounts = JSON.parseArray(decryptedJson, Account.class);

            //存储到数据库
            int successCount = 0;
            for (Account account : accounts) {
                int res = accountService.save(account);
                if (res > 0) {
                    successCount++;
                }
            }
            System.out.println("成功保存应用数量: " + successCount);
            //ACK
            channel.basicAck(deliveryTag, false);

        } catch (Exception e) {
            System.err.println("解密或处理应用信息失败: " + e.getMessage());

            channel.basicAck(deliveryTag, false);
        }
    }
}
