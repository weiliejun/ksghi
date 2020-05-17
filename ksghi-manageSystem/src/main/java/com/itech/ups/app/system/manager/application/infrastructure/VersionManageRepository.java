package com.itech.ups.app.system.manager.application.infrastructure;

import com.itech.ups.app.manager.application.domain.VersionManage;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VersionManageRepository extends AbstractRepositoryParent {

    public VersionManage addVersionManage(VersionManage versionManage) {
        versionManage.setId(generateIdentifier());
        sqlMapClientTemplate.insert("versionmanage.insertVersionManage", versionManage);
        return versionManage;
    }

    public void deleteVersionManageById(String id) {
        sqlMapClientTemplate.delete("versionmanage.deleteVersionManage", id);
    }

    public VersionManage findMaxVersion(String type) {
        return (VersionManage) sqlMapClientTemplate.queryForObject("versionmanage.selectMaxVersionManage", type);
    }

    @SuppressWarnings("unchecked")
    public List<VersionManage> findVersionManage(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<VersionManage>) sqlMapClientTemplate.queryForList("versionmanage.selectVersionManages", params);
    }

    public VersionManage findVersionManageById(String id) {
        return (VersionManage) sqlMapClientTemplate.queryForObject("versionmanage.selectVersionManageById", id);
    }

    public int getCount(Map<String, Object> params) {
        return (Integer) sqlMapClientTemplate.queryForObject("versionmanage.selectVersionCount", params);
    }

    public void stopVersion(String id) {
        sqlMapClientTemplate.update("versionmanage.updateVersionStatus", id);
    }

    public void updateVersionManage(VersionManage versionManage) {
        sqlMapClientTemplate.update("versionmanage.updateVersionManage", versionManage);
    }
}
