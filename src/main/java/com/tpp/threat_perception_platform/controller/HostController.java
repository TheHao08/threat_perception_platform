package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.dao.*;
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ServicesMapper servicesMapper;
    @Autowired
    private ProcessesMapper processesMapper;
    @Autowired
    private AppMapper appMapper;
    @Autowired
    private HostMapper hostMapper;
    /**
     * 获取主机列表
     * @param param 主机信息
     * @return 返回影响的行数
     */
    @PostMapping("/host/list")
    public ResponseResult hostList(MyParam param) {
        return hostService.hostList(param);
    }


    @PostMapping("/host/delete")
    public ResponseResult delete(@RequestParam("ids[]") List<Long> id) {
        return hostService.delete(id);
    }

    /**
     * 资产发现
     * @param param 主机信息
     * @return 返回影响的行数
     */

    @PostMapping("/host/assetsDiscovery")
    public ResponseResult assetDiscovery(@RequestBody AssetsParam param) {
        return hostService.assetsDiscovery(param);
    }

    @PostMapping("/host/accountDiscovery")
    public ResponseResult accountDiscovery(@RequestBody AssetsParam param) {
        return hostService.accountDiscovery(param);
    }

    @PostMapping("/host/serviceDiscovery")
    public ResponseResult serviceDiscovery(@RequestBody AssetsParam param) {
        return hostService.serviceDiscovery(param);
    }

    @PostMapping("/host/processDiscovery")
    public ResponseResult processDiscovery(@RequestBody AssetsParam param) {
        return hostService.processDiscovery(param);
    }


    @PostMapping("/host/appDiscovery")
    public ResponseResult appDiscovery( @RequestBody AssetsParam param) {
        return hostService.appDiscovery(param);
    }

//    @PostMapping("/host/heartbeat")
//    public ResponseResult heartbeat(@RequestParam("macAddress") String macAddress) {
//        return hostService.heartbeat(macAddress);
//    }
}
