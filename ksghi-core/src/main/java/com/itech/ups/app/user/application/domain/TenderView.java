package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

//出借人收益分配明细信息
public class TenderView implements java.io.Serializable {
    private String id;

    private String userInfoId;

    private String usrCustId;

    private String productId;

    private BigDecimal transAmount;// 出借金额

    private String borrowerUserInfoId;

    private String borrowerUsrCustId;

    private BigDecimal maxTenderRate;

    private BigDecimal borrowerRate;

    private String respContent;

    private String respStatus;

    private String respDesc;

    private String freezeTrxId;

    private String cancelType;

    private String cancelTime;

    private String cancelRemark;

    private String cancelRespContent;

    private String cancelRespStatus;

    private String cancelRespDesc;

    private String status;

    private String remark;

    private String createTime;// 创建时间

    private String dataStatus;

    private String type;

    private String investType;

    private String sourceCode;

    private String category;

    private String terminal;

    private BigDecimal dayWorth;// 最后一个交易日单位净值
    private BigDecimal runningDays;// 交易日期

    private String nickName;// 出借人昵称
    private BigDecimal investorRepayRate;// 出借年化利率(%/年)

    // private BigDecimal personAnnualYield;//出借人年化利率(%/年)
    private BigDecimal investorInterestAmount;// 出借人优先收益（元）
    private BigDecimal investorIncomeAmount;// 超额出借人收益(元)

    private BigDecimal accountManagementFee;// 超额投顾收益(元)

    private BigDecimal platformServiceFee;// 超额平台收益(元)
    private BigDecimal investorRepayAmount;// 应付出借人回款(元)

    public TenderView() {

    }

    public TenderView(BigDecimal investorRepayRate, BigDecimal investorInterestAmount, BigDecimal investorIncomeAmount, BigDecimal accountManagementFee, BigDecimal platformServiceFee, BigDecimal investorRepayAmount) {
        this.investorRepayRate = investorRepayRate;
        this.investorIncomeAmount = investorIncomeAmount;
        this.investorIncomeAmount = investorIncomeAmount;
        this.investorInterestAmount = investorInterestAmount;
        this.accountManagementFee = accountManagementFee;
        this.platformServiceFee = platformServiceFee;
        this.investorRepayAmount = investorRepayAmount;
    }

    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public BigDecimal getBorrowerRate() {
        return borrowerRate;
    }

    public void setBorrowerRate(BigDecimal borrowerRate) {
        this.borrowerRate = borrowerRate;
    }

    public String getBorrowerUserInfoId() {
        return borrowerUserInfoId;
    }

    public void setBorrowerUserInfoId(String borrowerUserInfoId) {
        this.borrowerUserInfoId = borrowerUserInfoId;
    }

    public String getBorrowerUsrCustId() {
        return borrowerUsrCustId;
    }

    public void setBorrowerUsrCustId(String borrowerUsrCustId) {
        this.borrowerUsrCustId = borrowerUsrCustId;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }

    public String getCancelRespContent() {
        return cancelRespContent;
    }

    public void setCancelRespContent(String cancelRespContent) {
        this.cancelRespContent = cancelRespContent;
    }

    public String getCancelRespDesc() {
        return cancelRespDesc;
    }

    public void setCancelRespDesc(String cancelRespDesc) {
        this.cancelRespDesc = cancelRespDesc;
    }

    public String getCancelRespStatus() {
        return cancelRespStatus;
    }

    public void setCancelRespStatus(String cancelRespStatus) {
        this.cancelRespStatus = cancelRespStatus;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public BigDecimal getDayWorth() {
        return dayWorth;
    }

    public void setDayWorth(BigDecimal dayWorth) {
        this.dayWorth = dayWorth;
    }

    public String getFreezeTrxId() {
        return freezeTrxId;
    }

    public void setFreezeTrxId(String freezeTrxId) {
        this.freezeTrxId = freezeTrxId;
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
        LiquidationData.getAnnualYield(dayWorth, runningDays);
        return investorRepayRate;
    }

    public void setInvestorRepayRate(BigDecimal investorRepayRate) {
        this.investorRepayRate = investorRepayRate;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public BigDecimal getMaxTenderRate() {
        return maxTenderRate;
    }

    public void setMaxTenderRate(BigDecimal maxTenderRate) {
        this.maxTenderRate = maxTenderRate;
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

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(String respStatus) {
        this.respStatus = respStatus;
    }

    public BigDecimal getRunningDays() {
        return runningDays;
    }

    public void setRunningDays(BigDecimal runningDays) {
        this.runningDays = runningDays;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}