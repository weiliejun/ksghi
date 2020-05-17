package com.itech.ups.app.business.push.application.infrastructure;

import com.itech.ups.app.apppushmanage.application.domain.AppPushManage;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AppPushManageRepository extends AbstractRepositoryParent {

    public AppPushManage addAppPushManage(AppPushManage appPushManage) {
        appPushManage.setId(generateIdentifier());
        sqlMapClientTemplate.insert("push.insertAppPushManage", appPushManage);
        return appPushManage;
    }

    public void deleteAppPushManageById(String id) {
        sqlMapClientTemplate.delete("push.deleteAppPushManage", id);
    }

    @SuppressWarnings("unchecked")
    public List<AppPushManage> findAppPushManage(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<AppPushManage>) sqlMapClientTemplate.queryForList("push.selectAppPushManage", params);
    }

    public AppPushManage findAppPushManageById(String id) {
        AppPushManage appPushManage = (AppPushManage) sqlMapClientTemplate.queryForObject("push.selectAppPushManageById", id);
        return appPushManage;
    }

    public int findAppPushManageCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("push.selectAppPushManageCount", params);
    }

    public void updateAppPushManage(AppPushManage appPushManage) {
        sqlMapClientTemplate.update("push.updateAppPushManage", appPushManage);
    }

    public void updateStatusById(AppPushManage appPushManage) {
        sqlMapClientTemplate.update("push.updateStatusById", appPushManage);
    }
}
