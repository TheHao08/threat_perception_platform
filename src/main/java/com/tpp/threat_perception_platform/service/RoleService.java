package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
<<<<<<< HEAD
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.response.ResponseResult;



public interface RoleService {

    public ResponseResult roleList(MyParam param);

    public ResponseResult roleDelete(Integer roleId);

    public ResponseResult roleInsert(Role record);

    public ResponseResult roleUpdate(Role record);

    public ResponseResult selectById(Integer roleId);



}
=======
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
>>>>>>> main
