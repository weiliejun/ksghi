package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tender implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4358148658842083961L;

    private String id;

    private String userInfoId;

    private String usrCustId;

    private String productId;

    private BigDecimal transAmount;

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

    private String createTime;

    private String dataStatus;

    private String type;

    private String investType;

    private String sourceCode;

    private String category;

    private String terminal;

    private String acctId;

    private String lotteryType;

    private String lotteryValue;

    private String lotteryId;

    //存管新字段
    private String borrowerDetails;

    private String depoBankSeq;
    private BigDecimal vocherAmt;

    public BigDecimal getVocherAmt() {
        return vocherAmt;
    }

    public void setVocherAmt(BigDecimal vocherAmt) {
        this.vocherAmt = vocherAmt;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
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

    public BigDecimal getMaxTenderRate() {
        return maxTenderRate;
    }

    public void setMaxTenderRate(BigDecimal maxTenderRate) {
        this.maxTenderRate = maxTenderRate;
    }

    public BigDecimal getBorrowerRate() {
        return borrowerRate;
    }

    public void setBorrowerRate(BigDecimal borrowerRate) {
        this.borrowerRate = borrowerRate;
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

    public String getFreezeTrxId() {
        return freezeTrxId;
    }

    public void setFreezeTrxId(String freezeTrxId) {
        this.freezeTrxId = freezeTrxId;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
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

    public String getCancelRespStatus() {
        return cancelRespStatus;
    }

    public void setCancelRespStatus(String cancelRespStatus) {
        this.cancelRespStatus = cancelRespStatus;
    }

    public String getCancelRespDesc() {
        return cancelRespDesc;
    }

    public void setCancelRespDesc(String cancelRespDesc) {
        this.cancelRespDesc = cancelRespDesc;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getLotteryValue() {
        return lotteryValue;
    }

    public void setLotteryValue(String lotteryValue) {
        this.lotteryValue = lotteryValue;
    }

    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getBorrowerDetails() {
        return borrowerDetails;
    }

    public void setBorrowerDetails(String borrowerDetails) {
        this.borrowerDetails = borrowerDetails;
    }

    public String getDepoBankSeq() {
        return depoBankSeq;
    }

    public void setDepoBankSeq(String depoBankSeq) {
        this.depoBankSeq = depoBankSeq;
    }

}