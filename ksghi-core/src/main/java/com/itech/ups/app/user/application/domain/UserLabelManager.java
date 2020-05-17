package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserLabelManager implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2306328998925614821L;

    private String id;

    private String labelName;

    private BigDecimal oneLevel;

    private BigDecimal twoLevel;

    private BigDecimal threeLevel;

    private BigDecimal fourLevel;

    private BigDecimal fiveLevel;

    private BigDecimal sixLevel;

    private BigDecimal sevenLevel;

    private BigDecimal recommended;

    private BigDecimal aloneInvest;

    private String createTime;

    private String remark;

    private String dataStatus;

    private String editorId;

    private String editorName;

    private String editTime;

    private String productId;

    private BigDecimal raisingRate;

    private BigDecimal continuedInvestmentRate;

    private BigDecimal firstTenderCash;

    private BigDecimal bigestTenderCash;

    private BigDecimal lastTenderCash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public BigDecimal getOneLevel() {
        return oneLevel;
    }

    public void setOneLevel(BigDecimal oneLevel) {
        this.oneLevel = oneLevel;
    }

    public BigDecimal getTwoLevel() {
        return twoLevel;
    }

    public void setTwoLevel(BigDecimal twoLevel) {
        this.twoLevel = twoLevel;
    }

    public BigDecimal getThreeLevel() {
        return threeLevel;
    }

    public void setThreeLevel(BigDecimal threeLevel) {
        this.threeLevel = threeLevel;
    }

    public BigDecimal getFourLevel() {
        return fourLevel;
    }

    public void setFourLevel(BigDecimal fourLevel) {
        this.fourLevel = fourLevel;
    }

    public BigDecimal getFiveLevel() {
        return fiveLevel;
    }

    public void setFiveLevel(BigDecimal fiveLevel) {
        this.fiveLevel = fiveLevel;
    }

    public BigDecimal getSixLevel() {
        return sixLevel;
    }

    public void setSixLevel(BigDecimal sixLevel) {
        this.sixLevel = sixLevel;
    }

    public BigDecimal getSevenLevel() {
        return sevenLevel;
    }

    public void setSevenLevel(BigDecimal sevenLevel) {
        this.sevenLevel = sevenLevel;
    }

    public BigDecimal getRecommended() {
        return recommended;
    }

    public void setRecommended(BigDecimal recommended) {
        this.recommended = recommended;
    }

    public BigDecimal getAloneInvest() {
        return aloneInvest;
    }

    public void setAloneInvest(BigDecimal aloneInvest) {
        this.aloneInvest = aloneInvest;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getRaisingRate() {
        return raisingRate;
    }

    public void setRaisingRate(BigDecimal raisingRate) {
        this.raisingRate = raisingRate;
    }

    public BigDecimal getContinuedInvestmentRate() {
        return continuedInvestmentRate;
    }

    public void setContinuedInvestmentRate(BigDecimal continuedInvestmentRate) {
        this.continuedInvestmentRate = continuedInvestmentRate;
    }

    public BigDecimal getFirstTenderCash() {
        return firstTenderCash;
    }

    public void setFirstTenderCash(BigDecimal firstTenderCash) {
        this.firstTenderCash = firstTenderCash;
    }

    public BigDecimal getBigestTenderCash() {
        return bigestTenderCash;
    }

    public void setBigestTenderCash(BigDecimal bigestTenderCash) {
        this.bigestTenderCash = bigestTenderCash;
    }

    public BigDecimal getLastTenderCash() {
        return lastTenderCash;
    }

    public void setLastTenderCash(BigDecimal lastTenderCash) {
        this.lastTenderCash = lastTenderCash;
    }
}