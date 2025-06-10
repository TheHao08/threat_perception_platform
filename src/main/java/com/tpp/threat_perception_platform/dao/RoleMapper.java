package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 35162
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-06-04 16:49:54
* @Entity com.tpp.threat_perception_platform.pojo.Role
*/
@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    Role selectByRoleName(@Param("roleName") String roleName);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll(@Param("param") MyParam param);

    void delete(@Param("ids") Integer[] ids);
}
