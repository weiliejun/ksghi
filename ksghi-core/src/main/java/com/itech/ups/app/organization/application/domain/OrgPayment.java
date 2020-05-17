package com.itech.ups.app.organization.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrgPayment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -497390208490097199L;

    private String id;

    private String orgId;

    private String orgType;

    private String orgName;

    private BigDecimal paymentAmount;

    private BigDecimal repayedMoney;

    private BigDecimal unrepayMoney;

    private String repayDate;

    private String remark;

    private String dataStatus;

    private String repayUserInfoId;

    private String repayUserName;

    private String createTime;

    private String paymentType;

    private String status;

    private String productId;

    private String statYm;
    private int paymentNum;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
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

    public String getRepayUserInfoId() {
        return repayUserInfoId;
    }

    public void setRepayUserInfoId(String repayUserInfoId) {
        this.repayUserInfoId = repayUserInfoId;
    }

    public String getRepayUserName() {
        return repayUserName;
    }

    public void setRepayUserName(String repayUserName) {
        this.repayUserName = repayUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getRepayedMoney() {
        return repayedMoney;
    }

    public void setRepayedMoney(BigDecimal repayedMoney) {
        this.repayedMoney = repayedMoney;
    }

    public BigDecimal getUnrepayMoney() {
        return unrepayMoney;
    }

    public void setUnrepayMoney(BigDecimal unrepayMoney) {
        this.unrepayMoney = unrepayMoney;
    }

    public int getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(int paymentNum) {
        this.paymentNum = paymentNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatYm() {
        return statYm;
    }

    public void setStatYm(String statYm) {
        this.statYm = statYm;
    }

}