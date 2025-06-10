package com.tpp.threat_perception_platform.service;

import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.User;
import com.tpp.threat_perception_platform.pojo.UserDto;
import com.tpp.threat_perception_platform.response.ResponseResult;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 用户列表
     * @param param
     * @return
     */
    //esponseResult userList(MyParam param);
    ResponseResult<PageInfo<UserDto>> userList(MyParam param);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 保存用户
     * @param user
     * @return
     */
    ResponseResult save(User user);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    ResponseResult edit(User user);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    ResponseResult delete(Integer[] ids);
}
