package com.itech.ups.app.fund.application.domain;
/*
 * @ huangguohu  2015-08-26*/

import java.io.Serializable;
import java.math.BigDecimal;

public class GroupNet implements Serializable {

    private static final int scale = 4;

    private static final long serialVersionUID = -8907618150277364610L;
    private String fundGroupId;
    private String fundId;
    private String fundCode;
    private String netDate;
    private BigDecimal cumulativeIncrease;
    private BigDecimal unitNet;
    private BigDecimal cumulativeNet;
    private BigDecimal investmentRatio;
    private BigDecimal rehabilitationNet;
    private BigDecimal onedayIncrease;
    private BigDecimal oneWeekGain;
    private BigDecimal oneMonthGain;
    private BigDecimal threeMonthGain;
    private BigDecimal halfYearGain;
    private BigDecimal oneYearGain;
    private BigDecimal thisYearGain;

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundGroupId() {
        return fundGroupId;
    }

    public void setFundGroupId(String fundGroupId) {
        this.fundGroupId = fundGroupId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public BigDecimal getHalfYearGain() {
        return halfYearGain;
    }

    public void setHalfYearGain(BigDecimal halfYearGain) {
        this.halfYearGain = halfYearGain;
    }

    public BigDecimal getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(BigDecimal investmentRatio) {
        this.investmentRatio = investmentRatio;
    }

    public String getNetDate() {
        return netDate;
    }

    public void setNetDate(String netDate) {
        this.netDate = netDate;
    }

    public BigDecimal getOnedayIncrease() {
        return onedayIncrease;
    }

    public void setOnedayIncrease(BigDecimal onedayIncrease) {
        this.onedayIncrease = onedayIncrease;
    }

    public BigDecimal getOneMonthGain() {
        return oneMonthGain;
    }

    public void setOneMonthGain(BigDecimal oneMonthGain) {
        this.oneMonthGain = oneMonthGain;
    }

    public BigDecimal getOneWeekGain() {
        return oneWeekGain;
    }

    public void setOneWeekGain(BigDecimal oneWeekGain) {
        this.oneWeekGain = oneWeekGain;
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

    public BigDecimal getThisYearGain() {
        return thisYearGain;
    }

    public void setThisYearGain(BigDecimal thisYearGain) {
        this.thisYearGain = thisYearGain;
    }

    public BigDecimal getThreeMonthGain() {
        return threeMonthGain;
    }

    public void setThreeMonthGain(BigDecimal threeMonthGain) {
        this.threeMonthGain = threeMonthGain;
    }

    public BigDecimal getUnitNet() {
        return unitNet;
    }

    public void setUnitNet(BigDecimal unitNet) {
        this.unitNet = unitNet;
    }
}