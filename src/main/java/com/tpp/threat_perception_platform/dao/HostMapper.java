package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
<<<<<<< HEAD
import com.tpp.threat_perception_platform.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author LEGION
* @description 针对表【host】的数据库操作Mapper
* @createDate 2025-06-06 15:30:17
=======
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
* @author bqs1
* @description 针对表【host(主机表)】的数据库操作Mapper
* @createDate 2025-06-06 11:12:19
>>>>>>> main
* @Entity com.tpp.threat_perception_platform.pojo.Host
*/
public interface HostMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Host record);

    int insertSelective(Host record);

    Host selectByPrimaryKey(Long id);
<<<<<<< HEAD
    Host selectByMacAddress(String macAddress);

=======

    /**
     * 根据主机的mac地址查询主机信息
     * @param macAddress 主机的mac地址
     * @return 返回主机信息
     */
    Host selectByMacAddress(String macAddress);
>>>>>>> main

    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);

    List<Host> findAll(@Param("param") MyParam param);
<<<<<<< HEAD


    List<Host> selectByHostNameLike(String hostName);

    int updateByMacAddress(Host host);


=======
    /**
     * 更新主机的状态为离线
     * @param time 离线时间
     * @return 返回影响的行数
     */
    //int updateStatusOffline(@Param("time") Timestamp time);
    int updateByMacAddress(Host host); //根据mac地址更新主机信息
>>>>>>> main
}
