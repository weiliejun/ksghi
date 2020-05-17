package com.itech.ups.app.fund.application.domain;
/*
 * @ huangguohu  2015-08-26*/

import java.io.Serializable;
import java.math.BigDecimal;

public class FundNet implements Serializable {

    private static final int scale = 4;

    private static final long serialVersionUID = -8907618150277364610L;

    private String id;

    private String fundId;

    private String fundName;

    private String fundCode;

    private String netDate;

    private BigDecimal unitNet;

    private BigDecimal cumulativeNet;

    private BigDecimal oneYearGain;

    private BigDecimal cumulativeIncrease;

    private String dataStatus;

    private String remark;

    private String createTime;

    private String creatorId;

    private String creatorName;

    private String editTime;

    private String editorId;

    private String editorName;

    private BigDecimal oneDayIncrease;

    private BigDecimal shanghaiComposite; // 上证指数涨幅

    private BigDecimal csiCumulativeIncrease; // 沪深300指数涨幅

    private BigDecimal shanghaiCompositeNet; // 上证指数

    private BigDecimal csiCumulativeIncreaseNet; // 沪深300指数

    private BigDecimal rehabilitationNet; // 复权净值

    // 2016-01-11 wcl 增加
    private BigDecimal onedayIncrease;

    private BigDecimal oneWeekGain;

    private BigDecimal oneMonthGain;

    private BigDecimal threeMonthGain;

    private BigDecimal halfYearGain;

    private BigDecimal thisYearGain;
    // 2016-01-11 wcl 增加 结束
    private BigDecimal oneDayGain;

    public static int getScale() {
        return scale;
    }

    public BigDecimal getRehabilitationNet() {
        return rehabilitationNet;
    }

    public void setRehabilitationNet(BigDecimal rehabilitationNet) {
        this.rehabilitationNet = rehabilitationNet;
    }

    public BigDecimal getOneDayIncrease() {
        return oneDayIncrease;
    }

    public void setOneDayIncrease(BigDecimal oneDayIncrease) {
        this.oneDayIncrease = oneDayIncrease;
    }

    public BigDecimal getShanghaiCompositeNet() {
        return shanghaiCompositeNet;
    }

    public void setShanghaiCompositeNet(BigDecimal shanghaiCompositeNet) {
        this.shanghaiCompositeNet = shanghaiCompositeNet;
    }

    public BigDecimal getCsiCumulativeIncreaseNet() {
        return csiCumulativeIncreaseNet;
    }

    public void setCsiCumulativeIncreaseNet(BigDecimal csiCumulativeIncreaseNet) {
        this.csiCumulativeIncreaseNet = csiCumulativeIncreaseNet;
    }

    public BigDecimal getOneDayGain() {
        return oneDayGain;
    }

    public void setOneDayGain(BigDecimal oneDayGain) {
        this.oneDayGain = oneDayGain;
    }

    public BigDecimal getShanghaiComposite() {
        return shanghaiComposite;
    }

    public void setShanghaiComposite(BigDecimal shanghaiComposite) {
        this.shanghaiComposite = shanghaiComposite;
    }

    public BigDecimal getCsiCumulativeIncrease() {
        return csiCumulativeIncrease;
    }

    public void setCsiCumulativeIncrease(BigDecimal csiCumulativeIncrease) {
        this.csiCumulativeIncrease = csiCumulativeIncrease;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getNetDate() {
        return netDate;
    }

    public void setNetDate(String netDate) {
        this.netDate = netDate;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        // 保留四位小数
        // unitNet=unitNet.setScale(scale);
        this.unitNet = unitNet;
    }

    public BigDecimal getCumulativeNet() {
        return cumulativeNet;
    }

    public void setCumulativeNet(BigDecimal cumulativeNet) {
        // 保留四位小数
        // cumulativeNet=cumulativeNet.setScale(scale);
        this.cumulativeNet = cumulativeNet;
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

    public BigDecimal getThisYearGain() {
        return thisYearGain;
    }

    public void setThisYearGain(BigDecimal thisYearGain) {
        this.thisYearGain = thisYearGain;
    }

}