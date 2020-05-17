package com.itech.ups.app.user.application.domain;

import java.math.BigDecimal;

public class UserAccount implements java.io.Serializable {

    private static final long serialVersionUID = 1683779783106858139L;

    private String id;

    private String usrInfoId;

    private String usrId;

    private String usrCustId;

    private String idType;

    private String idNo;

    private String usrMp;

    private String usrEmail;

    private String usrName;

    private BigDecimal acctBal;

    private BigDecimal avlBal;

    private BigDecimal frzBal;

    private BigDecimal accountBalance;

    private BigDecimal availableBalance;

    private BigDecimal frozenBalance;

    private String dataStatus;

    private String busiCode;

    private String openBankId;

    private String cardId;

    private String auditStat;

    private String auditDesc;

    private String provId;

    private String areaId;

    private String depoAcctNo;

    private String depoAcctName;

    private String depoBankSeq;

    private String regStat;

    private String cnapsCode;
    private String createTime;
    private String remark;
    private String trxId;

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getDepoAcctNo() {
        return depoAcctNo;
    }

    public void setDepoAcctNo(String depoAcctNo) {
        this.depoAcctNo = depoAcctNo;
    }

    public String getDepoAcctName() {
        return depoAcctName;
    }

    public void setDepoAcctName(String depoAcctName) {
        this.depoAcctName = depoAcctName;
    }

    public String getDepoBankSeq() {
        return depoBankSeq;
    }

    public void setDepoBankSeq(String depoBankSeq) {
        this.depoBankSeq = depoBankSeq;
    }

    public String getRegStat() {
        return regStat;
    }

    public void setRegStat(String regStat) {
        this.regStat = regStat;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getUsrInfoId() {
        return usrInfoId;
    }

    public void setUsrInfoId(String usrInfoId) {
        this.usrInfoId = usrInfoId;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getUsrMp() {
        return usrMp;
    }

    public void setUsrMp(String usrMp) {
        this.usrMp = usrMp;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public BigDecimal getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(BigDecimal acctBal) {
        this.acctBal = acctBal;
    }

    public BigDecimal getAvlBal() {
        return avlBal;
    }

    public void setAvlBal(BigDecimal avlBal) {
        this.avlBal = avlBal;
    }

    public BigDecimal getFrzBal() {
        return frzBal;
    }

    public void setFrzBal(BigDecimal frzBal) {
        this.frzBal = frzBal;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getOpenBankId() {
        return openBankId;
    }

    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAuditStat() {
        return auditStat;
    }

    public void setAuditStat(String auditStat) {
        this.auditStat = auditStat;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

}