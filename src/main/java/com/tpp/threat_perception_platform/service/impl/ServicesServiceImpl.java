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
        System.out.println(">> saveServices called with: mac = " + services.getMacAddress() + ", port = " + services.getPort());
        if (services.getMacAddress() == null || services.getPort() == null) {
            System.out.println(">> mac 或 port 为 null，跳过");
            return 0;
        }
        Services dbService = servicesMapper.selectByMacAddressAndPort(services.getMacAddress(), services.getPort());
        if (dbService != null) {
            services.setId(dbService.getId());
            int updated = servicesMapper.updateByPrimaryKeySelective(services);
            System.out.println(">> 已存在记录，更新结果: " + updated);
            return updated;
        } else {
            int inserted = servicesMapper.insertSelective(services);
            System.out.println(">> 插入新记录，插入结果: " + inserted);
            return inserted;
        }
    }

}