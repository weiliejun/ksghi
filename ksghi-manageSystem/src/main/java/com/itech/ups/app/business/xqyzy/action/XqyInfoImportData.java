package com.itech.ups.app.business.xqyzy.action;

import com.itech.ups.app.xqyinfo.application.domain.XqyInfo;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class XqyInfoImportData extends XqyInfo implements Serializable {

    public static Map<Object, String> mp = new HashMap<Object, String>();
    private static DecimalFormat df = new DecimalFormat("#.0000");

    public XqyInfoImportData() {
        df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入

        mp.put("投保人", "tbr");
        mp.put("被保险人", "bbr");
        mp.put("被保险人身份证号", "bbrzjhm");
        mp.put("投保单号", "tbdh");
        mp.put("保单号", "bdh");
        mp.put("保险公司", "bxgs");
        mp.put("险种", "xzdm");
        mp.put("险种名称", "xzmc");
        mp.put("保额", "bxje");
        mp.put("缴费方式", "jffs");
        mp.put("缴费年期", "jfnq");
        mp.put("保险期间", "bxqj");
        mp.put("规模保费", "sjbf");
        mp.put("标准保费", "sjxj");
        mp.put("代理人姓名", "ywy");
        mp.put("结算人姓名", "jsr");
        mp.put("实际销售人", "sjxsr");
        mp.put("投保日期", "tbrq");
        mp.put("承保日期", "cbrq");
        mp.put("签收回执日期", "hzqsrq");
        mp.put("犹豫期过期日期", "yyqgqrq");
    }

    public static Map<Object, String> getMp() {
        return mp;
    }

    public static void setMp(Map<Object, String> mp) {
        XqyInfoImportData.mp = mp;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static void setDf(DecimalFormat df) {
        XqyInfoImportData.df = df;
    }


}