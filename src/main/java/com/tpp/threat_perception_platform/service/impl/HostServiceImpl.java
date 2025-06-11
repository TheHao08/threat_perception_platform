package com.tpp.threat_perception_platform.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.*;
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.*;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import com.tpp.threat_perception_platform.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    private HostMapper hostMapper;

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private DangerAccountMapper dangerAccountMapper;

    @Autowired
    private DangerServiceMapper dangerServiceMapper;

    @Autowired
    private DangerProcessMapper dangerProcessMapper;

    @Autowired
    private DangerAppMapper dangerAppMapper;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ServicesMapper servicesMapper;
    @Autowired
    private ProcessesMapper processesMapper;
    @Autowired
    private AppMapper appMapper;


    @Override
    public int saveHost(Host host) {


        if (host.getMacAddress() == null || host.getMacAddress().equals("")) {
            //如果没有mac地址，直接返回0
            return 0;
        }
        //基本的逻辑：有主机的记录，更新，没有主机的记录，插入
        //先判断是否有mac地址
        Host dbHost = hostMapper.selectByMacAddress(host.getMacAddress());
        if (dbHost != null) {
            //如果有记录，更新
            host.setId(dbHost.getId()); //设置主键id
            host.setStatus(1);
            //还要时间 updateTime
            //获取当前时间
            host.setUpdateTime(new Timestamp(System.currentTimeMillis())); //更新操作时间
            return hostMapper.updateByPrimaryKeySelective(host);
        }
        //在数据库没有对应主机才创建队列
        //组装队列名称  agent_[mac_address]_queue,mac_address需要去掉冒号
        String queueName = "agent_" + host.getMacAddress().replace(":", "") + "_queue";
        String routingKey = host.getMacAddress().replace(":", "");
        rabbitService.createAgentQueue("agent_exchange", queueName, routingKey); //创建队列


        //如果没有记录，插入
        host.setStatus(1); //设置状态为1
        host.setCreateTime(new Timestamp(System.currentTimeMillis())); //设置创建时间
        return hostMapper.insertSelective(host); //插入主机信息
    }


    /**
     * 获取主机列表
     *
     * @param param 分页参数
     * @return 返回主机列表
     */
    @Override
    public ResponseResult hostList(MyParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<Host> dataList = hostMapper.findAll(param);
        for (Host host : dataList) {
            // 设置在线状态
            Date updateTime = host.getUpdateTime();
            if (updateTime == null) {
                host.setStatus(0); // 如果没有更新时间，设置为离线
                continue;
            }
            if (new Date().getTime() - updateTime.getTime() > 4000) { // 如果超过4秒没有更新，则认为主机离线
                host.setStatus(0);
            }


        }
        PageInfo<Host> pageInfo = new PageInfo<>(dataList);

        return new ResponseResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseResult delete(List<Long> id) {
        int count = 0;
        for (Long ids : id) {
            count += hostMapper.deleteByPrimaryKey(ids);
        }
        if (count > 0) {
            return new ResponseResult<>(0, "删除成功");
        }
        return new ResponseResult<>(1, "删除失败");
    }

    @Override
    public int updateByMacAddress(Host host) {

        host.setStatus(1); // 设置状态为在线
        host.setUpdateTime(new Timestamp(System.currentTimeMillis())); // 更新操作时间
        // 更新主机信息
        return hostMapper.updateByMacAddress(host);
    }

    @Override
    public ResponseResult assetsDiscovery(AssetsParam param) {
        //验证探测类型
        if (!param.getAccount().equals(0) && !param.getAccount().equals(1)) {
            return new ResponseResult<>(1004, "参数错误");
        }

        //通过mac地址去查询主机信息
        Host dbHost = hostMapper.selectByMacAddress(param.getMacAddress());
        //利用当前时间和更新时间进行对比来判断主机是否在线
        if (dbHost == null || dbHost.getUpdateTime() == null || new Date().getTime() - dbHost.getUpdateTime().getTime() > 4000) {
            //如果没有记录，或者超过4秒没有更新，则认为主机离线
            return new ResponseResult<>(1003, "主机不在线，请检查主机状态");
        }
        //初始化探测类型
        param.setType("assets");
        //将param转换成json字符串
        String data = JSON.toJSONString(param);
        //组装队列名字
        String routingKey = param.getMacAddress().replace(":", "");//去掉冒号
        rabbitService.sendMessage("agent_exchange", routingKey, data);
        return new ResponseResult<>(0, "资产探测任务已下发，请稍后查看结果");
    }


//    @Override
//    public ResponseResult accountDiscovery(AssetsParam param) {
//        if (param.getMacAddress() == null || param.getMacAddress().isEmpty()) {
//            return new ResponseResult(1, "mac地址不能为空");
//        }
//        PageHelper.startPage(param.getPage(), param.getLimit());
//        List<Account> list = accountMapper.selectListByMacAddress(param.getMacAddress());
//        PageInfo<Account> pageInfo = new PageInfo<>(list);
//        System.out.println(list);
//        return new ResponseResult( pageInfo.getTotal(), pageInfo.getList());
//    }

    @Override
    public ResponseResult accountDiscovery(AssetsParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<Account> list = accountMapper.selectListByMacAddress(param.getMacAddress());

        // 规则检测：如名字为guest、test、admin等，自动加入危险账号库
        for (Account acc : list) {
            String name = acc.getName().toLowerCase();
            String fullName = acc.getFullName() != null ? acc.getFullName().toLowerCase() : "";
            boolean isDanger = false;

            // 规则1：常见弱口令账号名
            if (Arrays.asList("guest", "test", "admin", "root").contains(name)) isDanger = true;

            // 规则2：全名或描述包含敏感词
            if (fullName.contains("test") || fullName.contains("guest") || fullName.contains("admin")) isDanger = true;

            // 规则3：未禁用且高危名
            if (acc.getDisabled() != null && acc.getDisabled() == 0 && Arrays.asList("guest", "test", "admin").contains(name)) isDanger = true;

            // 规则4：密码永不过期且高危名
            if (acc.getPasswordExpires() != null && acc.getPasswordExpires() == 0 && Arrays.asList("guest", "test", "admin").contains(name)) isDanger = true;

            // 规则5：SID类型为用户且高危名
            if (acc.getSidType() != null && acc.getSidType() == 1 && Arrays.asList("guest", "test", "admin").contains(name)) isDanger = true;

            // 规则6：账号已锁定
            if (acc.getLockout() != null && acc.getLockout() == 1) isDanger = true;

            // 规则7：账号名长度小于等于3且为纯数字或纯字母
            if (name.length() <= 2 && (name.matches("\\d+") || name.matches("[a-zA-Z]+"))) isDanger = true;

            if (isDanger && dangerAccountMapper.existsDangerAccount(name) == 0) {
                dangerAccountMapper.insertDangerAccount(name);
            }
        }

        // 批量查询危险账号
        List<String> dangerAccounts = dangerAccountMapper.selectAllDangerAccounts();
        Set<String> dangerSet = new HashSet<>(dangerAccounts);

        // 标记危险账号
        list.forEach(acc -> acc.setDanger(dangerSet.contains(acc.getName().toLowerCase())));

        PageInfo<Account> pageInfo = new PageInfo<>(list);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }


    @Override
    public ResponseResult serviceDiscovery(AssetsParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<Services> list = servicesMapper.selectByMacAddress(param.getMacAddress());

        // 规则检测：如服务名为telnet、ftp等，自动加入危险服务库
        for (Services svc : list) {
            String name = svc.getName().toLowerCase();
            boolean isDanger = false;

            // 规则1：常见高危服务
            if (Arrays.asList("telnet", "ftp", "rdp", "vnc", "smb").contains(name)) isDanger = true;

            // 你可以扩展更多规则

            if (isDanger && dangerServiceMapper.existsDangerService(name) == 0) {
                dangerServiceMapper.insertDangerService(name);
            }
        }

        // 批量查询危险服务
        List<String> dangerServices = dangerServiceMapper.selectAllDangerServices();
        Set<String> dangerSet = new HashSet<>(dangerServices);

        // 标记危险服务
        list.forEach(svc -> svc.setDanger(dangerSet.contains(svc.getName().toLowerCase())));

        PageInfo<Services> pageInfo = new PageInfo<>(list);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseResult processDiscovery(AssetsParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<Processes> list = processesMapper.selectByMacAddress(param.getMacAddress());
        PageInfo<Processes> pageInfo = new PageInfo<>(list);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseResult appDiscovery(AssetsParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<App> list = appMapper.selectByMacAddress(param.getMacAddress());
        PageInfo<App> pageInfo = new PageInfo<>(list);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }








}




