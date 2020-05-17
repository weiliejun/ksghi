package com.itech.ups.app.insurance.application.domain;

import java.io.Serializable;

public class InsuranceSalesDetail implements Serializable {
    private static final long serialVersionUID = -1804466539143935207L;

    private String id;

    private String insuranceId;

    private String category;

    private String insuranceName;

    private String companyName;

    private String insuranceCoverage;

    private String contractCode;

    private String nikeName;

    private String customerName;

    private String customerPhone;

    private String payWay;

    private String paidPremium;

    private Long insuranceDate;

    private String recentPaymentDate;

    private String recentlyPayDate;

    private String contractEffectiveDate;

    private String insuranceStatus;

    private String insuranceRemark;

    private String contractAttachments;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContractAttachments() {
        return contractAttachments;
    }

    public void setContractAttachments(String contractAttachments) {
        this.contractAttachments = contractAttachments;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractEffectiveDate() {
        return contractEffectiveDate;
    }

    public void setContractEffectiveDate(String contractEffectiveDate) {
        this.contractEffectiveDate = contractEffectiveDate;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
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

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(String insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public Long getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Long insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceRemark() {
        return insuranceRemark;
    }

    public void setInsuranceRemark(String insuranceRemark) {
        this.insuranceRemark = insuranceRemark;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getPaidPremium() {
        return paidPremium;
    }

    public void setPaidPremium(String paidPremium) {
        this.paidPremium = paidPremium;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getRecentlyPayDate() {
        return recentlyPayDate;
    }

    public void setRecentlyPayDate(String recentlyPayDate) {
        this.recentlyPayDate = recentlyPayDate;
    }

    public String getRecentPaymentDate() {
        return recentPaymentDate;
    }

    public void setRecentPaymentDate(String recentPaymentDate) {
        this.recentPaymentDate = recentPaymentDate;
    }
}