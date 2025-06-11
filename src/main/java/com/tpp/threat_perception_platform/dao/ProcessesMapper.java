package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.Processes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bqs1
* @description 针对表【processes】的数据库操作Mapper
* @createDate 2025-06-10 16:55:31
* @Entity com.tpp.threat_perception_platform.pojo.Processes
*/
public interface ProcessesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Processes record);

    int insertSelective(Processes record);

    Processes selectByPrimaryKey(Long id);

    Processes selectByMacAddressAndPid(@Param("macAddress")String  macAddress,@Param("pid") Integer pid);

    int updateByPrimaryKeySelective(Processes record);

    int updateByPrimaryKey(Processes record);

    List<Processes> selectByMacAddress(String macAddress);
}
