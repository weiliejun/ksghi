package com.itech.ups.app.organization.application.domain;

import java.io.Serializable;

public class OrgUserDistributeRecord implements Serializable {

    private static final long serialVersionUID = -6789928219050150217L;

    private String id;

    private String userInfoId;

    private String userName;

    private String mobile;

    private String oldUserName;

    private String oldUserInfoId;

    private String oldOrgPersonCode;

    private String newOrgPersonCode;

    private String newUserInfoId;

    private String createTime;

    private String remark;

    private String dataStatus;

    private String newUserName;

    private String orgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOldUserName() {
        return oldUserName;
    }

    public void setOldUserName(String oldUserName) {
        this.oldUserName = oldUserName;
    }

    public String getOldUserInfoId() {
        return oldUserInfoId;
    }

    public void setOldUserInfoId(String oldUserInfoId) {
        this.oldUserInfoId = oldUserInfoId;
    }

    public String getOldOrgPersonCode() {
        return oldOrgPersonCode;
    }

    public void setOldOrgPersonCode(String oldOrgPersonCode) {
        this.oldOrgPersonCode = oldOrgPersonCode;
    }

    public String getNewOrgPersonCode() {
        return newOrgPersonCode;
    }

    public void setNewOrgPersonCode(String newOrgPersonCode) {
        this.newOrgPersonCode = newOrgPersonCode;
    }

    public String getNewUserInfoId() {
        return newUserInfoId;
    }

    public void setNewUserInfoId(String newUserInfoId) {
        this.newUserInfoId = newUserInfoId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getNewUserName() {
        return newUserName;
    }

    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}