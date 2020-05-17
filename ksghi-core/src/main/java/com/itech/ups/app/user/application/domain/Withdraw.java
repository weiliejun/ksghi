package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Withdraw implements Serializable {

    private static final long serialVersionUID = 5937208017664742250L;

    private String id;

    private String userType;

    private String userId;

    private String usrCustId;

    private String openAcctId;

    private BigDecimal transAmount;

    private BigDecimal serviceFee;

    private String serviceFeeAcctId;

    private String respContent;

    private String respStatus;

    private String respDesc;

    private BigDecimal feeAmount;

    private String feeCustId;

    private String feeAcctId;

    private String remark;

    private String createTime;

    private String dataStatus;

    private BigDecimal investWithdrawAmount;

    private BigDecimal investedWithdrawAmount;

    private String terminal;

    // 取现渠道
    private String cashChannel;
    // 实际到账金额
    private BigDecimal realTransAmount;

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getOpenAcctId() {
        return openAcctId;
    }

    public void setOpenAcctId(String openAcctId) {
        this.openAcctId = openAcctId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getServiceFeeAcctId() {
        return serviceFeeAcctId;
    }

    public void setServiceFeeAcctId(String serviceFeeAcctId) {
        this.serviceFeeAcctId = serviceFeeAcctId;
    }

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }

    public String getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(String respStatus) {
        this.respStatus = respStatus;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCustId() {
        return feeCustId;
    }

    public void setFeeCustId(String feeCustId) {
        this.feeCustId = feeCustId;
    }

    public String getFeeAcctId() {
        return feeAcctId;
    }

    public void setFeeAcctId(String feeAcctId) {
        this.feeAcctId = feeAcctId;
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

    public BigDecimal getInvestWithdrawAmount() {
        return investWithdrawAmount;
    }

    public void setInvestWithdrawAmount(BigDecimal investWithdrawAmount) {
        this.investWithdrawAmount = investWithdrawAmount;
    }

    public BigDecimal getInvestedWithdrawAmount() {
        return investedWithdrawAmount;
    }

    public void setInvestedWithdrawAmount(BigDecimal investedWithdrawAmount) {
        this.investedWithdrawAmount = investedWithdrawAmount;
    }

    public String getCashChannel() {
        return cashChannel;
    }

    public void setCashChannel(String cashChannel) {
        this.cashChannel = cashChannel;
    }

    public BigDecimal getRealTransAmount() {
        return realTransAmount;
    }

    public void setRealTransAmount(BigDecimal realTransAmount) {
        this.realTransAmount = realTransAmount;
    }

}