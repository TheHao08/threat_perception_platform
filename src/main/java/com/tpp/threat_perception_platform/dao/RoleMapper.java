package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
<<<<<<< HEAD
* @author LEGION
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-06-04 21:48:33
=======
* @author bqs1
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-06-04 18:34:07
>>>>>>> main
* @Entity com.tpp.threat_perception_platform.pojo.Role
*/
public interface RoleMapper {

<<<<<<< HEAD
    int deleteByPrimaryKey(Integer roleId);
=======
    int deleteByPrimaryKey(Long id);
>>>>>>> main

    int insert(Role record);

    int insertSelective(Role record);

<<<<<<< HEAD
    Role selectByPrimaryKey(Integer roleId);
=======
    Role selectByPrimaryKey(Long id);
>>>>>>> main

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

<<<<<<< HEAD
    List<Role> findAll(@Param("param") MyParam param);

=======
    /**
     * *查询所有角色
     * @param param
     * @return
     */
    List<Role> findAll(@Param("param") MyParam param);
>>>>>>> main
}
