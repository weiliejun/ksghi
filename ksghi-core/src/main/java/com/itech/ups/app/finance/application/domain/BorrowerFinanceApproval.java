package com.itech.ups.app.finance.application.domain;

import java.io.Serializable;

public class BorrowerFinanceApproval implements Serializable {
    /**
     * @fields serialVersionUID
     */

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String userInfoId;

    private String cooperationLimit;

    private String loanTerm;

    private String cooperationRate;

    private String acceptTime;

    private String acceptId;

    private String acceptName;

    private String acceptIdea;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String auditIdea;

    private String approvalTime;

    private String approvalId;

    private String approvalName;

    private String approvalIdea;

    private String status;

    private String createTime;

    private String dataStatus;

    private String remark;

    private String feedbackIdea;

    private String loanApplicationId;

    private String versionFileid;

    private String source;

    private String loanType;

    // 可用金额
    private String availableAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getCooperationLimit() {
        return cooperationLimit;
    }

    public void setCooperationLimit(String cooperationLimit) {
        this.cooperationLimit = cooperationLimit;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getCooperationRate() {
        return cooperationRate;
    }

    public void setCooperationRate(String cooperationRate) {
        this.cooperationRate = cooperationRate;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public String getAcceptIdea() {
        return acceptIdea;
    }

    public void setAcceptIdea(String acceptIdea) {
        this.acceptIdea = acceptIdea;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
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

    public String getAuditIdea() {
        return auditIdea;
    }

    public void setAuditIdea(String auditIdea) {
        this.auditIdea = auditIdea;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalIdea() {
        return approvalIdea;
    }

    public void setApprovalIdea(String approvalIdea) {
        this.approvalIdea = approvalIdea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFeedbackIdea() {
        return feedbackIdea;
    }

    public void setFeedbackIdea(String feedbackIdea) {
        this.feedbackIdea = feedbackIdea;
    }

    public String getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(String loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public String getVersionFileid() {
        return versionFileid;
    }

    public void setVersionFileid(String versionFileid) {
        this.versionFileid = versionFileid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(String availableAmount) {
        this.availableAmount = availableAmount;
    }

}