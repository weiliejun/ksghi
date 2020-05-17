package com.itech.ups.app.system.authority.application.service;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.system.authority.application.infrastructure.AuthorityRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2011-12-23 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

@Service("authorityService")
public class AuthorityServiceImp extends AbstractServiceParent implements AuthorityService {

    @Autowired
    public AuthorityRepository repository;

    @Override
    public Function addFunction(Function function) {
        return repository.addFunction(function);
    }

    @Override
    public void addRole(Role role, String functionCodes) {
        role = repository.addRole(role);
        repository.grantRoleRights(role, functionCodes, role.getCreateTime(), role.getCreatorId(), role.getCreatorName());
    }

    public void editRole(Role role) {
        repository.editRole(role);
    }

    public void editRole(Role role, String functionCodes) {
        role = repository.editRole(role);
        repository.grantRoleRights(role, functionCodes, role.getCreateTime(), role.getCreatorId(), role.getCreatorName());
    }

    @Override
    public List<Function> findAllFunctions() {
        return repository.findAllFunctions();
    }

    @Override
    public List<Role> findAllRoles() {
        return repository.findAllRoles();
    }

    @Override
    public Function findFunctionByCode(String code) {
        return repository.findFunctionByCode(code);
    }

    @Override
    public Role findRole(String id) {
        return repository.findRole(id);
    }

    @Override
    public List<Role> findRoleByManagerId(String id) {
        return repository.findRoleByManagerId(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return repository.findRoleByName(name);
    }

    @Override
    public List<Function> findRoleFunctions(Role role) {
        List<Function> list = repository.findRoleFunctions(role);
        return list;
    }

    /*---------------------------------角色查询      2016.10.27   xsp  start-----------------------------------*/

    @Override
    public List findRoles(Map params, int rowStart, int rowEnd) {
        return repository.findRoles(params, rowStart, rowEnd);
    }
    /*---------------------------------角色查询      2016.10.27   xsp  end-----------------------------------*/

    @Override
    public long findRolesTotalCount(Map params) {
        return repository.findRolesTotalCount(params);
    }

    //-------start 系统树增-修 新增方法 ---------------
    @Override
    public Function findTreeFunctionByCode(String code) {
        return repository.findTreeFunctionByCode(code);
    }

    @Override
    public Function editFunction(Function function) {
        return repository.editFunction(function);
    }

    @Override
    public void removeTreeNode(String code) {
        repository.updateTreeNodeInvalid(code);
    }

    //------------------end ------------------
}
