package com.itech.ups.base.web.taglibs.code;

import java.util.HashMap;

/**
 * A factory to create different Preferences.
 *
 * @author mike chen
 */
public class CodesFactory {

    private static final String DEFAULT_CODE_PROPERTIES_LOCATION = "/config/applicationCode.properties";

    private static CodesFactory instance = null;

    private Codes codes = null;

    private HashMap sourceCode = new HashMap();

    private CodesFactory() {
        String propertiesLocation = DEFAULT_CODE_PROPERTIES_LOCATION;
        codes = new PropertiesCodes(propertiesLocation);
        sourceCode.put("baidu", "//www.baidu.com/");
        sourceCode.put("google", "//www.google.com.hk/");
        sourceCode.put("sogou", "//www.sogou.com/");
        sourceCode.put("soso", "//www.soso.com/");
        sourceCode.put("haosou", "//www.haosou.com/");
        sourceCode.put("chekb", "//www.chekb.com/");
        sourceCode.put("youku", "//static.atm.youku.com");
        sourceCode.put("tudou", "//www.tudou.com/");
        sourceCode.put("hao360", "//www.hao360.com/");
        sourceCode.put("wangdaizhijia", "//www.wangdaizhijia.com/");
        sourceCode.put("p2pchina", "//www.p2pchina.com/");
        sourceCode.put("weixin", "//www.weixin.com/");
        sourceCode.put("bing", "//cn.bing.com/");
        sourceCode.put("lagou", "//www.lagou.com/");
        sourceCode.put("19lou", "//www.19lou.com/");
        sourceCode.put("qzone", "//qzone.qq.com/");
        sourceCode.put("weibo", "//www.weibo.com/");
        sourceCode.put("xueqiu", "//xueqiu.com/");
        sourceCode.put("qqweixin", "//support.weixin.qq.com");
        sourceCode.put("qqmail", "https://mail.qq.com/");
        sourceCode.put("163mail", "//mail.163.com/");
        sourceCode.put("58dm", "//www.58dm.com/");
        sourceCode.put("shenchuang", "//www.shenchuang.com/");
        sourceCode.put("renrenshare", "//share.renren.com/");
        sourceCode.put("126mail", "//mail.126.com/");
        sourceCode.put("cnrmobile", "//cnrmobile.com/");
        sourceCode.put("xilu", "//www.xilu.com/");
        sourceCode.put("erongtu", "//www.erongtu.com/");
        sourceCode.put("medai360", "//www.medai360.com/");
        sourceCode.put("p2peye", "//www.p2peye.com/");
        sourceCode.put("zhongniu", "//www.zhongniu.com/");
        sourceCode.put("jr123", "//www.jr123.com/");
        sourceCode.put("wdzx", "//hao.wdzx.com/");
        sourceCode.put("wdttd", "//www.wdttd.com/");
        sourceCode.put("wangdai3", "//gps.wangdai3.com/");
        sourceCode.put("wangdaisky", "//www.wangdaisky.com/");
        sourceCode.put("wdj168", "//www.wdj168.com/");
        sourceCode.put("wangdaizhijia", "//www.wangdaizhijia.com/");
        sourceCode.put("dierkezhan", "//dierkezhan.com/");
        sourceCode.put("wangdaiguancha", "//www.wangdaiguancha.com/");
        sourceCode.put("value500", "//value500.com/");
        sourceCode.put("daichuqu", "//www.daichuqu.com/");
        sourceCode.put("wangdaiqianyan", "//www.wangdaiqianyan.com/");
        sourceCode.put("wdtianxia", "//www.wdtianxia.com/");
        sourceCode.put("wangdaitiandi", "//www.wangdaitiandi.com/");
        sourceCode.put("wangdaibaike", "//www.wangdaibaike.com/");
        // 2015-03-18 wlj 新增
        sourceCode.put("wangdaiclub", "//www.wangdaiclub.com/");
        sourceCode.put("wdjhu", "//www.wdjhu.com/");
        sourceCode.put("wangdai", "//www.wangdai.info/");
        sourceCode.put("wdtianhe", "//www.wdtianhe.com/");
        sourceCode.put("wangdai001", "//www.wangdai001.com/");
        sourceCode.put("p2p110", "//hao.p2p110.com/");
        sourceCode.put("wddby", "//www.wddby.com/");
        sourceCode.put("jlsj888", "//www.jlsj888.cn/");
        sourceCode.put("hexun", "//www.hexun.com/");
        sourceCode.put("stockstar", "//money.stockstar.com/");
        sourceCode.put("csai", "//www.csai.cn/");
        sourceCode.put("xunjinhui", "//www.xunjinhui.com/");
    }

    public static CodesFactory getInstance() {
        if (instance == null) {
            instance = new CodesFactory();
        }
        return instance;
    }

    public Code getCode(String code) {
        return codes.getCode(code);
    }

    public HashMap getSourceCode() {
        return sourceCode;
    }

}
