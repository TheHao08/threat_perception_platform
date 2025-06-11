package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role/list")
    public ResponseResult roleList(MyParam param) {
        return roleService.roleList(param);
    }

    @PostMapping("/role/save")
    public ResponseResult save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PostMapping("/role/edit")
    public ResponseResult edit(@RequestBody Role role) {
        return roleService.edit(role);
    }

    @PostMapping("/role/delete")
    public ResponseResult delete(@RequestParam("ids[]") List<Long> ids) {
        return roleService.delete(ids);
    }
}