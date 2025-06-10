package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import com.tpp.threat_perception_platform.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    /**
     * 角色列表
     * @param param
     * @return
     */
    @PostMapping("/role/list")
    public ResponseResult roleList(MyParam param){
        return roleService.roleList(param);
    }

    /**
     * 添加用户
     * @param role
     * @return
     */
    @PostMapping("/role/save")
    public ResponseResult roleSave(@RequestBody Role role){
        return roleService.save(role);
    }
    /**
     * 编辑用户
     * @param role
     * @return
     */
    @PostMapping("/role/edit")
    public ResponseResult roleEdit(@RequestBody Role role){
        return roleService.edit(role);
    }

    /**
     * 删除用户
     * @param
     * @return
     */
    @PostMapping("/role/delete")
    public ResponseResult roleEdit(@RequestParam("ids[]") Integer[] ids){
        return roleService.delete(ids);
    }




}
