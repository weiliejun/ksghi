package com.itech.ups.app.fund.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FundGroupRecord implements Serializable {

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

    private String fundGroupId;

    private String name;

    private String type;

    private String fundCode;

    private String recommendReason;

    private Long count;

    private String investmentRatio;

    private BigDecimal unitNet;

    private BigDecimal cumulativeNet;

    private BigDecimal oneYearGain;

    private String upperAndLowerFrame;

    private Long buyCount;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundGroupId() {
        return fundGroupId;
    }

    public void setFundGroupId(String fundGroupId) {
        this.fundGroupId = fundGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        this.unitNet = unitNet;
    }

    public BigDecimal getCumulativeNet() {
        return cumulativeNet;
    }

    public void setCumulativeNet(BigDecimal cumulativeNet) {
        this.cumulativeNet = cumulativeNet;
    }

    public BigDecimal getOneYearGain() {
        return oneYearGain;
    }

    public void setOneYearGain(BigDecimal oneYearGain) {
        this.oneYearGain = oneYearGain;
    }

    public String getUpperAndLowerFrame() {
        return upperAndLowerFrame;
    }

    public void setUpperAndLowerFrame(String upperAndLowerFrame) {
        this.upperAndLowerFrame = upperAndLowerFrame;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
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
}