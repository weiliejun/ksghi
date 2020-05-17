package com.itech.ups.app.business.appLogo.application.service;

import com.itech.ups.app.appLogo.application.domain.AppLogoManage;

import java.util.List;
import java.util.Map;


public interface AppLogoManageService {

    AppLogoManage addAppLogoManage(AppLogoManage appLogoManage);

    void deleteAppLogoManage(AppLogoManage appLogoManage);

    AppLogoManage editAppLogoManage(AppLogoManage appLogoManage);

    List<AppLogoManage> findAppLogoManage(Map<String, Object> params, int rowStart, int rowEnd);

    AppLogoManage findAppLogoManageById(String id);

    long findAppLogoManageCount(Map<String, Object> params);

}