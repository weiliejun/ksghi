package com.itech.core.util;

import com.itech.ups.base.application.domain.CurrentManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CallPhoneHelper {

    public static String getCallPhoneUrl(CurrentManager currentManager, String phoneNum) {
        String cno_pwd = CallPhoneHelper.getProperties().getProperty(currentManager.getManager().getCode());
        String reqUrl = "http://api.clink.cn/interface/PreviewOutcall?enterpriseId=3001162";
        reqUrl += cno_pwd;
        reqUrl += "&customerNumber=" + phoneNum;

        return reqUrl;
    }

    public static Properties getProperties() {
        Properties prop = new Properties();
        InputStream is = CallPhoneHelper.class.getResourceAsStream("/config/customerServiceStaff.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
