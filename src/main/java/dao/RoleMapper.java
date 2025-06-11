package dao;

import com.tpp.threat_perception_platform.pojo.Role;

/**
* @author bqs1
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-06-04 16:50:58
* @Entity com.tpp.threat_perception_platform.pojo.Role
*/
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}
