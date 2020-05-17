package com.itech.ups.app.activity.application.domain;

import java.io.Serializable;

public class GiftModel implements Serializable {
    /**
     * @fields serialVersionUID
     */

    private static final long serialVersionUID = 1L;

    private String id;

    private String giftName;

    private String giftType;

    private String integral;

    private String exchangeType;

    private String lotteryId;

    private String lotteryValue;

    private String pictureUrl;

    private String activateCondition;

    private String description;

    private String remark;

    private String createTime;

    private String giftStatus;

    private String dataStatus;

    private String shadepictureUrl;

    private String category;

    private String activityId;

    private String lotteryType;

    private String useScene;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getLotteryValue() {
        return lotteryValue;
    }

    public void setLotteryValue(String lotteryValue) {
        this.lotteryValue = lotteryValue;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getActivateCondition() {
        return activateCondition;
    }

    public void setActivateCondition(String activateCondition) {
        this.activateCondition = activateCondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(String giftStatus) {
        this.giftStatus = giftStatus;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getShadepictureUrl() {
        return shadepictureUrl;
    }

    public void setShadepictureUrl(String shadepictureUrl) {
        this.shadepictureUrl = shadepictureUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getUseScene() {
        return useScene;
    }

    public void setUseScene(String useScene) {
        this.useScene = useScene;
    }
}