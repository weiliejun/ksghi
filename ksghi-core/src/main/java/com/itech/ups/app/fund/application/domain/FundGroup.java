package com.itech.ups.app.fund.application.domain;
/*
 * @ huangguohu  2015-08-26
 */

import java.io.Serializable;
import java.math.BigDecimal;

public class FundGroup implements Serializable {

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

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

    private String uplowRemark;

    private String photosAttachments;

    private String remark;

    private String auditStatus;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private String auditDesc;

    private String auditTime;

    private String auditorId;

    private String auditorName;

    private String groupCode;

    private String upperTime;

    private BigDecimal rehabilitationNet;// 复权净值

    private BigDecimal startAmount;// 起投金额

    private String riskLevel;// 风险等级

    // 2016-01-11 wcl 增加
    private BigDecimal onedayIncrease;// 日涨幅

    private BigDecimal oneWeekGain;// 近一周涨幅

    private BigDecimal oneMonthGain;// 近一余额涨幅

    private BigDecimal threeMonthGain;// 近三个月涨幅

    private BigDecimal halfYearGain;// 近半年涨幅

    private BigDecimal cumulativeIncrease;// 累计涨幅

    private BigDecimal buyFeeRate;// 购买费率

    private BigDecimal redeemFeeRate;// 赎回费率

    private String newlyNetDate;// 最新净值日期

    private BigDecimal thisYearGain;// 今年来涨幅
    // 2016-01-11 wcl 增加 结束
    private String fundType;// 基金类型

    private BigDecimal increaseAmount;// 基金类型

    public BigDecimal getRehabilitationNet() {
        return rehabilitationNet;
    }

    public void setRehabilitationNet(BigDecimal rehabilitationNet) {
        this.rehabilitationNet = rehabilitationNet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUplowRemark() {
        return uplowRemark;
    }

    public void setUplowRemark(String uplowRemark) {
        this.uplowRemark = uplowRemark;
    }

    public String getPhotosAttachments() {
        return photosAttachments;
    }

    public void setPhotosAttachments(String photosAttachments) {
        this.photosAttachments = photosAttachments;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
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

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getUpperTime() {
        return upperTime;
    }

    public void setUpperTime(String upperTime) {
        this.upperTime = upperTime;
    }

    public BigDecimal getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(BigDecimal startAmount) {
        this.startAmount = startAmount;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public BigDecimal getOnedayIncrease() {
        return onedayIncrease;
    }

    public void setOnedayIncrease(BigDecimal onedayIncrease) {
        this.onedayIncrease = onedayIncrease;
    }

    public BigDecimal getOneWeekGain() {
        return oneWeekGain;
    }

    public void setOneWeekGain(BigDecimal oneWeekGain) {
        this.oneWeekGain = oneWeekGain;
    }

    public BigDecimal getOneMonthGain() {
        return oneMonthGain;
    }

    public void setOneMonthGain(BigDecimal oneMonthGain) {
        this.oneMonthGain = oneMonthGain;
    }

    public BigDecimal getThreeMonthGain() {
        return threeMonthGain;
    }

    public void setThreeMonthGain(BigDecimal threeMonthGain) {
        this.threeMonthGain = threeMonthGain;
    }

    public BigDecimal getHalfYearGain() {
        return halfYearGain;
    }

    public void setHalfYearGain(BigDecimal halfYearGain) {
        this.halfYearGain = halfYearGain;
    }

    public BigDecimal getCumulativeIncrease() {
        return cumulativeIncrease;
    }

    public void setCumulativeIncrease(BigDecimal cumulativeIncrease) {
        this.cumulativeIncrease = cumulativeIncrease;
    }

    public BigDecimal getBuyFeeRate() {
        return buyFeeRate;
    }

    public void setBuyFeeRate(BigDecimal buyFeeRate) {
        this.buyFeeRate = buyFeeRate;
    }

    public BigDecimal getRedeemFeeRate() {
        return redeemFeeRate;
    }

    public void setRedeemFeeRate(BigDecimal redeemFeeRate) {
        this.redeemFeeRate = redeemFeeRate;
    }

    public String getNewlyNetDate() {
        return newlyNetDate;
    }

    public void setNewlyNetDate(String newlyNetDate) {
        this.newlyNetDate = newlyNetDate;
    }

    public BigDecimal getThisYearGain() {
        return thisYearGain;
    }

    public void setThisYearGain(BigDecimal thisYearGain) {
        this.thisYearGain = thisYearGain;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public BigDecimal getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(BigDecimal increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

}