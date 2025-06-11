package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role/list")
    public ResponseResult roleList(MyParam param){
        return roleService.roleList(param);
    }

    @PostMapping("/role/del/{roleId}")
    public ResponseResult roleDelete(@PathVariable Integer roleId){
        return roleService.roleDelete(roleId);
    }

    @PostMapping("/role/add")
    public ResponseResult roleInsert(@RequestBody Role record){
        return roleService.roleInsert(record);
    }

    @PostMapping("/role/edit")
    public ResponseResult roleUpdate(@RequestBody Role record) {
        return roleService.roleUpdate(record);
    }

    @GetMapping("/role/{roleId}")
    public ResponseResult getRoleById(@PathVariable Integer roleId) {
        return roleService.selectById(roleId);
    }


}
