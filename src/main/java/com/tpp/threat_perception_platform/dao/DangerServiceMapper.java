package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.DangerService;

import java.util.List;

/**
* @author bqs1
* @description 针对表【danger_service】的数据库操作Mapper
* @createDate 2025-06-11 15:56:34
* @Entity com.tpp.threat_perception_platform.pojo.DangerService
*/
public interface DangerServiceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DangerService record);

    int insertSelective(DangerService record);

    DangerService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DangerService record);

    int updateByPrimaryKey(DangerService record);

    int existsDangerService(String name);

    void insertDangerService(String name);

    List<String> selectAllDangerServices();
}
