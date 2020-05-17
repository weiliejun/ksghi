package com.itech.ups.app.riskControl.application.domain;

import java.math.BigDecimal;

public class BorrowerTmsCreditInfo {
    private String id;

    private String borrowerId;

    private String borrowerTmsId;

    private String userInfoId;

    private String userTmsId;

    private String isCreditCard;

    private String isBaddebt;

    private BigDecimal creditAmount;

    private BigDecimal usedCreditAmount;

    private String currentIsOverdue;

    private String overdueMonthIn5years;

    private BigDecimal currentOverdueAmount;

    private String loanApproveTimes;

    private String queryTimes;

    private String qualificationExamineTimes;

    private String overdueMonth90days;

    private String remark;

    private String createTime;

    private String dataStatus;

    private String noIsBaddebt;

    private String noCurrentIsOverdue;

    private String noOverdueMonthIn5years;

    private String noOverdueMonth90days;

    private BigDecimal noCurrentOverdueAmount;

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

    public String getIsCreditCard() {
        return isCreditCard;
    }

    public void setIsCreditCard(String isCreditCard) {
        this.isCreditCard = isCreditCard;
    }

    public String getIsBaddebt() {
        return isBaddebt;
    }

    public void setIsBaddebt(String isBaddebt) {
        this.isBaddebt = isBaddebt;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getUsedCreditAmount() {
        return usedCreditAmount;
    }

    public void setUsedCreditAmount(BigDecimal usedCreditAmount) {
        this.usedCreditAmount = usedCreditAmount;
    }

    public String getCurrentIsOverdue() {
        return currentIsOverdue;
    }

    public void setCurrentIsOverdue(String currentIsOverdue) {
        this.currentIsOverdue = currentIsOverdue;
    }

    public String getOverdueMonthIn5years() {
        return overdueMonthIn5years;
    }

    public void setOverdueMonthIn5years(String overdueMonthIn5years) {
        this.overdueMonthIn5years = overdueMonthIn5years;
    }

    public BigDecimal getCurrentOverdueAmount() {
        return currentOverdueAmount;
    }

    public void setCurrentOverdueAmount(BigDecimal currentOverdueAmount) {
        this.currentOverdueAmount = currentOverdueAmount;
    }

    public String getLoanApproveTimes() {
        return loanApproveTimes;
    }

    public void setLoanApproveTimes(String loanApproveTimes) {
        this.loanApproveTimes = loanApproveTimes;
    }

    public String getQueryTimes() {
        return queryTimes;
    }

    public void setQueryTimes(String queryTimes) {
        this.queryTimes = queryTimes;
    }

    public String getQualificationExamineTimes() {
        return qualificationExamineTimes;
    }

    public void setQualificationExamineTimes(String qualificationExamineTimes) {
        this.qualificationExamineTimes = qualificationExamineTimes;
    }

    public String getOverdueMonth90days() {
        return overdueMonth90days;
    }

    public void setOverdueMonth90days(String overdueMonth90days) {
        this.overdueMonth90days = overdueMonth90days;
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

    public String getNoIsBaddebt() {
        return noIsBaddebt;
    }

    public void setNoIsBaddebt(String noIsBaddebt) {
        this.noIsBaddebt = noIsBaddebt;
    }

    public String getNoCurrentIsOverdue() {
        return noCurrentIsOverdue;
    }

    public void setNoCurrentIsOverdue(String noCurrentIsOverdue) {
        this.noCurrentIsOverdue = noCurrentIsOverdue;
    }

    public String getNoOverdueMonthIn5years() {
        return noOverdueMonthIn5years;
    }

    public void setNoOverdueMonthIn5years(String noOverdueMonthIn5years) {
        this.noOverdueMonthIn5years = noOverdueMonthIn5years;
    }

    public String getNoOverdueMonth90days() {
        return noOverdueMonth90days;
    }

    public void setNoOverdueMonth90days(String noOverdueMonth90days) {
        this.noOverdueMonth90days = noOverdueMonth90days;
    }

    public BigDecimal getNoCurrentOverdueAmount() {
        return noCurrentOverdueAmount;
    }

    public void setNoCurrentOverdueAmount(BigDecimal noCurrentOverdueAmount) {
        this.noCurrentOverdueAmount = noCurrentOverdueAmount;
    }
}