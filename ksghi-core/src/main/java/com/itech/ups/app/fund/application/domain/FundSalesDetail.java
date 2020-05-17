package com.itech.ups.app.fund.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FundSalesDetail implements Serializable {

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

    private String fundGroupName;

    private String fundGroupId;

    private String fundCode;

    private String fundName;

    private String nikeName;

    private String userName;

    private String idcard;

    private Long amount;

    private BigDecimal unitNet;

    private Long buyCount;

    private BigDecimal newUnitNet;

    private Long assetsValue;

    private String netDate;

    private String newNetDate;

    private Long redeemCount;

    private Long redeemAmount;

    private Long hasCount;

    private String remark;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String buyTime;

    private String serviceFee;// 购买费用

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundGroupName() {
        return fundGroupName;
    }

    public void setFundGroupName(String fundGroupName) {
        this.fundGroupName = fundGroupName;
    }

    public String getFundGroupId() {
        return fundGroupId;
    }

    public void setFundGroupId(String fundGroupId) {
        this.fundGroupId = fundGroupId;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        this.unitNet = unitNet;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public BigDecimal getNewUnitNet() {
        return newUnitNet;
    }

    public void setNewUnitNet(BigDecimal newUnitNet) {
        this.newUnitNet = newUnitNet;
    }

    public Long getAssetsValue() {
        return assetsValue;
    }

    public void setAssetsValue(Long assetsValue) {
        this.assetsValue = assetsValue;
    }

    public String getNetDate() {
        return netDate;
    }

    public void setNetDate(String netDate) {
        this.netDate = netDate;
    }

    public String getNewNetDate() {
        return newNetDate;
    }

    public void setNewNetDate(String newNetDate) {
        this.newNetDate = newNetDate;
    }

    public Long getRedeemCount() {
        return redeemCount;
    }

    public void setRedeemCount(Long redeemCount) {
        this.redeemCount = redeemCount;
    }

    public Long getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(Long redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public Long getHasCount() {
        return hasCount;
    }

    public void setHasCount(Long hasCount) {
        this.hasCount = hasCount;
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

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

}