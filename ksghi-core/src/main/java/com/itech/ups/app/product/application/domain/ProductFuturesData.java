package com.itech.ups.app.product.application.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

//期货交易数据
public class ProductFuturesData implements java.io.Serializable {
    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    BigDecimal solidlyGainDays;// 连续盈利天数
    BigDecimal solidlyLossDays;// 连续亏损天数
    private String Id;
    // 客户内部资金账户
    private String tradingAccountNo;
    // 交易日期
    private String worthDate;
    // 上日结存
    private BigDecimal yesterdayBalance;
    // 客户权益
    private BigDecimal customerEquity;
    // 当日存取合计
    private BigDecimal todayTotalAccess;
    // 质押金
    private BigDecimal qualityDeposit;
    // 当日盈亏
    private BigDecimal dayProfitAndLoss;
    // 保证金占用
    private BigDecimal marginOccupancy;
    // 当日手续费
    private BigDecimal dayFee;
    // 可用资金
    private BigDecimal availableFunds;
    // 当日结存
    private BigDecimal todayBalance;

    // 风险度（四位
    private BigDecimal riskDegree;

    // 追加保证金
    private BigDecimal additionalBond;

    // 客户名称
    private String customerName;

    // 期货公司名称
    private String futuresCompanyName;

    private BigDecimal dayWorth;// 当日净值

    private BigDecimal finalNetWorth;// 当日期末净值

    private BigDecimal accountManagementFee;// 账户管理费

    private BigDecimal totalAccountManagementFee;// 累计账户管理费

    private BigDecimal firstBlance;// 初始资金

    private BigDecimal odds;// 胜率 %

    private String status;// 当日状态 gain-盈利/loss-亏损

    private BigDecimal tradeDays;// 交易天数

    private BigDecimal gainDays;// 盈利天数

    private BigDecimal lossDays;// 亏损天数
    // private BigDecimal totalProfitLoss;//累计盈亏

    private BigDecimal maxGainDays;// 最大连续盈利
    private BigDecimal maxLossDays;// 最大连续亏损天数
    private BigDecimal maxRetreat;// 最大回撤
    private BigDecimal retreat;// 回撤
    private BigDecimal openingBalance;// 当日期初余额
    private BigDecimal closingBalance;// 当日期末余额
    private String ifTradingDay;// 是否交易日
    private String dataStatus;
    private String createTime;
    private String creatorId;
    private String creatorName;
    private String productId;
    private BigDecimal accountFund; // 账户资金净资产
    private BigDecimal upDownFloating; // 当日涨跌幅
    private BigDecimal threeHundredCSI; // 当日沪深300%
    private BigDecimal todayProfitLoss; // 今日盈亏
    private BigDecimal totalProfitLoss; // 总盈亏
    private BigDecimal todayCounterFee; // 今日手续费
    private BigDecimal cumulativeFee; // 累计手续费
    private BigDecimal cumulativeYields; // 累计收益率
    private BigDecimal cumulativeProfitLoss; // 累计盈亏
    public ProductFuturesData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("客户内部资金账户", "tradingAccountNo");
        mp.put("客户名称", "customerName");
        mp.put("期货公司名称", "futuresCompanyName");
        mp.put("交易日期", "worthDate");
        mp.put("上日结存", "yesterdayBalance");
        mp.put("客户权益", "customerEquity");
        mp.put("当日存取合计", "todayTotalAccess");
        mp.put("质押金", "qualityDeposit");
        mp.put("当日盈亏", "dayProfitAndLoss");
        mp.put("保证金占用", "marginOccupancy");
        mp.put("当日手续费", "dayFee");
        mp.put("可用资金", "availableFunds");
        mp.put("当日结存", "todayBalance");
        mp.put("风险度", "riskDegree");
        mp.put("追加保证金", "additionalBond");
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
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public BigDecimal getAdditionalBond() {
        return additionalBond;
    }

    public void setAdditionalBond(BigDecimal additionalBond) {
        this.additionalBond = additionalBond;
    }

