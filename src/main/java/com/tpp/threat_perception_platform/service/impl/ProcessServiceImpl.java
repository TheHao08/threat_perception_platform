package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.ProcessesMapper;
import com.tpp.threat_perception_platform.pojo.Processes;
import com.tpp.threat_perception_platform.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessesMapper processMapper;

    @Override
    public int save(Processes process) {
        if (process.getMacAddress() == null || process.getPid() == null) {
            return 0;
        }
        Processes dbProcess = processMapper.selectByMacAddressAndPid(process.getMacAddress(),process.getPid());
        //
        if (dbProcess != null) {
            process.setId(dbProcess.getId());
            return processMapper.updateByPrimaryKeySelective(process);
        } else {
            return processMapper.insertSelective(process);
        }
    }
}