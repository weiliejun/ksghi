package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Prepayment implements Serializable {
    private static final long serialVersionUID = 8400769019628261369L;

    private String id;

    private String productId;

    private BigDecimal repayPrincipalAmount;

    private BigDecimal repayInterestAmount;

    private BigDecimal repayAmount;

    private String borrowerUserInfoId;

    private String borrowerUsrCustId;

    private String repayUserType;

    private String repayUserId;

    private String repayUsrCustId;

    private String repayUsrAcctId;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String remark;

    private String dataStatus;

    private String repayPlanDate;

    private String repayUserName;

    private String status;

    private String editTime;

    private String editorId;

    private String editorName;

    private String prepayClass;

    private String prepayMoneyNature;

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getRepayPlanDate() {
        return repayPlanDate;
    }

    public void setRepayPlanDate(String repayPlanDate) {
        this.repayPlanDate = repayPlanDate;
    }

    public String getRepayUserName() {
        return repayUserName;
    }

    public void setRepayUserName(String repayUserName) {
        this.repayUserName = repayUserName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getPrepayClass() {
        return prepayClass;
    }

    public void setPrepayClass(String prepayClass) {
        this.prepayClass = prepayClass;
    }

    public String getPrepayMoneyNature() {
        return prepayMoneyNature;
    }

    public void setPrepayMoneyNature(String prepayMoneyNature) {
        this.prepayMoneyNature = prepayMoneyNature;
    }

}