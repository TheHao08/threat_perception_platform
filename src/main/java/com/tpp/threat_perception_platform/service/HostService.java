package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.response.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public interface HostService {

    //增
    int saveHost(Host host);

    //查
    ResponseResult hostList(MyParam param);



    //改
    ResponseResult edit(Host host);

    //删
    ResponseResult delete(Integer[] ids);

    int updateHost(Host host);

    //获取主机信息

    ResponseResult assetsDiscovery(AssetsParam param);
}
