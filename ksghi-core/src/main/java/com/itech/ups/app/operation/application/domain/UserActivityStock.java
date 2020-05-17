package com.itech.ups.app.operation.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserActivityStock implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3885846195958080561L;

    private String id;

    private String userInfoId;

    private String usrCustId;

    private String name;

    private String nickName;

    private String mobile;

    private String activityType;

    private String productId;

    private String productName;

    private String productCode;

    private BigDecimal annualRate;

    private Long amount;

    private Integer timeLimit;

    private String timeLimitUnit;

    private String repayType;

    private BigDecimal transAmount;

    private BigDecimal annualRateEnd;

    private String sellTime;

    private BigDecimal investorsInterest;

    private String tenderTime;

    private String payedTime;

    private String status;

    private String remark;

    private String createTime;

    private String dataStatus;

    private String worthDateStart;

    private String worthDateEnd;

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

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getTimeLimitUnit() {
        return timeLimitUnit;
    }

    public void setTimeLimitUnit(String timeLimitUnit) {
        this.timeLimitUnit = timeLimitUnit;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getAnnualRateEnd() {
        return annualRateEnd;
    }

    public void setAnnualRateEnd(BigDecimal annualRateEnd) {
        this.annualRateEnd = annualRateEnd;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public BigDecimal getInvestorsInterest() {
        return investorsInterest;
    }

    public void setInvestorsInterest(BigDecimal investorsInterest) {
        this.investorsInterest = investorsInterest;
    }

    public String getTenderTime() {
        return tenderTime;
    }

    public void setTenderTime(String tenderTime) {
        this.tenderTime = tenderTime;
    }

    public String getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(String payedTime) {
        this.payedTime = payedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getWorthDateStart() {
        return worthDateStart;
    }

    public void setWorthDateStart(String worthDateStart) {
        this.worthDateStart = worthDateStart;
    }

    public String getWorthDateEnd() {
        return worthDateEnd;
    }

    public void setWorthDateEnd(String worthDateEnd) {
        this.worthDateEnd = worthDateEnd;
    }

}