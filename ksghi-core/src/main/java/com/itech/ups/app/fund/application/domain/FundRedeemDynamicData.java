package com.itech.ups.app.fund.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FundRedeemDynamicData implements Serializable {

    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    private String id;
    private String fundCode;
    private String fundName;
    private String nikeName;
    private String userName;
    private String idcard;
    private Long amount;
    private BigDecimal unitNet;
    private Long surplusCount;
    private BigDecimal newUnitNet;
    private Long assetsValue;
    private String netDate;
    private String newNetDate;
    private String remark;
    private String dataStatus;
    private String createTime;
    private String creatorId;
    private String creatorName;
    private String editTime;
    private String editorId;
    private String editorName;
    private String redeemAmount;
    private String redeemTime;

    public FundRedeemDynamicData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("赎回时间", "redeemTime");
        mp.put("基金代码", "fundCode");
        mp.put("基金名称", "fundName");
        mp.put("用户昵称", "nikeName");
        mp.put("客户姓名", "userName");
        mp.put("身份证号", "idcard");
        mp.put("赎回份额", "amount");
        mp.put("赎回净值", "unitNet");
        mp.put("赎回金额", "redeemAmount");
        mp.put("剩余份额", "surplusCount");
        mp.put("最新净值", "newUnitNet");
        mp.put("资产价值", "assetsValue");
        mp.put("最新净值日期", "newNetDate");
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        FundNetDynamicData.mp = mp;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        FundRedeemDynamicData.df = df;
    }

    public String getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(String redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public String getRedeemTime() {
        return redeemTime;
    }

    public void setRedeemTime(String redeemTime) {
        this.redeemTime = redeemTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getSurplusCount() {
        return surplusCount;
    }

    public void setSurplusCount(Long surplusCount) {
        this.surplusCount = surplusCount;
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
}