package com.tpp.threat_perception_platform.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.HostMapper;
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import com.tpp.threat_perception_platform.service.RabbitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostMapper hostMapper;

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public int saveHost(Host host) {

        // 合法性校验，避免空数据
        if (host.getMacAddress() == null || host.getIpAddress() == null || host.getIpAddress().equals("")) {
            return 0;
        }

        Host dbHost = hostMapper.selectByMacAddress(host.getMacAddress());
        Timestamp now = new Timestamp(System.currentTimeMillis());

        if (dbHost != null) {
            // 存在则更新
            host.setId(dbHost.getId());
            host.setStatus(1);
            host.setUpdateTime(now);
            return hostMapper.updateByPrimaryKeySelective(host);
        } else {


            String queueName = "agent_" + host.getMacAddress().replace(":", "") + "_queue";
            String routingKey = host.getMacAddress().replace(":", "");
            rabbitService.createAgentQueue("agent_exchange", queueName, routingKey);

            // 不存在则新增
            host.setStatus(1);
            host.setCreateTime(now);
            return hostMapper.insertSelective(host);
        }
    }




    @Override
    public ResponseResult hostList(MyParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        // 查询所有
        List<Host> hostList = hostMapper.findAll(param);

        for(Host host : hostList){
            Date updateTime = host.getUpdateTime();;

            if(updateTime == null){
                host.setStatus(0);
                continue;
            }

            if(new Date().getTime() - updateTime.getTime() > 4000){
                host.setStatus(0);
                continue;
            }
        }
        // 构架pageInfo
        PageInfo<Host> pageInfo = new PageInfo<>(hostList);

        return new ResponseResult<>(pageInfo.getTotal(), pageInfo.getList());

    }


    @Override
    public Host findById(Integer id) {
        return hostMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public Host findByMacAddress(String mac) {
        return hostMapper.selectByMacAddress(mac);
    }

    @Override
    public List<Host> findByHostNameLike(String hostName) {
        return hostMapper.selectByHostNameLike(hostName);
    }

    @Override
    public int deleteById(Long id) {
        return hostMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateHostByMacAddress(Host host) {
        host.setStatus(1);
        host.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return hostMapper.updateByMacAddress(host);
    }

    @Override
    public ResponseResult assetsDiscovery(AssetsParam param) {

        if (!param.getAccount().equals(0) && !param.getAccount().equals(1)) {
            return new ResponseResult(1004, "参数有误！");
        }

        // 通过mac地址去查询主机信息
        Host dbHost = hostMapper.selectByMacAddress(param.getMacAddress());
        // 利用当前的时间和更新时间进行对比来判断主机是否在线
        if (dbHost == null || dbHost.getUpdateTime() == null || new Date().getTime() - dbHost.getUpdateTime().getTime() > 4000) {
            return new ResponseResult(1003, "主机不在线！");
        }
        param.setType("assets");
        // 将param转换成JSON字符串
        String data = JSON.toJSONString(param);
        // 组装队列的名字
        String routingKey = param.getMacAddress().replace(":", "");
        rabbitService.sendMessage("agent_exchange", routingKey, data);

        return new ResponseResult(0, "资产探测任务已下发，请稍后查看！");
    }



}
