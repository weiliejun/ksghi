package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserFundRecord implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5082563524703191637L;

    private String id;

    private String userInfoId;

    private String flowType;

    private BigDecimal amount;

    private String transId;

    private String transType;

    private String transTime;

    private BigDecimal transAmount;

    private String transRemark;

    private String relatedUserType;

    private String relatedUserId;

    private String relatedUsrCustId;

    private String relatedUsrAcctId;

    private String createTime;

    private String remark;

    private String dataStatus;

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

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransRemark() {
        return transRemark;
    }

    public void setTransRemark(String transRemark) {
        this.transRemark = transRemark;
    }

    public String getRelatedUserType() {
        return relatedUserType;
    }

    public void setRelatedUserType(String relatedUserType) {
        this.relatedUserType = relatedUserType;
    }

    public String getRelatedUserId() {
        return relatedUserId;
    }

    public void setRelatedUserId(String relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    public String getRelatedUsrCustId() {
        return relatedUsrCustId;
    }

    public void setRelatedUsrCustId(String relatedUsrCustId) {
        this.relatedUsrCustId = relatedUsrCustId;
    }

    public String getRelatedUsrAcctId() {
        return relatedUsrAcctId;
    }

    public void setRelatedUsrAcctId(String relatedUsrAcctId) {
        this.relatedUsrAcctId = relatedUsrAcctId;
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
}