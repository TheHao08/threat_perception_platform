package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.util.List;

public interface AccountService {
    /**
     * 获取账号列表
     *
     * @param account 分页参数
     * @return 账号列表响应结果
     */
    int save(Account account);
}