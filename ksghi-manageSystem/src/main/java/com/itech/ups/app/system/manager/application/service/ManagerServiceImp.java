package com.itech.ups.app.system.manager.application.service;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.infrastructure.ManagerRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * @ 1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块业务服务层的实现类
 */
@Service("managerService")
public class ManagerServiceImp extends AbstractServiceParent implements ManagerService {

    @Autowired
    private ManagerRepository repository;

    public ManagerServiceImp() {
        super();
    }

    public Manager addManager(Manager manager) {
        return repository.addManager(manager);
    }

    @Override
    public Manager authenticateManager(String code, String password) {
        Manager result = null;
        List managers = repository.findManagerByCode(code);
        if (managers != null && !managers.isEmpty()) {
            Manager manager = (Manager) managers.get(0);
            if (manager.getPassword().equalsIgnoreCase(password)) {
                result = manager;
            }
        }
        return result;
    }

    public Manager editManager(Manager manager) {
        manager = repository.editManager(manager);
        return manager;
    }

    public Manager findManager(String managerId) {
        return repository.findManager(managerId);
    }

    public List findManagerByCode(String code) {
        return repository.findManagerByCode(code);
    }

    @Override
    public List<Manager> findManagerByName(String managerName) {
        return repository.findManagerByName(managerName);
    }

    public List findManagerRoles(String managerId) {
        return repository.findManagerRoles(managerId);
    }

    @Override
    public List findManagers(Map params, int rowStart, int rowEnd) {
        return repository.findManagers(params, rowStart, rowEnd);
    }

    public List<Manager> findManagersByRoleName(String name) {
        return repository.findManagersByRoleName(name);
    }

    @Override
    public long findManagersTotalCount(Map params) {
        return repository.findManagersTotalCount(params);
    }

    @Override
    public List<Manager> findServiceManagerRoles() {
        return repository.findServiceManagerRoles();
    }

    @Override
    public int findServiceManagerRolesCount() {
        return repository.findServiceManagerRolesCount();
    }

    public void saveManagerRoles(Map params) {
        String managerId = (String) params.get("managerId");
        String[] roleIds = (String[]) params.get("roles");
        String creatorId = (String) params.get("creatorId");
        String creatorName = (String) params.get("creatorName");
        String createTime = (String) params.get("createTime");

        repository.deleteManagerRoles(managerId);
        if (roleIds != null && roleIds.length > 0) {
            repository.saveManagerRoles(managerId, roleIds, creatorId, creatorName, createTime);

        }
    }

    public void setRepository(ManagerRepository repository) {
        this.repository = repository;
    }
}
