package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.DangerAccount;

import java.util.List;

/**
* @author bqs1
* @description 针对表【danger_account】的数据库操作Mapper
* @createDate 2025-06-11 15:08:21
* @Entity com.tpp.threat_perception_platform.pojo.DangerAccount
*/
public interface DangerAccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DangerAccount record);

    int insertSelective(DangerAccount record);

    DangerAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DangerAccount record);

    int updateByPrimaryKey(DangerAccount record);

    List<String> selectAllDangerAccounts();

    int existsDangerAccount(String name);

    void insertDangerAccount(String name);
}
