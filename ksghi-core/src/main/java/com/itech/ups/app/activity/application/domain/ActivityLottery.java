package com.itech.ups.app.activity.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ActivityLottery implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8850205146003138750L;

    private String id;

    private String activityId;

    private String code;

    private String type;

    private String isDonation;

    private String lotteryValue;

    private String isExclusion;

    private Long total;

    private String isLimit;

    private String giveTimeRule;

    private String giveTime;

    private String giveRule;

    private String giveCondition;

    private String name;

    private String giveConditionContent;

    private String startTime;

    private String endTime;

    private String isGiveTimeLimit;

    private String lotteryEndTime;

    private String isExchangeTimeLimit;

    private String useCondition;

    private String useConditionContent;

    private BigDecimal highBonus;

    private String remark;

    private String createTime;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsDonation() {
        return isDonation;
    }

    public void setIsDonation(String isDonation) {
        this.isDonation = isDonation;
    }

    public String getLotteryValue() {
        return lotteryValue;
    }

    public void setLotteryValue(String lotteryValue) {
        this.lotteryValue = lotteryValue;
    }

    public String getIsExclusion() {
        return isExclusion;
    }

    public void setIsExclusion(String isExclusion) {
        this.isExclusion = isExclusion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(String isLimit) {
        this.isLimit = isLimit;
    }

    public String getGiveTimeRule() {
        return giveTimeRule;
    }

    public void setGiveTimeRule(String giveTimeRule) {
        this.giveTimeRule = giveTimeRule;
    }

    public String getGiveTime() {
        return giveTime;
    }

    public void setGiveTime(String giveTime) {
        this.giveTime = giveTime;
    }

    public String getGiveRule() {
        return giveRule;
    }

    public void setGiveRule(String giveRule) {
        this.giveRule = giveRule;
    }

    public String getGiveCondition() {
        return giveCondition;
    }

    public void setGiveCondition(String giveCondition) {
        this.giveCondition = giveCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiveConditionContent() {
        return giveConditionContent;
    }

    public void setGiveConditionContent(String giveConditionContent) {
        this.giveConditionContent = giveConditionContent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIsGiveTimeLimit() {
        return isGiveTimeLimit;
    }

    public void setIsGiveTimeLimit(String isGiveTimeLimit) {
        this.isGiveTimeLimit = isGiveTimeLimit;
    }

    public String getLotteryEndTime() {
        return lotteryEndTime;
    }

    public void setLotteryEndTime(String lotteryEndTime) {
        this.lotteryEndTime = lotteryEndTime;
    }

    public String getIsExchangeTimeLimit() {
        return isExchangeTimeLimit;
    }

    public void setIsExchangeTimeLimit(String isExchangeTimeLimit) {
        this.isExchangeTimeLimit = isExchangeTimeLimit;
    }

    public String getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(String useCondition) {
        this.useCondition = useCondition;
    }

    public String getUseConditionContent() {
        return useConditionContent;
    }

    public void setUseConditionContent(String useConditionContent) {
        this.useConditionContent = useConditionContent;
    }

    public BigDecimal getHighBonus() {
        return highBonus;
    }

    public void setHighBonus(BigDecimal highBonus) {
        this.highBonus = highBonus;
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

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}