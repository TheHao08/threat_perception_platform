package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.RoleMapper;
import com.tpp.threat_perception_platform.dao.UserMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import com.tpp.threat_perception_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseResult roleList(MyParam param) {
        // 设置分页参数
        PageHelper.startPage(param.getPage(), param.getLimit());
        // 查询所有
        List<Role> roleList = roleMapper.findAll(param);
        // 构架pageInfo
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);

        return new ResponseResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseResult roleDelete(Integer roleId) {
        int res = roleMapper.deleteByPrimaryKey(roleId);
        if(res > 0){
            return new ResponseResult(0, "删除成功");
        }
        return new ResponseResult(1001,"删除失败");
    }

    @Override
    public ResponseResult roleInsert(Role record) {
        int result = roleMapper.insert(record);
        if (result > 0) {
            return new ResponseResult(0, "添加角色成功");
        } else {
            return new ResponseResult(1, "添加角色失败");
        }
    }

    @Override
    public ResponseResult roleUpdate(Role record) {
        int result = roleMapper.updateByPrimaryKey(record);
        if (result > 0) {
            return new ResponseResult(0, "修改成功");
        } else {
            return new ResponseResult(1, "修改失败");
        }
    }


    @Override
    public ResponseResult selectById(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role != null) {
            return new ResponseResult(0, "查询成功", role);
        } else {
            return new ResponseResult(1, "未找到对应角色");
        }
    }




}


