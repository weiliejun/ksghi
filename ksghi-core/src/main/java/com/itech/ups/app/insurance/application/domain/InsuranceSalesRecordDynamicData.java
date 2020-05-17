package com.itech.ups.app.insurance.application.domain;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class InsuranceSalesRecordDynamicData implements Serializable {

    private static final long serialVersionUID = 7658940244260084786L;
    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    private String code;
    private String id;
    private String productId;
    private String productName;
    private String companyName;
    private String category;
    private String insuranceCoverage;
    private String timeLimit;
    private String payType;
    private String upperAndLowerFrame;
    private Long buyCount;
    private String createTime;
    private String creatorId;
    private String creatorName;
    private String editTime;
    private String editorId;
    private String editorName;
    private String dataStatus;

    public InsuranceSalesRecordDynamicData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("保险产品编号", "code");
        mp.put("保险产品名称", "productName");
        mp.put("保险公司", "companyName");
        mp.put("保险类型", "category");
        mp.put("投保范围", "insuranceCoverage");
        mp.put("保险期间", "timeLimit");
        mp.put("交费方式", "payType");
        mp.put("上架状态", "upperAndLowerFrame");
        mp.put("购买人数", "buyCount");
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        InsuranceSalesRecordDynamicData.df = df;
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        InsuranceSalesRecordDynamicData.mp = mp;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getUpperAndLowerFrame() {
        return upperAndLowerFrame;
    }

    public void setUpperAndLowerFrame(String upperAndLowerFrame) {
        this.upperAndLowerFrame = upperAndLowerFrame;
    }
}