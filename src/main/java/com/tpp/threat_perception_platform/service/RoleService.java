package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.util.List;

public interface RoleService {
    //*角色列表

    public ResponseResult roleList(MyParam param);

    // 新增

    ResponseResult save(Role role);

    // 编辑
    ResponseResult edit(Role role);

    // 删除（支持批量）
    ResponseResult delete(List<Long> roleId);
}