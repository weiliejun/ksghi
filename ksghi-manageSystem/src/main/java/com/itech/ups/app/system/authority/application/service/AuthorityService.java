package com.itech.ups.app.system.authority.application.service;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;

import java.util.List;
import java.util.Map;


/**
 * 版本信息：v1.0 日期：2011-12-23 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public interface AuthorityService {

    Function addFunction(Function function);

    void addRole(Role role, String functionCodes);

    void editRole(Role role);

    void editRole(Role role, String functionCodes);

    List<Function> findAllFunctions();

    List<Role> findAllRoles();

    Function findFunctionByCode(String code);

    Role findRole(String id);

    List<Role> findRoleByManagerId(String id);

    Role findRoleByName(String name);

    List<Function> findRoleFunctions(Role role);

    List findRoles(Map params, int rowStart, int rowEnd);

    long findRolesTotalCount(Map params);

    //-------start 系统树增-修 新增方法 ---------------

    /**
     * @param code
     * @return
     * @description 查询更多字段（树形结构）
     * @version 1.0
     * @author yanminfeng
     * @update 2017-8-22
     */
    public Function findTreeFunctionByCode(String code);

    Function editFunction(Function function);

    void removeTreeNode(String code);

    //------------------end ------------------
}
