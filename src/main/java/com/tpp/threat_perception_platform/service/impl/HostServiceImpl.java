package com.tpp.threat_perception_platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.HostMapper;
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import com.tpp.threat_perception_platform.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostMapper hostMapper;

    @Autowired
    private RabbitService rabbitService;
    @Override
    public int saveHost(Host host) {
        //判断是否mac为空
        if(host.getMac().equals("")||host.getMac()==null){
            return 1;
        }

        //有无mac地址已经存入了
        Host db_host = hostMapper.selectByMAC(host.getMac());
        //1.已经存入了(更新)
        if(db_host!=null)
        {
            host.setId(db_host.getId());
            host.setStatus(1);
            host.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            return hostMapper.updateByPrimaryKeySelective(host);
        }
        //2.没存入(保存)
        else {
             //为每个新来的主机创建一个队列
             String queueName = "agent_"+host.getMac().replace(":","")+"_queue";
             String routingKey = host.getMac().replace(":","");
             rabbitService.createAgentQueue("agent_exchange", queueName, routingKey);

             //修改状态和创建时间
             host.setStatus(1);
             host.setCreatetime(new Timestamp(System.currentTimeMillis()));

             return hostMapper.insertSelective(host);
        }

    }

    @Override
    public ResponseResult hostList(MyParam param) {
        // 设置分页参数
        PageHelper.startPage(param.getPage(), param.getLimit());
        // 查询所有
        List<Host> hostlist = hostMapper.findAll(param);

        for (Host host : hostlist) {
            //updatetime为空
            if (host.getUpdatetime() == null) {
                //
                host.setStatus(0);
                continue;
            }
            //updatetime不为空
            //如果当前时间减去更新时间大于4分钟，则设置状态为0
            long currentTime = System.currentTimeMillis();
            long updateTime = host.getUpdatetime().getTime();
            long timeDifference = currentTime - updateTime;
            if (timeDifference > 4 * 60 * 1000) { // 4分钟
                host.setStatus(0);
            } else {
                host.setStatus(1);
            }
            //修改数据库中对应的host的status
            hostMapper.updateByPrimaryKeySelective(host);


        }


        // 构架pageInfo
        PageInfo<Host> pageInfo = new PageInfo<>(hostlist);

        return new ResponseResult<>(pageInfo.getTotal(), pageInfo.getList());
    }



    @Override
    public ResponseResult edit(Host host) {
        //权限校验
        //设置修改时间
        host.setUpdatetime(new Timestamp(System.currentTimeMillis()));
        hostMapper.updateByPrimaryKeySelective(host);
        return new ResponseResult<>(0, "编辑成功！");
    }

    @Override
    public ResponseResult delete(Integer[] ids) {
        hostMapper.delete(ids);
        return new ResponseResult<>(0, "删除成功！");
    }

    @Override
    public int updateHost(Host host) {
        host.setUpdatetime(new Timestamp(System.currentTimeMillis()));
        return hostMapper.updateByMAC(host);
    }

    @Override
    public ResponseResult assetsDiscovery(AssetsParam param) {
        //查询主机信息
        Host host = hostMapper.selectByMAC(param.getMac());

        //根据当前时间和updatetime做比较(4min)判断主机是否在线
        if(host == null || host.getUpdatetime()==null||new Date().getTime() - host.getUpdatetime().getTime() > 4 * 60 * 1000) {
            return new ResponseResult<>(1003, "主机不在线或不存在，请检查主机状态！");
        }

        //构造发送的消息
        String data = JSON.toJSONString(param);

        //发送消息到rabbitMQ
        rabbitService.sendMessage("agent_exchange", host.getMac().replace(":",""), data);

        return new ResponseResult<>(0, "资产发现请求已发送！");
    }
}
