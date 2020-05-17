package com.itech.ups.app.system.manager.application.service;

import com.itech.ups.app.manager.application.domain.VersionManage;

import java.util.List;
import java.util.Map;


public interface VersionManageService {
    VersionManage addVersionManage(VersionManage versionManage);

    void deleteVersionManageById(String id);

    VersionManage findMaxVersion(String type);

    List<VersionManage> findVersionManage(Map<String, Object> params, int rowStart, int rowEnd);

    VersionManage findVersionManageById(String id);

    int getCount(Map<String, Object> params);

    void stopVersion(String id);

    void updateVersionManage(VersionManage versionManage);
}
