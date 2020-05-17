package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

public class DrawingCash implements java.io.Serializable {

    private String id;

    private String usrInfoId;

    private String usrCustId;

    private String openBankId;

    private BigDecimal transAmount;

    private String hfRespContent;

    private String hfRespStatus;

    private String hfTrxId;

    private BigDecimal hfFeeAmt;

    private String hfFeeCustId;

    private String hfFeeAcctId;

    private String createTime;

    private String remark;

    private String dataStatus;

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

    public String getHfFeeAcctId() {
        return hfFeeAcctId;
    }

    public void setHfFeeAcctId(String hfFeeAcctId) {
        this.hfFeeAcctId = hfFeeAcctId;
    }

    public BigDecimal getHfFeeAmt() {
        return hfFeeAmt;
    }

    public void setHfFeeAmt(BigDecimal hfFeeAmt) {
        this.hfFeeAmt = hfFeeAmt;
    }

    public String getHfFeeCustId() {
        return hfFeeCustId;
    }

    public void setHfFeeCustId(String hfFeeCustId) {
        this.hfFeeCustId = hfFeeCustId;
    }

    public String getHfRespContent() {
        return hfRespContent;
    }

    public void setHfRespContent(String hfRespContent) {
        this.hfRespContent = hfRespContent;
    }

    public String getHfRespStatus() {
        return hfRespStatus;
    }

    public void setHfRespStatus(String hfRespStatus) {
        this.hfRespStatus = hfRespStatus;
    }

    public String getHfTrxId() {
        return hfTrxId;
    }

    public void setHfTrxId(String hfTrxId) {
        this.hfTrxId = hfTrxId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenBankId() {
        return openBankId;
    }

    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getUsrInfoId() {
        return usrInfoId;
    }

    public void setUsrInfoId(String usrInfoId) {
        this.usrInfoId = usrInfoId;
    }
}