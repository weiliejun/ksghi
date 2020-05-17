package com.itech.ups.app.system.manager.application.service;

import com.itech.ups.app.manager.application.domain.VersionManage;
import com.itech.ups.app.system.manager.application.infrastructure.VersionManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("versionManageService")
public class VersionManageServiceImpl implements VersionManageService {

    @Resource
    private VersionManageRepository versionManageRepository;

    @Override
    public VersionManage addVersionManage(VersionManage versionManage) {
        return versionManageRepository.addVersionManage(versionManage);
    }

    @Override
    public void deleteVersionManageById(String id) {
        versionManageRepository.deleteVersionManageById(id);
    }

    @Override
    public VersionManage findMaxVersion(String type) {
        return versionManageRepository.findMaxVersion(type);
    }

    @Override
    public List<VersionManage> findVersionManage(Map<String, Object> params, int rowStart, int rowEnd) {
        return versionManageRepository.findVersionManage(params, rowStart, rowEnd);
    }

    @Override
    public VersionManage findVersionManageById(String id) {
        return versionManageRepository.findVersionManageById(id);
    }

    @Override
    public int getCount(Map<String, Object> params) {
        return versionManageRepository.getCount(params);
    }

    @Override
    public void stopVersion(String id) {
        versionManageRepository.stopVersion(id);
    }

    @Override
    public void updateVersionManage(VersionManage versionManage) {
        versionManageRepository.updateVersionManage(versionManage);
    }

}
