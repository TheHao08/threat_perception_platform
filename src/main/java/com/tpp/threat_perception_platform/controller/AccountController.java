package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.pojo.Processes;
import com.tpp.threat_perception_platform.pojo.Services;
import com.tpp.threat_perception_platform.service.AccountService;
import com.tpp.threat_perception_platform.service.AppService;
import com.tpp.threat_perception_platform.service.ProcessService;
import com.tpp.threat_perception_platform.service.ServicesService;
import com.tpp.threat_perception_platform.dao.AccountMapper;
import com.tpp.threat_perception_platform.dao.AppMapper;
import com.tpp.threat_perception_platform.dao.ProcessesMapper;
import com.tpp.threat_perception_platform.dao.ServicesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private ProcessesMapper processMapper;

    @Autowired
    private ServicesMapper serviceMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AppService appService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ServicesService serviceService;

    /**
     * 根据 MAC 地址查询账户列表
     */
    @PostMapping("/host/accountList")
    public Map<String, Object> getAccounts(@RequestBody Map<String, String> req) {
        String mac = req.get("macAddress");
        List<Account> list = accountMapper.selectListByMac(mac);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "ok");
        result.put("data", list);
        return result;
    }

    /**
     * 保存单个账户信息（资产探测提交的）
     */
    @PostMapping("/host/account/save")
    public Map<String, Object> saveAccount(@RequestBody Account account) {
        int rows = accountService.save(account);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", rows > 0 ? "保存成功" : "未变更");
        return result;
    }

    /**
     * 查询应用列表
     */
    @PostMapping("/host/appList")
    public Map<String, Object> getApps(@RequestBody Map<String, String> req) {
        String mac = req.get("macAddress");
        List<App> list = appMapper.selectListByMac(mac);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "ok");
        result.put("data", list);
        return result;
    }

    /**
     * 查询进程列表
     */
    @PostMapping("/host/processList")
    public Map<String, Object> getProcesses(@RequestBody Map<String, String> req) {
        String mac = req.get("macAddress");
        List<Processes> list = processMapper.selectListByMac(mac);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "ok");
        result.put("data", list);
        return result;
    }

    /**
     * 查询服务列表
     */
    @PostMapping("/host/serviceList")
    public Map<String, Object> getServices(@RequestBody Map<String, String> req) {
        String mac = req.get("macAddress");
        List<Services> list = serviceMapper.selectListByMac(mac);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "ok");
        result.put("data", list);
        return result;
    }
}
