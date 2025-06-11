package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.ServicesMapper;
import com.tpp.threat_perception_platform.pojo.Services;
import com.tpp.threat_perception_platform.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesMapper servicesMapper;

    @Override
    public int saveServices(Services services) {
        if (services.getMacAddress() == null || services.getPort() == null) {
            return 0;
        }
        // 先查找是否已存在
        Services dbService = servicesMapper.selectByMacAddressAndPort(services.getMacAddress(), services.getPort());
        if (dbService != null) {
            services.setId(dbService.getId());
            return servicesMapper.updateByPrimaryKeySelective(services);
        } else {
            return servicesMapper.insertSelective(services);
        }
    }
}