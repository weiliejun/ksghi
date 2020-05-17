package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class TenderRepayment implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2436948151123418017L;

    private String id;

    private String tenderId;

    private String userInfoId;

    private String usrCustId;

    private String productId;

    private String repayType;

    private String period;

    private BigDecimal repayPrincipalAmount;

    private BigDecimal repayInterestAmount;

    private BigDecimal repayAmount;

    private String repayAmountType;

    private String repayPlanDate;

    private String borrowerUserInfoId;

    private String borrowerUsrCustId;

    private String repayUserType;

    private String repayUserId;

    private String repayUsrCustId;

    private String repayUsrAcctId;

    private String freezeRespContent;

    private String freezeRespStatus;

    private String freezeRespDesc;

    private String freezeTrxId;

    private String unFreezeRespContent;

    private String unFreezeRespStatus;

    private String unFreezeRespDesc;

    private String respContent;

    private String respStatus;

    private String respDesc;

    private String status;

    private String remark;

    private String createTime;

    private String dataStatus;

    private String repayUserName;

    private String repayTime;

    private String requestContent;

    private BigDecimal fee;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
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

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getRepayPrincipalAmount() {
        return repayPrincipalAmount;
    }

    public void setRepayPrincipalAmount(BigDecimal repayPrincipalAmount) {
        this.repayPrincipalAmount = repayPrincipalAmount;
    }

    public BigDecimal getRepayInterestAmount() {
        return repayInterestAmount;
    }

    public void setRepayInterestAmount(BigDecimal repayInterestAmount) {
        this.repayInterestAmount = repayInterestAmount;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getRepayAmountType() {
        return repayAmountType;
    }

    public void setRepayAmountType(String repayAmountType) {
        this.repayAmountType = repayAmountType;
    }

    public String getRepayPlanDate() {
        return repayPlanDate;
    }

    public void setRepayPlanDate(String repayPlanDate) {
        this.repayPlanDate = repayPlanDate;
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

    public String getRepayUserType() {
        return repayUserType;
    }

    public void setRepayUserType(String repayUserType) {
        this.repayUserType = repayUserType;
    }

    public String getRepayUserId() {
        return repayUserId;
    }

    public void setRepayUserId(String repayUserId) {
        this.repayUserId = repayUserId;
    }

    public String getRepayUsrCustId() {
        return repayUsrCustId;
    }

    public void setRepayUsrCustId(String repayUsrCustId) {
        this.repayUsrCustId = repayUsrCustId;
    }

    public String getRepayUsrAcctId() {
        return repayUsrAcctId;
    }

    public void setRepayUsrAcctId(String repayUsrAcctId) {
        this.repayUsrAcctId = repayUsrAcctId;
    }

    public String getFreezeRespContent() {
        return freezeRespContent;
    }

    public void setFreezeRespContent(String freezeRespContent) {
        this.freezeRespContent = freezeRespContent;
    }

    public String getFreezeRespStatus() {
        return freezeRespStatus;
    }

    public void setFreezeRespStatus(String freezeRespStatus) {
        this.freezeRespStatus = freezeRespStatus;
    }

    public String getFreezeRespDesc() {
        return freezeRespDesc;
    }

    public void setFreezeRespDesc(String freezeRespDesc) {
        this.freezeRespDesc = freezeRespDesc;
    }

    public String getFreezeTrxId() {
        return freezeTrxId;
    }

    public void setFreezeTrxId(String freezeTrxId) {
        this.freezeTrxId = freezeTrxId;
    }

    public String getUnFreezeRespContent() {
        return unFreezeRespContent;
    }

    public void setUnFreezeRespContent(String unFreezeRespContent) {
        this.unFreezeRespContent = unFreezeRespContent;
    }

    public String getUnFreezeRespStatus() {
        return unFreezeRespStatus;
    }

    public void setUnFreezeRespStatus(String unFreezeRespStatus) {
        this.unFreezeRespStatus = unFreezeRespStatus;
    }

    public String getUnFreezeRespDesc() {
        return unFreezeRespDesc;
    }

    public void setUnFreezeRespDesc(String unFreezeRespDesc) {
        this.unFreezeRespDesc = unFreezeRespDesc;
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

    public String getRepayUserName() {
        return repayUserName;
    }

    public void setRepayUserName(String repayUserName) {
        this.repayUserName = repayUserName;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }
}