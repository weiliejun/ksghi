package com.itech.ups.app.business.push.application.service;

import com.itech.ups.app.apppushmanage.application.domain.AppPushManage;

import java.util.List;
import java.util.Map;


public interface AppPushManageService {
    AppPushManage addAppPushManage(AppPushManage appPushManage);

    void deleteAppPushManageById(String id);

    List<AppPushManage> findAppPushManage(Map<String, Object> params, int rowStart, int rowEnd);

    AppPushManage findAppPushManageById(String id);

    int findAppPushManageCount(Map<String, Object> params);

    void updateAppPushManage(AppPushManage appPushManage);

    void updateStatusById(AppPushManage appPushManage);

    // app推送消息给所有设备（信鸽）
    Map<String, ?> pushAllDeviceByXG(AppPushManage appPushManage);
    // 查询消息推送状态
    // JSONObject queryPushStatus();
    // 查询设备数量
    // JSONObject queryDeviceCount();

    // app推送消息给所有设备（小米）
    Map<String, ?> pushAllDeviceByXM(AppPushManage appPushManage);
}