package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

public class LiquidationDetailView {
    private String id;

    private String tenderId;

    private String userInfoId;

    private String productId;

    private BigDecimal investorRepayRate;// 出借人到期收益率(年化)

    private BigDecimal investorInterestAmount;// 出借人优先收益(元)

    private BigDecimal accountManagementFee;// 超额投顾收益(元)

    private BigDecimal platformServiceFee;// 超额平台收益(元)

    private BigDecimal investorIncomeAmount;// 超额出借人收益(元)

    private BigDecimal investorRepayAmount;// 应付出借人(元)

    private String remark;

    private String createTime;// 投标时间

    private String dataStatus;

    private String nickName;// 出借人昵称
    private BigDecimal transAmount;// 出借金额

    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getInvestorIncomeAmount() {
        return investorIncomeAmount;
    }

    public void setInvestorIncomeAmount(BigDecimal investorIncomeAmount) {
        this.investorIncomeAmount = investorIncomeAmount;
    }

    public BigDecimal getInvestorInterestAmount() {
        return investorInterestAmount;
    }

    public void setInvestorInterestAmount(BigDecimal investorInterestAmount) {
        this.investorInterestAmount = investorInterestAmount;
    }

    public BigDecimal getInvestorRepayAmount() {
        return investorRepayAmount;
    }

    public void setInvestorRepayAmount(BigDecimal investorRepayAmount) {
        this.investorRepayAmount = investorRepayAmount;
    }

    public BigDecimal getInvestorRepayRate() {
        return investorRepayRate;
    }

    public void setInvestorRepayRate(BigDecimal investorRepayRate) {
        this.investorRepayRate = investorRepayRate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getPlatformServiceFee() {
        return platformServiceFee;
    }

    public void setPlatformServiceFee(BigDecimal platformServiceFee) {
        this.platformServiceFee = platformServiceFee;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}