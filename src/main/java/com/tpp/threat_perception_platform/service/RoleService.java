package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;

import com.tpp.threat_perception_platform.response.ResponseResult;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    /**
     * 用户列表
     * @param param
     * @return
     */
    ResponseResult roleList(MyParam param);

    /**
     * 更新用户
     * @param role
     */
    void updateRole(Role role);

    /**
     * 保存用户
     * @param role
     * @return
     */
    ResponseResult save(Role role);

    /**
     * 编辑用户
     * @param role
     * @return
     */
    ResponseResult edit(Role role);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    ResponseResult delete(Integer[] ids);
}
