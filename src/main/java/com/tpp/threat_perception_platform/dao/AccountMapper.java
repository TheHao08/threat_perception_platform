package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.Host;
import io.lettuce.core.dynamic.annotation.Param;
<<<<<<< HEAD

import java.util.List;

/**
 * @author bqs1
 * @description 针对表【account】的数据库操作Mapper
 * @createDate 2025-06-10 14:51:50
 * @Entity com.tpp.threat_perception_platform.pojo.Account
 */
=======
import java.util.List;
/**
* @author bqs1
* @description 针对表【account】的数据库操作Mapper
* @createDate 2025-06-10 14:51:50
* @Entity com.tpp.threat_perception_platform.pojo.Account
*/
>>>>>>> main
public interface AccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

<<<<<<< HEAD
=======
    List<Account> selectListByMacAddress(String macAddress);
>>>>>>> main
    Account selectByPrimaryKey(Long id);

    Account selectByMacAddress(String macAddress, String name);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

<<<<<<< HEAD
    List<Account> selectListByMac(@Param("mac") String macAddress);


=======
>>>>>>> main
}
