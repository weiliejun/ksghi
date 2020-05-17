package com.itech.ups.app.business.appLogo.application.infrastruture;

import com.itech.ups.app.appLogo.application.domain.AppLogoManage;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AppLogoManageRepository extends AbstractRepositoryParent {

    public AppLogoManage addAppLogoManage(AppLogoManage appLogoManage) {
        appLogoManage.setId(generateIdentifier());
        sqlMapClientTemplate.insert("logo.insertAppLogoManage", appLogoManage);
        return appLogoManage;
    }

    public List<AppLogoManage> findAppLogoManage(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<AppLogoManage>) sqlMapClientTemplate.queryForList("logo.selectAppLogoManage", params);
    }

    public AppLogoManage findAppLogoManageById(String id) {
        AppLogoManage appLogoManage = (AppLogoManage) sqlMapClientTemplate.queryForObject("logo.selectAppLogoManageById", id);
        return appLogoManage;
    }

    public int findAppLogoManageCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("logo.selectAppLogoManageTotalCount", params);
    }

    public AppLogoManage updateAppLogoManage(AppLogoManage appLogoManage) {
        sqlMapClientTemplate.update("logo.updateAppLogoManage", appLogoManage);
        return appLogoManage;
    }

}
