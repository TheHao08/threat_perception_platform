package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.Services;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
<<<<<<< HEAD
 * @author bqs1
 * @description 针对表【services】的数据库操作Mapper
 * @createDate 2025-06-10 16:35:35
 * @Entity com.tpp.threat_perception_platform.pojo.Services
 */
=======
* @author bqs1
* @description 针对表【services】的数据库操作Mapper
* @createDate 2025-06-10 16:35:35
* @Entity com.tpp.threat_perception_platform.pojo.Services
*/
>>>>>>> main
public interface ServicesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);

    Services selectByMacAddressAndPort(@Param("macAddress")String macAddress,@Param("port") Integer port);

<<<<<<< HEAD
    List<Services> selectListByMac(String macAddress);
=======
    List<Services> selectByMacAddress(String macAddress);
>>>>>>> main
}
