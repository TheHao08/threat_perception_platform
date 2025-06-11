package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.DangerProcess;

import java.util.List;

/**
* @author bqs1
* @description 针对表【danger_process】的数据库操作Mapper
* @createDate 2025-06-11 15:56:21
* @Entity com.tpp.threat_perception_platform.pojo.DangerProcess
*/
public interface DangerProcessMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DangerProcess record);

    int insertSelective(DangerProcess record);

    DangerProcess selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DangerProcess record);

    int updateByPrimaryKey(DangerProcess record);

    int existsDangerProcess(String name);

    void insertDangerProcess(String name);

    List<String> selectAllDangerProcesses();
}
