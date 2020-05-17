package com.itech.ups.app.organization.application.domain;

import java.io.Serializable;

public class OrgUser implements Serializable {

    private static final long serialVersionUID = 5059129809344504828L;

    private String id;

    private String orgId;

    private String userInfoId;

    private String orgPersonCode;

    private String userStatus;

    private String dimissionDate;

    private String createTime;

    private String remark;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getOrgPersonCode() {
        return orgPersonCode;
    }

    public void setOrgPersonCode(String orgPersonCode) {
        this.orgPersonCode = orgPersonCode;
    }

    public String repository() {
        return userStatus;
    }

    public String getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(String dimissionDate) {
        this.dimissionDate = dimissionDate;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}