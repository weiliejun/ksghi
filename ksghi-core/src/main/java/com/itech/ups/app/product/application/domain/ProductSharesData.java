package com.itech.ups.app.product.application.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ProductSharesData implements java.io.Serializable {

    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");
    private BigDecimal accountFund;
    private BigDecimal dayFee;
    private BigDecimal gainAndLostAch;
    private String tradingAccountNo;
    private String worthDate;
    private String ifTradingDay;
    private BigDecimal threeHundredCsi;
    private BigDecimal firstBalance;
    public ProductSharesData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("投顾交易子账户号", "tradingAccountNo");
        mp.put("净值日期", "worthDate");
        mp.put("是否交易日", "ifTradingDay");
        mp.put("初始资金", "firstBalance");
        mp.put("当日沪深300(%)", "threeHundredCsi");
        mp.put("账户资金", "accountFund");
        mp.put("当日手续费", "dayFee");
        mp.put("实现盈亏", "gainAndLostAch");

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

    public BigDecimal getDayFee() {
        return dayFee;
    }

    public void setDayFee(BigDecimal dayFee) {
        this.dayFee = dayFee;
    }

    public BigDecimal getFirstBalance() {
        return firstBalance;
    }

    public void setFirstBalance(BigDecimal firstBalance) {
        this.firstBalance = firstBalance;
    }

    public BigDecimal getGainAndLostAch() {
        return gainAndLostAch;
    }

    public void setGainAndLostAch(BigDecimal gainAndLostAch) {
        this.gainAndLostAch = gainAndLostAch;
    }

    public String getIfTradingDay() {
        return ifTradingDay;
    }

    public void setIfTradingDay(String ifTradingDay) {
        this.ifTradingDay = ifTradingDay;
    }

    public BigDecimal getThreeHundredCsi() {
        return threeHundredCsi;
    }

    public void setThreeHundredCsi(BigDecimal threeHundredCsi) {
        this.threeHundredCsi = threeHundredCsi;
    }

    public String getTradingAccountNo() {
        return tradingAccountNo;
    }

    public void setTradingAccountNo(String tradingAccountNo) {
        this.tradingAccountNo = tradingAccountNo;
    }

    public String getWorthDate() {
        return worthDate;
    }

    public void setWorthDate(String worthDate) {
        this.worthDate = worthDate;
    }

}
