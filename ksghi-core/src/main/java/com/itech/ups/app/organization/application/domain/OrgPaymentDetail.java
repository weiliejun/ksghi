package com.itech.ups.app.organization.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrgPaymentDetail implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String orgId;

    private String orgCode;

    private String userInfoId;

    private String orgPersonCode;

    private String tenderUserId;

    private BigDecimal recommendLevel;

    private String productId;

    private String tenderId;

    private BigDecimal investAmount;

    private BigDecimal investRate;

    private BigDecimal amount;

    private String tenderloanTime;

    private String createTime;

    private String paymentType;

    private BigDecimal registerRate;

    private String remark;

    private String dataStatus;

    private String product_category;

    private String productCategory;

    private String regionalManagerId;

    private String channelDirectorId;

    private String orgType;


    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getOrgPersonCode() {
        return orgPersonCode;
    }

    public void setOrgPersonCode(String orgPersonCode) {
        this.orgPersonCode = orgPersonCode;
    }

    public String getTenderUserId() {
        return tenderUserId;
    }

    public void setTenderUserId(String tenderUserId) {
        this.tenderUserId = tenderUserId;
    }

    public BigDecimal getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(BigDecimal recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public BigDecimal getInvestRate() {
        return investRate;
    }

    public void setInvestRate(BigDecimal investRate) {
        this.investRate = investRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTenderloanTime() {
        return tenderloanTime;
    }

    public void setTenderloanTime(String tenderloanTime) {
        this.tenderloanTime = tenderloanTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getRegisterRate() {
        return registerRate;
    }

    public void setRegisterRate(BigDecimal registerRate) {
        this.registerRate = registerRate;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getRegionalManagerId() {
        return regionalManagerId;
    }

    public void setRegionalManagerId(String regionalManagerId) {
        this.regionalManagerId = regionalManagerId;
    }

    public String getChannelDirectorId() {
        return channelDirectorId;
    }

    public void setChannelDirectorId(String channelDirectorId) {
        this.channelDirectorId = channelDirectorId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

}