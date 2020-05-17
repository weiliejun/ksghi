package com.itech.ups.app.system.authority.application.infrastructure;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.authority.application.domain.RoleFunction;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2011-12-23 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Repository
public class AuthorityRepository extends AbstractRepositoryParent {

    public Function addFunction(Function function) {
        function.setId(this.generateIdentifier());
        this.sqlMapClientTemplate.insert("authority.insertFunction", function);
        return function;
    }

    public Role addRole(Role role) {
        role.setId(this.generateIdentifier());
        this.sqlMapClientTemplate.insert("authority.insertRole", role);
        return role;
    }

    public Role editRole(Role role) {
        sqlMapClientTemplate.update("authority.updateRole", role);
        return role;
    }

    public List<Function> findAllFunctions() {
        List<Function> list = sqlMapClientTemplate.queryForList("authority.selectAllFunctions");
        return list;
    }

    public List<Role> findAllRoles() {
        List list = sqlMapClientTemplate.queryForList("authority.selectAllRoles");
        return list;
    }

    public Function findFunctionByCode(String code) {
        Function function = (Function) sqlMapClientTemplate.queryForObject("authority.selectFunctionByCode", code);
        return function;
    }

    public Role findRole(String id) {
        Role role = (Role) sqlMapClientTemplate.queryForObject("authority.selectRoleById", id);
        return role;
    }

    public List<Role> findRoleByManagerId(String id) {
        List roles = (List) sqlMapClientTemplate.queryForList("authority.selectRoleByManagerId", id);
        return roles;
    }

    public Role findRoleByName(String name) {
        Role role = (Role) sqlMapClientTemplate.queryForObject("authority.selectRoleByName", name);
        return role;
    }

    public List<Function> findRoleFunctions(Role role) {
        List list = sqlMapClientTemplate.queryForList("authority.selectRoleFunctions", role.getId());
        return list;
    }

    public List findRoles(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("authority.selectRoles", params);
        return results;
    }
    /*---------------------------------角色查询      2016.10.27   xsp  end-----------------------------------*/

    /*---------------------------------角色查询      2016.10.27   xsp  start-----------------------------------*/

    public long findRolesTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("authority.selectRolesTotalCount", params);
        return totalCount;
    }

    public void grantRoleRights(Role role, String functionCodes, String createTime, String creatorId, String creatorName) {
        sqlMapClientTemplate.delete("authority.deleteRoleFunctions", role.getId());
        if (functionCodes != null && !functionCodes.equals("")) {
            String[] codes = functionCodes.split(",");
            for (int i = 0; i < codes.length; i++) {
                String functionCode = codes[i];
                if (!"".equals(functionCode)) {
                    RoleFunction rf = new RoleFunction();
                    rf.setId(this.generateIdentifier());
                    rf.setCreatorId(creatorId);
                    rf.setCreatorName(creatorName);
                    rf.setCreateTime(createTime);
                    rf.setRoleId(role.getId());
                    rf.setFunctionCode(functionCode);
                    sqlMapClientTemplate.insert("authority.insertRoleFunction", rf);
                }
            }
        }
    }

    //-------start 系统树增-修 新增方法 ---------------

    /**
     * @param code
     * @return
     * @description 查询更多字段（树形结构）
     * @version 1.0
     * @author yanminfeng
     * @update 2017-8-22
     */
    public Function findTreeFunctionByCode(String code) {
        Function function = (Function) sqlMapClientTemplate.queryForObject("authority.selectTreeFunctionByCode", code);
        return function;
    }

    public Function editFunction(Function function) {
        sqlMapClientTemplate.update("authority.updateFunctionByCode", function);
        return function;
    }

    // 将某个节点以及所有子节点设为invalid
    public void updateTreeNodeInvalid(String code) {
        sqlMapClientTemplate.update("authority.updateTreeNodeInvalid", code);
    }

    //------------------end ------------------
}