    public BigDecimal getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(BigDecimal availableFunds) {
        this.availableFunds = availableFunds;
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

    public BigDecimal getCumulativeFee() {
        return cumulativeFee;
    }

    // public BigDecimal getTotalProfitLoss() {
    // return totalProfitLoss;
    // }

    public void setCumulativeFee(BigDecimal cumulativeFee) {
        this.cumulativeFee = cumulativeFee;
    }

    public BigDecimal getCumulativeProfitLoss() {
        return cumulativeProfitLoss;
    }

    public void setCumulativeProfitLoss(BigDecimal cumulativeProfitLoss) {
        this.cumulativeProfitLoss = cumulativeProfitLoss;
    }

    public BigDecimal getCumulativeYields() {
        return cumulativeYields;
    }

    public void setCumulativeYields(BigDecimal cumulativeYields) {
        this.cumulativeYields = cumulativeYields;
    }

    public BigDecimal getCustomerEquity() {
        return customerEquity;
    }

    public void setCustomerEquity(BigDecimal customerEquity) {
        this.customerEquity = customerEquity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public BigDecimal getDayProfitAndLoss() {
        return dayProfitAndLoss;
    }

    public void setDayProfitAndLoss(BigDecimal dayProfitAndLoss) {
        this.dayProfitAndLoss = dayProfitAndLoss;
    }

    public BigDecimal getDayWorth() {
        return dayWorth;
    }

    public void setDayWorth(BigDecimal dayWorth) {
        this.dayWorth = dayWorth;
    }

    public BigDecimal getFinalNetWorth() {
        return finalNetWorth;
    }

    public void setFinalNetWorth(BigDecimal finalNetWorth) {
        this.finalNetWorth = finalNetWorth;
    }

    public BigDecimal getFirstBlance() {
        return firstBlance;
    }

    public void setFirstBlance(BigDecimal firstBlance) {
        this.firstBlance = firstBlance;
    }

    public String getFuturesCompanyName() {
        return futuresCompanyName;
    }

    public void setFuturesCompanyName(String futuresCompanyName) {
        this.futuresCompanyName = futuresCompanyName;
    }

    public BigDecimal getGainDays() {
        return gainDays;
    }

    public void setGainDays(BigDecimal gainDays) {
        this.gainDays = gainDays;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIfTradingDay() {
        return ifTradingDay;
    }

    public void setIfTradingDay(String ifTradingDay) {
        this.ifTradingDay = ifTradingDay;
    }

    public BigDecimal getLossDays() {
        return lossDays;
    }

    public void setLossDays(BigDecimal lossDays) {
        this.lossDays = lossDays;
    }

    public BigDecimal getMarginOccupancy() {
        return marginOccupancy;
    }

    public void setMarginOccupancy(BigDecimal marginOccupancy) {
        this.marginOccupancy = marginOccupancy;
    }

    public BigDecimal getMaxGainDays() {
        return maxGainDays;
    }

    public void setMaxGainDays(BigDecimal maxGainDays) {
        this.maxGainDays = maxGainDays;
    }

    public BigDecimal getMaxLossDays() {
        return maxLossDays;
    }

    public void setMaxLossDays(BigDecimal maxLossDays) {
        this.maxLossDays = maxLossDays;
    }

    public BigDecimal getMaxRetreat() {
        return maxRetreat;
    }

    public void setMaxRetreat(BigDecimal maxRetreat) {
        this.maxRetreat = maxRetreat;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
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

    public BigDecimal getQualityDeposit() {
        return qualityDeposit;
    }

    public void setQualityDeposit(BigDecimal qualityDeposit) {
        this.qualityDeposit = qualityDeposit;
    }

    public BigDecimal getRetreat() {
        return retreat;
    }

    public void setRetreat(BigDecimal retreat) {
        this.retreat = retreat;
    }

    public BigDecimal getRiskDegree() {
        return riskDegree;
    }

    public void setRiskDegree(BigDecimal riskDegree) {
        this.riskDegree = riskDegree;
    }

    // public void setTotalProfitLoss(BigDecimal totalProfitLoss) {
    // this.totalProfitLoss = totalProfitLoss;
    // }
    public BigDecimal getSolidlyGainDays() {
        return solidlyGainDays;
    }

    public void setSolidlyGainDays(BigDecimal solidlyGainDays) {
        this.solidlyGainDays = solidlyGainDays;
    }

    public BigDecimal getSolidlyLossDays() {
        return solidlyLossDays;
    }

    public void setSolidlyLossDays(BigDecimal solidlyLossDays) {
        this.solidlyLossDays = solidlyLossDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getThreeHundredCSI() {
        return threeHundredCSI;
    }

    public void setThreeHundredCSI(BigDecimal threeHundredCSI) {
        this.threeHundredCSI = threeHundredCSI;
    }

    public BigDecimal getTodayBalance() {
        return todayBalance;
    }

    public void setTodayBalance(BigDecimal todayBalance) {
        this.todayBalance = todayBalance;
    }

    public BigDecimal getTodayCounterFee() {
        return todayCounterFee;
    }

    public void setTodayCounterFee(BigDecimal todayCounterFee) {
        this.todayCounterFee = todayCounterFee;
    }

    public BigDecimal getTodayProfitLoss() {
        return todayProfitLoss;
    }

    public void setTodayProfitLoss(BigDecimal todayProfitLoss) {
        this.todayProfitLoss = todayProfitLoss;
    }

    public BigDecimal getTodayTotalAccess() {
        return todayTotalAccess;
    }

    public void setTodayTotalAccess(BigDecimal todayTotalAccess) {
        this.todayTotalAccess = todayTotalAccess;
    }

    public BigDecimal getTotalAccountManagementFee() {
        return totalAccountManagementFee;
    }

    public void setTotalAccountManagementFee(BigDecimal totalAccountManagementFee) {
        this.totalAccountManagementFee = totalAccountManagementFee;
    }

    public BigDecimal getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(BigDecimal totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public BigDecimal getTradeDays() {
        return tradeDays;
    }

    public void setTradeDays(BigDecimal tradeDays) {
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

    public String getWorthDate() {
        return worthDate;
    }

    public void setWorthDate(String worthDate) {
        this.worthDate = worthDate;
    }

    public BigDecimal getYesterdayBalance() {
        return yesterdayBalance;
    }

    public void setYesterdayBalance(BigDecimal yesterdayBalance) {
        this.yesterdayBalance = yesterdayBalance;
    }

}
