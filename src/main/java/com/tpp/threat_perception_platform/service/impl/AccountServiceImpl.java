package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.AccountMapper;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        if (account.getMacAddress() == null || account.getMacAddress().isEmpty() || account.getName() == null || account.getName().isEmpty()) {
            // 没有mac或账号名，直接返回0
            return 0;
        }
        // 查询是否已存在
        Account dbAccount = accountMapper.selectByMacAddress(account.getMacAddress(), account.getName());
        if (dbAccount != null) {
            // 已存在，更新
            account.setId(dbAccount.getId());
            return accountMapper.updateByPrimaryKeySelective(account);
        } else {
            // 不存在，插入
            return accountMapper.insertSelective(account);
        }
    }

}
