package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.RoleMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResponseResult roleList(MyParam param) {
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<Role> roleList = roleMapper.findAll(param);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return new ResponseResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseResult save(Role role) {
        int res = roleMapper.insertSelective(role);
        if (res > 0) {
            return new ResponseResult<>(0, "添加成功");
        }
        return new ResponseResult<>(1, "添加失败");
    }

    @Override
    public ResponseResult edit(Role role) {
        int res = roleMapper.updateByPrimaryKeySelective(role);
        if (res > 0) {
            return new ResponseResult<>(0, "修改成功");
        }
        return new ResponseResult<>(1, "修改失败");
    }

    @Override
    public ResponseResult delete(List<Long> roleId) {
        int count = 0;
        for (Long id : roleId) {
            count += roleMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return new ResponseResult<>(0, "删除成功");
        }
        return new ResponseResult<>(1, "删除失败");
    }
}