package com.itech.ups.app.reconciliation.application.domain;

import java.io.Serializable;

public class CashData implements Serializable {

    private static final long serialVersionUID = -333025422590495180L;

    private String id;

    private String ordId;

    private String merCustId;

    private String usrCustId;

    private String cardId;

    private String transAmt;

    private String transStat;

    private String pnrDate;

    private String pnrSeqId;

    private String feeObj;

    private String feeAmt;

    private String servFee;

    private String servFeeAcctId;

    private String processDate;

    private String remark;

    private String createTime;

    private String creatorId;

    private String creatorName;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public String getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(String feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getFeeObj() {
        return feeObj;
    }

    public void setFeeObj(String feeObj) {
        this.feeObj = feeObj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerCustId() {
        return merCustId;
    }

    public void setMerCustId(String merCustId) {
        this.merCustId = merCustId;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getPnrDate() {
        return pnrDate;
    }

    public void setPnrDate(String pnrDate) {
        this.pnrDate = pnrDate;
    }

    public String getPnrSeqId() {
        return pnrSeqId;
    }

    public void setPnrSeqId(String pnrSeqId) {
        this.pnrSeqId = pnrSeqId;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getServFee() {
        return servFee;
    }

    public void setServFee(String servFee) {
        this.servFee = servFee;
    }

    public String getServFeeAcctId() {
        return servFeeAcctId;
    }

    public void setServFeeAcctId(String servFeeAcctId) {
        this.servFeeAcctId = servFeeAcctId;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getTransStat() {
        return transStat;
    }

    public void setTransStat(String transStat) {
        this.transStat = transStat;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }
}