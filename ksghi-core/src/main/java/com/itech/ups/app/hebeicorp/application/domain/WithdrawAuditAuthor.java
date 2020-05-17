package com.itech.ups.app.hebeicorp.application.domain;

public class WithdrawAuditAuthor implements java.io.Serializable {

    private String id;

    private String sysManagerId;

    private String auditCorpId;

    private String auditCorpUserId;

    private String auditCorpType;

    private String status;

    private String remark;

    private String createTime;

    private String dataStatus;

    public String getAuditCorpId() {
        return auditCorpId;
    }

    public void setAuditCorpId(String auditCorpId) {
        this.auditCorpId = auditCorpId;
    }

    public String getAuditCorpType() {
        return auditCorpType;
    }

    public void setAuditCorpType(String auditCorpType) {
        this.auditCorpType = auditCorpType;
    }

    public String getAuditCorpUserId() {
        return auditCorpUserId;
    }

    public void setAuditCorpUserId(String auditCorpUserId) {
        this.auditCorpUserId = auditCorpUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSysManagerId() {
        return sysManagerId;
    }

    public void setSysManagerId(String sysManagerId) {
        this.sysManagerId = sysManagerId;
    }
}