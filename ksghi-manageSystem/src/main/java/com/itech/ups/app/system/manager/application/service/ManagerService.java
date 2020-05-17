package com.itech.ups.app.system.manager.application.service;

import com.itech.ups.app.manager.application.domain.Manager;

import java.util.List;
import java.util.Map;


/*
 * @1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块业务服务层的接口
 */

public interface ManagerService {

    Manager addManager(Manager manager);

    Manager authenticateManager(String code, String password);

    Manager editManager(Manager manager);

    Manager findManager(String managerId);

    List findManagerByCode(String code);

    List<Manager> findManagerByName(String managerName);

    List findManagerRoles(String managerId);

    List findManagers(Map params, int rowStart, int rowEnd);

    List<Manager> findManagersByRoleName(String name);

    long findManagersTotalCount(Map params);

    List<Manager> findServiceManagerRoles();

    int findServiceManagerRolesCount();

    void saveManagerRoles(Map params);
}
