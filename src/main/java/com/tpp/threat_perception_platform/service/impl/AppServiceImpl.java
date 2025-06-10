package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.AppMapper;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;

    @Override
    public int save(App app) {
        if (app.getMacAddress() == null || app.getDisplayName() == null) {
            return 0;
        }
        App dbApp = appMapper.selectByMacAddressAndDisplayName(app.getMacAddress(), app.getDisplayName());
        if (dbApp != null) {
            app.setId(dbApp.getId());
            return appMapper.updateByPrimaryKeySelective(app);
        } else {
            return appMapper.insertSelective(app);
        }
    }
}