package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.response.ResponseResult;



public interface RoleService {

    public ResponseResult roleList(MyParam param);

    public ResponseResult roleDelete(Integer roleId);

    public ResponseResult roleInsert(Role record);

    public ResponseResult roleUpdate(Role record);

    public ResponseResult selectById(Integer roleId);



}
