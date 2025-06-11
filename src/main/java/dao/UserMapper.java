package dao;

import com.tpp.threat_perception_platform.pojo.User;

/**
* @author bqs1
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-06-04 16:57:56
* @Entity com.tpp.threat_perception_platform.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
