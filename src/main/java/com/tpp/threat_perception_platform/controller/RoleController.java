package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
@RestController
public class RoleController {
=======
import java.util.List;

@RestController
public class RoleController {

>>>>>>> main
    @Autowired
    private RoleService roleService;

    @PostMapping("/role/list")
<<<<<<< HEAD
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
=======
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
>>>>>>> main
