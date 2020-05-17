package com.itech.ups.app.business.appLogo.application.service;

import com.itech.ups.app.appLogo.application.domain.AppLogoManage;
import com.itech.ups.app.business.appLogo.application.infrastruture.AppLogoManageRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2015-08-30
 * @author  苏冰雪
 * ===========================================================================
 *
 */
@Service("AppLogoManageService")
public class AppLogoManageServiceImpl extends AbstractServiceParent implements AppLogoManageService {
    @Autowired
    private AppLogoManageRepository repository;

    @Override
    public AppLogoManage addAppLogoManage(AppLogoManage appLogoManage) {
        appLogoManage.setDataStatus("valid"); // invalid-删除 valid有效
        return repository.addAppLogoManage(appLogoManage);
    }

    @Override
    public void deleteAppLogoManage(AppLogoManage appLogoManage) {
        appLogoManage.setDataStatus("invalid");
        repository.updateAppLogoManage(appLogoManage);
    }

    @Override
    public AppLogoManage editAppLogoManage(AppLogoManage appLogoManage) {
        return repository.updateAppLogoManage(appLogoManage);
    }

    @Override
    public List<AppLogoManage> findAppLogoManage(Map<String, Object> params, int rowStart, int rowEnd) {
        return repository.findAppLogoManage(params, rowStart, rowEnd);
    }

    @Override
    public AppLogoManage findAppLogoManageById(String id) {
        return repository.findAppLogoManageById(id);
    }

    @Override
    public long findAppLogoManageCount(Map<String, Object> params) {
        return repository.findAppLogoManageCount(params);
    }

}