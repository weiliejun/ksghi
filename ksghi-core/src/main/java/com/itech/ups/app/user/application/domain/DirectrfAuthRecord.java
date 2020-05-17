package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

public class DirectrfAuthRecord implements java.io.Serializable {
    private String id;

    private String userId;

    private String usrCustId;

    private String inUserId;

    private String inUsrCustId;

    private BigDecimal authAmount;

    private BigDecimal remainAuthAmount;

    private String respContent;

    private String respDesc;

    private String status;

    private String currentAuth;

    private String remark;

    private String createTime;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getInUserId() {
        return inUserId;
    }

    public void setInUserId(String inUserId) {
        this.inUserId = inUserId;
    }

    public String getInUsrCustId() {
        return inUsrCustId;
    }

    public void setInUsrCustId(String inUsrCustId) {
        this.inUsrCustId = inUsrCustId;
    }

    public BigDecimal getAuthAmount() {
        return authAmount;
    }

    public void setAuthAmount(BigDecimal authAmount) {
        this.authAmount = authAmount;
    }

    public BigDecimal getRemainAuthAmount() {
        return remainAuthAmount;
    }

    public void setRemainAuthAmount(BigDecimal remainAuthAmount) {
        this.remainAuthAmount = remainAuthAmount;
    }

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentAuth() {
        return currentAuth;
    }

    public void setCurrentAuth(String currentAuth) {
        this.currentAuth = currentAuth;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}