package com.itech.ups.app.business.ccxbd.action;

import com.itech.ups.app.ccxbd.application.domain.Ccxbd;
import com.itech.ups.app.fund.application.domain.FundNetDynamicData;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CcxbdImportData extends Ccxbd implements Serializable {

    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");

    public CcxbdImportData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
        mp.put("投保日期", "tbrq");
        mp.put("打印日期", "dyrq");
        mp.put("被保险人", "bbr");
        mp.put("保单号", "bdh");
        mp.put("品名", "xzmc");
        mp.put("批单号", "pdh");
        mp.put("保险费", "hsbf");
        mp.put("保险公司结算手续费比例", "sxfbl");
        mp.put("手续费", "sxfje");
        mp.put("结算比例", "jsbl");
        mp.put("佣金金额", "yjje");
        mp.put("国恒公司", "ghgsyj");
        mp.put("结算人", "ywy");
        mp.put("佣金结算日期", "yjjsrq");
        mp.put("佣金结算公司", "cbgs");
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        CcxbdImportData.mp = mp;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        CcxbdImportData.df = df;
    }


}