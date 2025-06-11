package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.DangerApp;

import java.util.List;

/**
* @author bqs1
* @description 针对表【danger_app】的数据库操作Mapper
* @createDate 2025-06-11 15:56:05
* @Entity com.tpp.threat_perception_platform.pojo.DangerApp
*/
public interface DangerAppMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DangerApp record);

    int insertSelective(DangerApp record);

    DangerApp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DangerApp record);

    int updateByPrimaryKey(DangerApp record);

    int existsDangerApp(String displayName);

    void insertDangerApp(String displayName);

    List<String> selectAllDangerApps();
}
