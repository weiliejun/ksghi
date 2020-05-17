package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowerTmsDebtInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String borrowerTmsId;

    private String userInfoId;

    private String userTmsId;

    private String debtItem;

    private String debtName;

    private String debtorOrAgency;

    private BigDecimal debtAmount;

    private BigDecimal debtBalance;

    private String loanDate;

    private String expireDate;

    private String debtSecurityMeasure;

    private String remark;

    private String createTime;

    private String dataStatus;

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

    public String getDebtItem() {
        return debtItem;
    }

    public void setDebtItem(String debtItem) {
        this.debtItem = debtItem;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public String getDebtorOrAgency() {
        return debtorOrAgency;
    }

    public void setDebtorOrAgency(String debtorOrAgency) {
        this.debtorOrAgency = debtorOrAgency;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public BigDecimal getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(BigDecimal debtBalance) {
        this.debtBalance = debtBalance;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getDebtSecurityMeasure() {
        return debtSecurityMeasure;
    }

    public void setDebtSecurityMeasure(String debtSecurityMeasure) {
        this.debtSecurityMeasure = debtSecurityMeasure;
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