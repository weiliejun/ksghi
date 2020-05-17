package com.itech.ups.app.product.application.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ProductDynamicData implements java.io.Serializable {
    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    private String id;
    private String productId;
    private String worthDate;
    private BigDecimal dayWorth;
    private String odds;
    private String status;
    private String tradeDays;
    private String gainDays;
    private String lossDays;
    private String maxGainDays;
    private String maxLossDays;
    private String maxRetreat;
    private String remark;
    private String dataStatus;
    private String createTime;
    private String creatorId;
    private String creatorName;
    private BigDecimal accountManagementFee;
    private String tradingAccountNo;
    private String ifTradingDay;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private String userInfoId;// 投顾注册用户ID
    private String isLatest;// 是否是最新净值
    private BigDecimal accountFund;
    private BigDecimal dayFee;
    private BigDecimal gainAndLostAch;
    private BigDecimal upDownFloating;
    private BigDecimal threeHundredCsi;
    private BigDecimal todayProfitLoss;
    private BigDecimal totalProfitLoss;
    private BigDecimal cumulativeYields;
    public ProductDynamicData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("投顾交易子账户号", "tradingAccountNo");
        mp.put("净值日期", "worthDate");
        mp.put("是否交易日", "ifTradingDay");
        mp.put("当日期初结余", "openingBalance");
        mp.put("当日期末结余", "closingBalance");
        mp.put("当日账户管理费(元)", "accountManagementFee");
        mp.put("当日单位净值", "dayWorth");
        mp.put("交易天数", "tradeDays");
        mp.put("盈利天数", "gainDays");
        mp.put("亏损天数", "lossDays");
        mp.put("最大连续盈利天数", "maxGainDays");
        mp.put("最大连续亏损天数", "maxLossDays");
        mp.put("胜率(%)", "odds");
        mp.put("最大回撤(%)", "maxRetreat");

        mp.put("当日涨跌幅(%)", "upDownFloating");
        mp.put("当日沪深300(%)", "threeHundredCsi");
        mp.put("今日盈亏(元)", "todayProfitLoss");
        mp.put("累计盈亏(元)", "totalProfitLoss");
        mp.put("累计收益率(%)", "cumulativeYields");
        mp.put("账户资金", "accountFund");
        mp.put("当日手续费", "dayFee");
        mp.put("实现盈亏", "gainAndLostAch");
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        ProductDynamicData.df = df;
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        ProductDynamicData.mp = mp;
    }

    public BigDecimal getAccountFund() {
        return accountFund;
    }

    public void setAccountFund(BigDecimal accountFund) {
        this.accountFund = accountFund;
    }

    public BigDecimal getAccountManagementFee() {
        if (accountManagementFee != null) {
            DecimalFormat df = new DecimalFormat("#.00");
            return new BigDecimal(df.format(accountManagementFee));
        }
        return new BigDecimal(0);
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
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

    public BigDecimal getCumulativeYields() {
        return cumulativeYields;
    }

    public void setCumulativeYields(BigDecimal cumulativeYields) {
        this.cumulativeYields = cumulativeYields;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public BigDecimal getDayFee() {
        return dayFee;
    }

    public void setDayFee(BigDecimal dayFee) {
        this.dayFee = dayFee;
    }

    public BigDecimal getDayWorth() {
        // BigDecimal bd = new BigDecimal("");
        if (dayWorth != null) {
            return new BigDecimal(df.format(dayWorth));
        }
        return new BigDecimal(0);
    }

    public void setDayWorth(BigDecimal dayWorth) {
        this.dayWorth = dayWorth;
    }

    public BigDecimal getGainAndLostAch() {
        return gainAndLostAch;
    }

    public void setGainAndLostAch(BigDecimal gainAndLostAch) {
        this.gainAndLostAch = gainAndLostAch;
    }

    public String getGainDays() {
        return gainDays;
    }

    public void setGainDays(String gainDays) {
        this.gainDays = gainDays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIfTradingDay() {
        return ifTradingDay;
    }

    public void setIfTradingDay(String ifTradingDay) {
        this.ifTradingDay = ifTradingDay;
    }

    public String getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(String isLatest) {
        this.isLatest = isLatest;
    }

    public String getLossDays() {
        return lossDays;
    }

    public void setLossDays(String lossDays) {
        this.lossDays = lossDays;
    }

    public String getMaxGainDays() {
        return maxGainDays;
    }

    public void setMaxGainDays(String maxGainDays) {
        this.maxGainDays = maxGainDays;
    }

    public String getMaxLossDays() {
        return maxLossDays;
    }

    public void setMaxLossDays(String maxLossDays) {
        this.maxLossDays = maxLossDays;
    }

    public String getMaxRetreat() {
        return maxRetreat;
    }

    public void setMaxRetreat(String maxRetreat) {
        this.maxRetreat = maxRetreat;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return (closingBalance.intValue() - openingBalance.intValue()) > 0 ? "gain" : "loss";
        // return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getThreeHundredCsi() {
        return threeHundredCsi;
    }

    public void setThreeHundredCsi(BigDecimal threeHundredCsi) {
        this.threeHundredCsi = threeHundredCsi;
    }

    public BigDecimal getTodayProfitLoss() {
        return todayProfitLoss;
    }

    public void setTodayProfitLoss(BigDecimal todayProfitLoss) {
        this.todayProfitLoss = todayProfitLoss;
    }

    public BigDecimal getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(BigDecimal totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public String getTradeDays() {
        return tradeDays;
    }

    public void setTradeDays(String tradeDays) {
        this.tradeDays = tradeDays;
    }

    public String getTradingAccountNo() {
        return tradingAccountNo;
    }

    public void setTradingAccountNo(String tradingAccountNo) {
        this.tradingAccountNo = tradingAccountNo;
    }

    public BigDecimal getUpDownFloating() {
        return upDownFloating;
    }

    public void setUpDownFloating(BigDecimal upDownFloating) {
        this.upDownFloating = upDownFloating;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getWorthDate() {
        return worthDate;
    }

    public void setWorthDate(String worthDate) {
        this.worthDate = worthDate;
    }

}