package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowerApprovalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String borrowerTmsId;

    private String userInfoId;

    private String userTmsId;

    private String creditGradeCalc;

    private String creditGrade;

    private BigDecimal creditLimit;

    private BigDecimal creditScoreCalc;

    private BigDecimal creditLimitCalc;

    private String creditDateEnd;

    private String remark;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String auditStatus;

    private String auditIdea;

    private String approvalTime;

    private String approvalId;

    private String approvalName;

    private String approvalStatus;

    private String approvalIdea;

    private String dataStatus;

    private String auditEffectiveness;

    private BigDecimal additionAmount;

    private BigDecimal availableAmount;

    private String versionFileid;

    private String fileid1;

    private String fileid2;

    private BigDecimal fileid3;

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

    public String getBorrowerTmsId() {
        return borrowerTmsId;
    }

    public void setBorrowerTmsId(String borrowerTmsId) {
        this.borrowerTmsId = borrowerTmsId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserTmsId() {
        return userTmsId;
    }

    public void setUserTmsId(String userTmsId) {
        this.userTmsId = userTmsId;
    }

    public String getCreditGradeCalc() {
        return creditGradeCalc;
    }

    public void setCreditGradeCalc(String creditGradeCalc) {
        this.creditGradeCalc = creditGradeCalc;
    }

    public String getCreditGrade() {
        return creditGrade;
    }

    public void setCreditGrade(String creditGrade) {
        this.creditGrade = creditGrade;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditScoreCalc() {
        return creditScoreCalc;
    }

    public void setCreditScoreCalc(BigDecimal creditScoreCalc) {
        this.creditScoreCalc = creditScoreCalc;
    }

    public BigDecimal getCreditLimitCalc() {
        return creditLimitCalc;
    }

    public void setCreditLimitCalc(BigDecimal creditLimitCalc) {
        this.creditLimitCalc = creditLimitCalc;
    }

    public String getCreditDateEnd() {
        return creditDateEnd;
    }

    public void setCreditDateEnd(String creditDateEnd) {
        this.creditDateEnd = creditDateEnd;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
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

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalIdea() {
        return approvalIdea;
    }

    public void setApprovalIdea(String approvalIdea) {
        this.approvalIdea = approvalIdea;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getAuditEffectiveness() {
        return auditEffectiveness;
    }

    public void setAuditEffectiveness(String auditEffectiveness) {
        this.auditEffectiveness = auditEffectiveness;
    }

    public BigDecimal getAdditionAmount() {
        return additionAmount;
    }

    public void setAdditionAmount(BigDecimal additionAmount) {
        this.additionAmount = additionAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getVersionFileid() {
        return versionFileid;
    }

    public void setVersionFileid(String versionFileid) {
        this.versionFileid = versionFileid;
    }

    public String getFileid1() {
        return fileid1;
    }

    public void setFileid1(String fileid1) {
        this.fileid1 = fileid1;
    }

    public String getFileid2() {
        return fileid2;
    }

    public void setFileid2(String fileid2) {
        this.fileid2 = fileid2;
    }

    public BigDecimal getFileid3() {
        return fileid3;
    }

    public void setFileid3(BigDecimal fileid3) {
        this.fileid3 = fileid3;
    }
}