package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/host/list")
    public ResponseResult List(MyParam param){
        return hostService.hostList(param);
    }

    @PostMapping("/host/searchById")
    public ResponseResult<List<Host>> searchById(@RequestBody Map<String, Integer> map) {
        Integer id = map.get("id");
        Host host = hostService.findById(id);
        if (host == null) {
            return ResponseResult.okResult(new ArrayList<>());
        }
        return ResponseResult.okResult(Collections.singletonList(host));
    }

    @PostMapping("/host/searchByMac")
    public ResponseResult<List<Host>> searchByMac(@RequestBody Map<String, String> map) {
        String mac = map.get("macAddress");
        Host host = hostService.findByMacAddress(mac);
        if (host == null) {
            return ResponseResult.okResult(new ArrayList<>());
        }
        return ResponseResult.okResult(Collections.singletonList(host));
    }

    @PostMapping("/host/searchByName")
    public ResponseResult<List<Host>> searchByHostName(@RequestBody Map<String, String> map) {
        String name = map.get("hostName");
        List<Host> list = hostService.findByHostNameLike(name);
        return ResponseResult.okResult((long) list.size(), list);
    }

    @PostMapping("/host/delete")
    public ResponseResult deleteHost(@RequestBody Map<String, Long> map) {
        Long id = map.get("id");
        int result = hostService.deleteById(id);
        if (result > 0) {
            return new ResponseResult<>(0, "删除成功");
        } else {
            return new ResponseResult<>(500, "删除失败或数据不存在");
        }
    }

    @PostMapping("/host/assetsDiscovery")
    public ResponseResult assetsDiscovery(@RequestBody AssetsParam param){
        return hostService.assetsDiscovery(param);
    }





    @PostMapping("/host/info")
    public Map<String, Object> getHostInfo(@RequestBody Map<String, String> req) {
        String mac = req.get("macAddress");

        Map<String, Object> data = new HashMap<>();
        data.put("host_name", "WIN-12345");
        data.put("mac_address", mac);

        return Map.of(
                "code", 0,
                "msg", "ok",
                "data", List.of(data) // ⚠️ 返回格式也统一为 data: []
        );
    }

//    @PostMapping("/host/accountList")
//    public Map<String, Object> getAccounts(@RequestBody Map<String, String> req) {
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(Map.of(
//                "name", "Administrator",
//                "full_name", "系统管理员",
//                "sid", "S-1-5-21-123456",
//                "sid_type", 1,
//                "status", "正常",
//                "disabled", false,
//                "lockout", false,
//                "password_changeable", true,
//                "password_expires", false,
//                "password_required", true
//        ));
//
//        return Map.of(
//                "code", 0,
//                "msg", "ok",
//                "data", list
//        );
//    }
//
//    @PostMapping("/host/serviceList")
//    public Map<String, Object> getServices(@RequestBody Map<String, String> req) {
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(Map.of(
//                "protocol", "TCP",
//                "port", 3389,
//                "state", "open",
//                "name", "Remote Desktop",
//                "product", "Microsoft RDP",
//                "version", "10.0",
//                "extrainfo", "远程桌面服务"
//        ));
//
//        return Map.of(
//                "code", 0,
//                "msg", "ok",
//                "data", list
//        );
//    }
//
//    @PostMapping("/host/processList")
//    public Map<String, Object> getProcesses(@RequestBody Map<String, String> req) {
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(Map.of(
//                "pid", 1234,
//                "ppid", 1,
//                "name", "explorer.exe",
//                "cmd", "C:\\Windows\\explorer.exe",
//                "priority", 8,
//                "description", "Windows 资源管理器"
//        ));
//
//        return Map.of(
//                "code", 0,
//                "msg", "ok",
//                "data", list
//        );
//    }
//
//    @PostMapping("/host/appList")
//    public Map<String, Object> getAppList(@RequestBody Map<String, String> req) {
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(Map.of(
//                "display_name", "Google Chrome",
//                "install_location", "C:\\Program Files\\Google\\Chrome",
//                "uninstall_string", "\"C:\\Program Files\\Google\\Chrome\\setup.exe\" --uninstall"
//        ));
//
//        return Map.of(
//                "code", 0,
//                "msg", "ok",
//                "data", list
//        );
//    }
}






