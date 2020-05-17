package com.itech.ups.app.finance.application.domain;

import java.io.Serializable;

public class LoanTrack implements Serializable {
    /**
     * @fields serialVersionUID
     */

    private static final long serialVersionUID = 1L;

    private String id;

    private String userInfoId;

    private String borrowerId;

    private String productId;

    private String fundApplicationStatus;

    private String fundApplicationDesc;

    private String operateFinancialStatus;

    private String operateFinancialDesc;

    private String repaymentAbilityStatus;

    private String repaymentAbilityDesc;

    private String overdueStatus;

    private String overdueDesc;

    private String lawsuitStatus;

    private String lawsuitDesc;

    private String punishStatus;

    private String punishDesc;

    private String otherStatus;

    private String otherDesc;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String dataStatus;

    private String remark;

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

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getFundApplicationStatus() {
        return fundApplicationStatus;
    }

    public void setFundApplicationStatus(String fundApplicationStatus) {
        this.fundApplicationStatus = fundApplicationStatus;
    }

    public String getFundApplicationDesc() {
        return fundApplicationDesc;
    }

    public void setFundApplicationDesc(String fundApplicationDesc) {
        this.fundApplicationDesc = fundApplicationDesc;
    }

    public String getOperateFinancialStatus() {
        return operateFinancialStatus;
    }

    public void setOperateFinancialStatus(String operateFinancialStatus) {
        this.operateFinancialStatus = operateFinancialStatus;
    }

    public String getOperateFinancialDesc() {
        return operateFinancialDesc;
    }

    public void setOperateFinancialDesc(String operateFinancialDesc) {
        this.operateFinancialDesc = operateFinancialDesc;
    }

    public String getRepaymentAbilityStatus() {
        return repaymentAbilityStatus;
    }

    public void setRepaymentAbilityStatus(String repaymentAbilityStatus) {
        this.repaymentAbilityStatus = repaymentAbilityStatus;
    }

    public String getRepaymentAbilityDesc() {
        return repaymentAbilityDesc;
    }

    public void setRepaymentAbilityDesc(String repaymentAbilityDesc) {
        this.repaymentAbilityDesc = repaymentAbilityDesc;
    }

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public String getOverdueDesc() {
        return overdueDesc;
    }

    public void setOverdueDesc(String overdueDesc) {
        this.overdueDesc = overdueDesc;
    }

    public String getLawsuitStatus() {
        return lawsuitStatus;
    }

    public void setLawsuitStatus(String lawsuitStatus) {
        this.lawsuitStatus = lawsuitStatus;
    }

    public String getLawsuitDesc() {
        return lawsuitDesc;
    }

    public void setLawsuitDesc(String lawsuitDesc) {
        this.lawsuitDesc = lawsuitDesc;
    }

    public String getPunishStatus() {
        return punishStatus;
    }

    public void setPunishStatus(String punishStatus) {
        this.punishStatus = punishStatus;
    }

    public String getPunishDesc() {
        return punishDesc;
    }

    public void setPunishDesc(String punishDesc) {
        this.punishDesc = punishDesc;
    }

    public String getOtherStatus() {
        return otherStatus;
    }

    public void setOtherStatus(String otherStatus) {
        this.otherStatus = otherStatus;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
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
}