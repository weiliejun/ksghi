package com.itech.ups.app.creditassignment.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CreditAssignment implements Serializable {

    private static final long serialVersionUID = 3322131715197967547L;

    private String id;

    private String productId;

    private String sellerTenderId;

    private String sellerUserInfoId;

    private String sellerUsrCustId;

    private String sellerName;

    private String sellerNickName;

    private BigDecimal creditAmount;

    private String creditRemainDays;

    private String creditHoldDays;

    private String creditInterestDays;

    private BigDecimal sellerInterest;

    private String buyerTenderId;

    private String buyerUserInfoId;

    private String buyerUsrCustId;

    private String buyerName;

    private String buyerNickName;

    private BigDecimal creditDealAmount;

    private BigDecimal serviceFee;

    private String transferTime;

    private String respContent;

    private String respStatus;

    private String respDesc;

    private String requestContent;

    private String status;

    private String remark;

    private String createTime;

    private String dataStatus;

    private String terminal;

    private String editTime;

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerTenderId() {
        return sellerTenderId;
    }

    public void setSellerTenderId(String sellerTenderId) {
        this.sellerTenderId = sellerTenderId;
    }

    public String getSellerUserInfoId() {
        return sellerUserInfoId;
    }

    public void setSellerUserInfoId(String sellerUserInfoId) {
        this.sellerUserInfoId = sellerUserInfoId;
    }

    public String getSellerUsrCustId() {
        return sellerUsrCustId;
    }

    public void setSellerUsrCustId(String sellerUsrCustId) {
        this.sellerUsrCustId = sellerUsrCustId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerNickName() {
        return sellerNickName;
    }

    public void setSellerNickName(String sellerNickName) {
        this.sellerNickName = sellerNickName;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCreditRemainDays() {
        return creditRemainDays;
    }

    public void setCreditRemainDays(String creditRemainDays) {
        this.creditRemainDays = creditRemainDays;
    }

    public String getCreditHoldDays() {
        return creditHoldDays;
    }

    public void setCreditHoldDays(String creditHoldDays) {
        this.creditHoldDays = creditHoldDays;
    }

    public String getCreditInterestDays() {
        return creditInterestDays;
    }

    public void setCreditInterestDays(String creditInterestDays) {
        this.creditInterestDays = creditInterestDays;
    }

    public BigDecimal getSellerInterest() {
        return sellerInterest;
    }

    public void setSellerInterest(BigDecimal sellerInterest) {
        this.sellerInterest = sellerInterest;
    }

    public String getBuyerTenderId() {
        return buyerTenderId;
    }

    public void setBuyerTenderId(String buyerTenderId) {
        this.buyerTenderId = buyerTenderId;
    }

    public String getBuyerUserInfoId() {
        return buyerUserInfoId;
    }

    public void setBuyerUserInfoId(String buyerUserInfoId) {
        this.buyerUserInfoId = buyerUserInfoId;
    }

    public String getBuyerUsrCustId() {
        return buyerUsrCustId;
    }

    public void setBuyerUsrCustId(String buyerUsrCustId) {
        this.buyerUsrCustId = buyerUsrCustId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerNickName() {
        return buyerNickName;
    }

    public void setBuyerNickName(String buyerNickName) {
        this.buyerNickName = buyerNickName;
    }

    public BigDecimal getCreditDealAmount() {
        return creditDealAmount;
    }

    public void setCreditDealAmount(BigDecimal creditDealAmount) {
        this.creditDealAmount = creditDealAmount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
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

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
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
}