package com.itech.ups.app.riskControl.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class BorrowerTmsAssetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String borrowerId;

    private String borrowerTmsId;

    private String userInfoId;

    private String userTmsId;

    private String assetItem;

    private String assetName;

    private String assetQuantity;

    private BigDecimal beginningAmount;

    private BigDecimal presentValue;

    private String assetDesc;

    private String createTime;

    private String dataStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerTmsId() {
        return borrowerTmsId;
    }

    public void setBorrowerTmsId(String borrowerTmsId) {
        this.borrowerTmsId = borrowerTmsId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserTmsId() {
        return userTmsId;
    }

    public void setUserTmsId(String userTmsId) {
        this.userTmsId = userTmsId;
    }

    public String getAssetItem() {
        return assetItem;
    }

    public void setAssetItem(String assetItem) {
        this.assetItem = assetItem;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetQuantity() {
        return assetQuantity;
    }

    public void setAssetQuantity(String assetQuantity) {
        this.assetQuantity = assetQuantity;
    }

    public BigDecimal getBeginningAmount() {
        return beginningAmount;
    }

    public void setBeginningAmount(BigDecimal beginningAmount) {
        this.beginningAmount = beginningAmount;
    }

    public BigDecimal getPresentValue() {
        return presentValue;
    }

    public void setPresentValue(BigDecimal presentValue) {
        this.presentValue = presentValue;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}