package com.itech.ups.app.fund.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wcl 组合基金净值
 */
public class FundGroupNet implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7548653821858540701L;

    private String id;

    private String fundGroupId;

    private BigDecimal unitNet;

    private BigDecimal cumulativeNet;

    private BigDecimal rehabilitationNet;

    private BigDecimal onedayIncrease;

    private BigDecimal oneWeekGain;

    private BigDecimal oneMonthGain;

    private BigDecimal threeMonthGain;

    private BigDecimal halfYearGain;

    private BigDecimal oneYearGain;

    private BigDecimal cumulativeIncrease;

    private String netDate;

    private String remark;

    private String dataStatus;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private BigDecimal thisYearGain;

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

    public BigDecimal getRehabilitationNet() {
        return rehabilitationNet;
    }

    public void setRehabilitationNet(BigDecimal rehabilitationNet) {
        this.rehabilitationNet = rehabilitationNet;
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

    public BigDecimal getOneYearGain() {
        return oneYearGain;
    }

    public void setOneYearGain(BigDecimal oneYearGain) {
        this.oneYearGain = oneYearGain;
    }

    public BigDecimal getCumulativeIncrease() {
        return cumulativeIncrease;
    }

    public void setCumulativeIncrease(BigDecimal cumulativeIncrease) {
        this.cumulativeIncrease = cumulativeIncrease;
    }

    public String getNetDate() {
        return netDate;
    }

    public void setNetDate(String netDate) {
        this.netDate = netDate;
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

    public BigDecimal getThisYearGain() {
        return thisYearGain;
    }

    public void setThisYearGain(BigDecimal thisYearGain) {
        this.thisYearGain = thisYearGain;
    }

}