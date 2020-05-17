package com.itech.ups.app.organization.application.domain;

import java.math.BigDecimal;

public class OrgCommissionRatio implements java.io.Serializable {
    private String id;

    private String orgId;

    private String productCategory;

    private BigDecimal brokerageMoney;

    private BigDecimal brokerageRate;

    private BigDecimal jumpPoint1;

    private BigDecimal jumpPoint1Rate;

    private BigDecimal jumpPoint2;

    private BigDecimal jumpPoint2Rate;

    private BigDecimal jumpPoint3;

    private BigDecimal jumpPoint3Rate;

    private BigDecimal jumpPoint4;

    private BigDecimal jumpPoint4Rate;

    private BigDecimal jumpPoint5;

    private BigDecimal jumpPoint5Rate;

    private BigDecimal myselfRate;

    private BigDecimal oneLevelRate;

    private BigDecimal secondLevelRate;

    private BigDecimal threeLevelRate;

    private BigDecimal fourLevelRate;

    private BigDecimal fiveLevelRate;

    private String editIme;

    private String editorId;

    private String editorName;

    private String createTime;

    private String remark;

    private String dataStatus;

    public BigDecimal getBrokerageMoney() {
        return brokerageMoney;
    }

    public void setBrokerageMoney(BigDecimal brokerageMoney) {
        this.brokerageMoney = brokerageMoney;
    }

    public BigDecimal getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(BigDecimal brokerageRate) {
        this.brokerageRate = brokerageRate;
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

    public String getEditIme() {
        return editIme;
    }

    public void setEditIme(String editIme) {
        this.editIme = editIme;
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

    public BigDecimal getFiveLevelRate() {
        return fiveLevelRate;
    }

    public void setFiveLevelRate(BigDecimal fiveLevelRate) {
        this.fiveLevelRate = fiveLevelRate;
    }

    public BigDecimal getFourLevelRate() {
        return fourLevelRate;
    }

    public void setFourLevelRate(BigDecimal fourLevelRate) {
        this.fourLevelRate = fourLevelRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getJumpPoint1() {
        return jumpPoint1;
    }

    public void setJumpPoint1(BigDecimal jumpPoint1) {
        this.jumpPoint1 = jumpPoint1;
    }

    public BigDecimal getJumpPoint1Rate() {
        return jumpPoint1Rate;
    }

    public void setJumpPoint1Rate(BigDecimal jumpPoint1Rate) {
        this.jumpPoint1Rate = jumpPoint1Rate;
    }

    public BigDecimal getJumpPoint2() {
        return jumpPoint2;
    }

    public void setJumpPoint2(BigDecimal jumpPoint2) {
        this.jumpPoint2 = jumpPoint2;
    }

    public BigDecimal getJumpPoint2Rate() {
        return jumpPoint2Rate;
    }

    public void setJumpPoint2Rate(BigDecimal jumpPoint2Rate) {
        this.jumpPoint2Rate = jumpPoint2Rate;
    }

    public BigDecimal getJumpPoint3() {
        return jumpPoint3;
    }

    public void setJumpPoint3(BigDecimal jumpPoint3) {
        this.jumpPoint3 = jumpPoint3;
    }

    public BigDecimal getJumpPoint3Rate() {
        return jumpPoint3Rate;
    }

    public void setJumpPoint3Rate(BigDecimal jumpPoint3Rate) {
        this.jumpPoint3Rate = jumpPoint3Rate;
    }

    public BigDecimal getJumpPoint4() {
        return jumpPoint4;
    }

    public void setJumpPoint4(BigDecimal jumpPoint4) {
        this.jumpPoint4 = jumpPoint4;
    }

    public BigDecimal getJumpPoint4Rate() {
        return jumpPoint4Rate;
    }

    public void setJumpPoint4Rate(BigDecimal jumpPoint4Rate) {
        this.jumpPoint4Rate = jumpPoint4Rate;
    }

    public BigDecimal getJumpPoint5() {
        return jumpPoint5;
    }

    public void setJumpPoint5(BigDecimal jumpPoint5) {
        this.jumpPoint5 = jumpPoint5;
    }

    public BigDecimal getJumpPoint5Rate() {
        return jumpPoint5Rate;
    }

    public void setJumpPoint5Rate(BigDecimal jumpPoint5Rate) {
        this.jumpPoint5Rate = jumpPoint5Rate;
    }

    public BigDecimal getMyselfRate() {
        return myselfRate;
    }

    public void setMyselfRate(BigDecimal myselfRate) {
        this.myselfRate = myselfRate;
    }

    public BigDecimal getOneLevelRate() {
        return oneLevelRate;
    }

    public void setOneLevelRate(BigDecimal oneLevelRate) {
        this.oneLevelRate = oneLevelRate;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getSecondLevelRate() {
        return secondLevelRate;
    }

    public void setSecondLevelRate(BigDecimal secondLevelRate) {
        this.secondLevelRate = secondLevelRate;
    }

    public BigDecimal getThreeLevelRate() {
        return threeLevelRate;
    }

    public void setThreeLevelRate(BigDecimal threeLevelRate) {
        this.threeLevelRate = threeLevelRate;
    }
}