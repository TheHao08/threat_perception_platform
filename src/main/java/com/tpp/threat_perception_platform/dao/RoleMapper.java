package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bqs1
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-06-04 18:34:07
* @Entity com.tpp.threat_perception_platform.pojo.Role
*/
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * *查询所有角色
     * @param param
     * @return
     */
    List<Role> findAll(@Param("param") MyParam param);
}
