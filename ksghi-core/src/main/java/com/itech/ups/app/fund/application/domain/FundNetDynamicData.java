package com.itech.ups.app.fund.application.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FundNetDynamicData {
    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    private String id;
    private String fundId;
    private String fundName;
    private String fundCode;
    private String netDate;
    private BigDecimal unitNet;
    private BigDecimal cumulativeNet;
    private BigDecimal oneYearGain;
    private BigDecimal cumulativeIncrease;
    private BigDecimal shanghaiComposite;
    private BigDecimal csiCumulativeIncrease;
    private String dataStatus;
    private String remark;
    private String createTime;
    private String creatorId;
    private String creatorName;
    private String editTime;
    private String editorId;
    private String editorName;
    private BigDecimal rehabilitationNet; // 复权净值

    public FundNetDynamicData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("基金代码", "fundCode");
        mp.put("净值日期", "netDate");
        mp.put("单位净值", "unitNet");
        mp.put("累计净值", "cumulativeNet");
        mp.put("备注", "remark");
        mp.put("复权净值", "rehabilitationNet");
        mp.put("近一年收益率", "oneYearGain");
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        FundNetDynamicData.df = df;
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        FundNetDynamicData.mp = mp;
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

    public BigDecimal getCsiCumulativeIncrease() {
        return csiCumulativeIncrease;
    }

    public void setCsiCumulativeIncrease(BigDecimal csiCumulativeIncrease) {
        this.csiCumulativeIncrease = csiCumulativeIncrease;
    }

    public BigDecimal getCumulativeIncrease() {
        return cumulativeIncrease;
    }

    public void setCumulativeIncrease(BigDecimal cumulativeIncrease) {
        this.cumulativeIncrease = cumulativeIncrease;
    }

    public BigDecimal getCumulativeNet() {
        return cumulativeNet;
    }

    public void setCumulativeNet(BigDecimal cumulativeNet) {
        this.cumulativeNet = cumulativeNet;
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

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetDate() {
        return netDate;
    }

    public void setNetDate(String netDate) {
        this.netDate = netDate;
    }

    public BigDecimal getOneYearGain() {
        return oneYearGain;
    }

    public void setOneYearGain(BigDecimal oneYearGain) {
        this.oneYearGain = oneYearGain;
    }

    public BigDecimal getRehabilitationNet() {
        return rehabilitationNet;
    }

    public void setRehabilitationNet(BigDecimal rehabilitationNet) {
        this.rehabilitationNet = rehabilitationNet;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getShanghaiComposite() {
        return shanghaiComposite;
    }

    public void setShanghaiComposite(BigDecimal shanghaiComposite) {
        this.shanghaiComposite = shanghaiComposite;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        this.unitNet = unitNet;
    }

}