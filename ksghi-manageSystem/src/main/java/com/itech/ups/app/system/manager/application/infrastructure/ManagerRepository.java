package com.itech.ups.app.system.manager.application.infrastructure;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.manager.application.domain.ManagerRole;
import com.itech.ups.base.ApplicationConstant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * @1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块应用基础设施层的数据仓库类
 */
@Repository
public class ManagerRepository extends com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent {

    public Manager addManager(Manager manager) {
        manager.setId(generateIdentifier());
        manager = (Manager) sqlMapClientTemplate.insert("manager.insertManager", manager);
        return manager;
    }

    public void deleteManagerRoles(String managerId) {
        sqlMapClientTemplate.delete("manager.deleteManagerRoles", managerId);
    }

    public Manager editManager(Manager manager) {
        sqlMapClientTemplate.update("manager.updateManager", manager);
        return manager;
    }

    public List<Manager> findAllManagers() {
        String superAdmin = ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE;
        List result = sqlMapClientTemplate.queryForList("manager.selectAllManagers", superAdmin);
        return result;
    }

    public Manager findManager(String managerId) {
        Manager manager = (Manager) sqlMapClientTemplate.queryForObject("manager.selectManagerById", managerId);
        return manager;
    }

    public List findManagerByCode(String code) {
        List result = sqlMapClientTemplate.queryForList("manager.selectManagerByCode", code);
        return result;
    }

    public List<Manager> findManagerByName(String managerName) {
        return (List<Manager>) sqlMapClientTemplate.queryForList("manager.selectManagersByName", managerName);
    }

    public List findManagerRoles(String managerId) {
        List result = sqlMapClientTemplate.queryForList("manager.selectManagerRoles", managerId);
        return result;
    }

    public List findManagers(Map params, int rowStart, int rowEnd) {
        params.put("superAdmin", ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE);
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("manager.selectManagers", params);
        return results;
    }

    public List<Manager> findManagersByRoleName(String name) {
        return (List<Manager>) sqlMapClientTemplate.queryForList("manager.selectManagersByRoleName", name);
    }

    public long findManagersTotalCount(Map params) {
        params.put("superAdmin", ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE);
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("manager.selectManagersTotalCount", params);
        return totalCount;
    }

    // 查出客服人员
    public List<Manager> findServiceManagerRoles() {
        return (List<Manager>) sqlMapClientTemplate.queryForList("manager.selectServiceManagerRoles");
    }

    public int findServiceManagerRolesCount() {
        return (Integer) sqlMapClientTemplate.queryForObject("manager.selectServiceManagerRolesCount");
    }

    public void saveManagerRoles(String managerId, String[] roleIds, String creatorId, String creatorName, String createTime) {
        if (roleIds != null && roleIds.length > 0) {
            for (int i = 0; i < roleIds.length; i++) {
                ManagerRole managerRole = new ManagerRole();
                managerRole.setId(generateIdentifier());
                managerRole.setManagerId(managerId);
                managerRole.setRoleId(roleIds[i]);
                managerRole.setCreatorId(creatorId);
                managerRole.setCreatorName(creatorName);
                managerRole.setCreateTime(createTime);
                sqlMapClientTemplate.insert("manager.insertManagerRole", managerRole);
            }
        }
    }
}
