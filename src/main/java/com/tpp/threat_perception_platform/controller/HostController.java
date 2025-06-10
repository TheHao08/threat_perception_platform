package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HostController {
    @Autowired
    private HostService hostService;

//    @PostMapping("/host/list")
//    public ResponseResult hostList(MyParam param){
//        return hostService.hostList(param);
//    }

    @PostMapping("/host/list")
    public ResponseResult hostList(@RequestBody MyParam param, @RequestParam(required = false) List<String> fields) {
        ResponseResult result = hostService.hostList(param);

        // 如果 fields 不为空，则过滤结果
        if (fields != null && !fields.isEmpty()) {
            List<Map<String, Object>> filteredData = new ArrayList<>();
            for (Host host : (List<Host>) result.getData()) {
                Map<String, Object> filteredHost = new HashMap<>();
                if (fields.contains("status")) {
                    filteredHost.put("status", host.getStatus());
                }
                if (fields.contains("updatetime")) {
                    filteredHost.put("updatetime", host.getUpdatetime());
                }
                filteredData.add(filteredHost);
            }
            return new ResponseResult<>(result.getCode(), result.getMsg(), filteredData);
        }
        return result;
    }

    @PostMapping("/host/save")
    public ResponseResult hostSave(@RequestBody Host host){
        hostService.saveHost(host);
        return new ResponseResult<>(0, "添加成功！");
    }

    @PostMapping("/host/edit")
    public ResponseResult hostEdit(@RequestBody Host host){
        return hostService.edit(host);
    }


    @PostMapping("/host/delete")
    public ResponseResult hostEdit(@RequestParam("ids[]") Integer[] ids){
        return hostService.delete(ids);
    }

    @PostMapping("host/assets")
    public ResponseResult hostAssets(@RequestBody AssetsParam param){
        return hostService.assetsDiscovery(param);
    }


}
