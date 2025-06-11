package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.lang.module.ResolutionException;
import java.util.List;

public interface HostService {
    public int saveHost(Host host);

    public ResponseResult hostList(MyParam param);

    Host findById(Integer id);

    Host findByMacAddress(String mac);

    List<Host> findByHostNameLike(String hostName);

    int deleteById(Long id);

    public int updateHostByMacAddress(Host host);

    public ResponseResult assetsDiscovery(AssetsParam param);


}

