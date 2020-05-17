package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

public class WithdrawCash implements java.io.Serializable {

    private String id;

    private String usrInfoId;

    private String usrCustId;

    private String openAcctId;

    private BigDecimal transAmount;

    private BigDecimal serverFee;

    private String serverFeeAcctId;

    private String auditFlag;

    private String auditDesc;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String hfRespContent;

    private String hfRespStatus;

    private String hfAuditRespContent;

    private String hfAuditRespStatus;

    private BigDecimal hfFeeAmt;

    private String hfFeeCustId;

    private String hfFeeAcctId;

    private String createTime;

    private String remark;

    private String dataStatus;

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
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

    public String getHfAuditRespContent() {
        return hfAuditRespContent;
    }

    public void setHfAuditRespContent(String hfAuditRespContent) {
        this.hfAuditRespContent = hfAuditRespContent;
    }

    public String getHfAuditRespStatus() {
        return hfAuditRespStatus;
    }

    public void setHfAuditRespStatus(String hfAuditRespStatus) {
        this.hfAuditRespStatus = hfAuditRespStatus;
    }

    public String getHfFeeAcctId() {
        return hfFeeAcctId;
    }

    public void setHfFeeAcctId(String hfFeeAcctId) {
        this.hfFeeAcctId = hfFeeAcctId;
    }

    public BigDecimal getHfFeeAmt() {
        return hfFeeAmt;
    }

    public void setHfFeeAmt(BigDecimal hfFeeAmt) {
        this.hfFeeAmt = hfFeeAmt;
    }

    public String getHfFeeCustId() {
        return hfFeeCustId;
    }

    public void setHfFeeCustId(String hfFeeCustId) {
        this.hfFeeCustId = hfFeeCustId;
    }

    public String getHfRespContent() {
        return hfRespContent;
    }

    public void setHfRespContent(String hfRespContent) {
        this.hfRespContent = hfRespContent;
    }

    public String getHfRespStatus() {
        return hfRespStatus;
    }

    public void setHfRespStatus(String hfRespStatus) {
        this.hfRespStatus = hfRespStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenAcctId() {
        return openAcctId;
    }

    public void setOpenAcctId(String openAcctId) {
        this.openAcctId = openAcctId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getServerFee() {
        return serverFee;
    }

    public void setServerFee(BigDecimal serverFee) {
        this.serverFee = serverFee;
    }

    public String getServerFeeAcctId() {
        return serverFeeAcctId;
    }

    public void setServerFeeAcctId(String serverFeeAcctId) {
        this.serverFeeAcctId = serverFeeAcctId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getUsrInfoId() {
        return usrInfoId;
    }

    public void setUsrInfoId(String usrInfoId) {
        this.usrInfoId = usrInfoId;
    }
}