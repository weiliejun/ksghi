package com.itech.ups.base.application.domain;

import com.itech.core.components.xtree.TreeNode;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.manager.application.domain.Manager;

import java.io.Serializable;
import java.util.List;

public class CurrentManager implements Serializable {

    private static final long serialVersionUID = -4446583162943858640L;

    private Manager manager;

    private String ip;

    private String loginTime;

    private String sessionId;

    private TreeNode authorityFunctionTree;

    private List<Function> authorityFunctions;

    private List<Role> roles;

    public List<Function> getAuthorityFunctions() {
        return authorityFunctions;
    }

    public void setAuthorityFunctions(List<Function> authorityFunctions) {
        this.authorityFunctions = authorityFunctions;
    }

    public TreeNode getAuthorityFunctionTree() {
        return authorityFunctionTree;
    }

    public void setAuthorityFunctionTree(TreeNode authorityFunctionTree) {
        this.authorityFunctionTree = authorityFunctionTree;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}