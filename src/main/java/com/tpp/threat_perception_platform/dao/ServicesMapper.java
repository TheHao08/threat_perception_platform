package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.Services;
import org.apache.ibatis.annotations.Param;

/**
* @author bqs1
* @description 针对表【services】的数据库操作Mapper
* @createDate 2025-06-10 16:35:35
* @Entity com.tpp.threat_perception_platform.pojo.Services
*/
public interface ServicesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);

    Services selectByMacAddressAndPort(@Param("macAddress")String macAddress,@Param("port") Integer port);
}
