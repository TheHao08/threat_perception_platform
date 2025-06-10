package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 35162
* @description 针对表【host】的数据库操作Mapper
* @createDate 2025-06-06 13:09:19
* @Entity com.tpp.threat_perception_platform.pojo.Host
*/
public interface HostMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Host record);

    int insertSelective(Host record);

    Host selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);

    Host selectByMAC(String mac);
    List<Host> findAll(@Param("param") MyParam param);

    void delete(@Param("ids") Integer[] ids);

    int updateByMAC(Host record);
}
