package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bqs1
 * @description 针对表【app】的数据库操作Mapper
 * @createDate 2025-06-10 19:46:24
 * @Entity com.tpp.threat_perception_platform.pojo.App
 */
public interface AppMapper {

    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    App selectByMacAddressAndDisplayName(@Param("macAddress") String macAddress, @Param("displayName") String displayName);

    List<App> selectByMacAddress(String macAddress);
}
