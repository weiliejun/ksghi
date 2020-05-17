package com.itech.core.util;

import com.itech.ups.base.web.taglibs.code.Code;
import com.itech.ups.base.web.taglibs.code.CodesFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CodeHelper {
    private static Logger logger = Logger.getLogger(CodeHelper.class);

    public static String getValueByCode(String code, String key) {
        Code element = CodesFactory.getInstance().getCode(code);
        String label = "";
        String[] keys = key.split(",");
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && !keys[i].equals("")) {
                label += element.getItems().get(keys[i]);
                label += ",";
            }
        }

        if (StringUtils.isBlank(label)) {
            label = (key == null) ? "" : key;// label="";
        } else {
            label = label.substring(0, label.length() - 1);
        }
        return label;
    }

    /**
     * 名称转换成code值
     *
     * @param code
     * @param label
     * @return
     */
    public static String getCodeByValue(String code, String label) {
        Code element = CodesFactory.getInstance().getCode(code);
        Map<String, String> items = element.getItems();
        String returnStr = "";

        if (items != null && items.size() > 0 && !StringHelper.isBlank(label)) {
            Iterator<java.util.Map.Entry<String, String>> it = items.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
                String key = entry.getKey();
                String val = entry.getValue();
                if (label.equals(val)) {
                    returnStr = key;
                    break;
                }
            }
        }
        return returnStr;
    }

    /**
     * 名称转换成codes值
     *
     * @param codes
     * @param labels
     * @return
     */
    public static String getCodesByValues(String code, String labels) {
        String codes = "";
        if (!StringHelper.isBlank(labels)) {
            String[] labelArr = labels.split(",");
            for (String s : labelArr) {
                codes += getCodeByValue(code, s) + ",";
            }
        }
        return codes.length() > 0 ? codes.substring(0, codes.length() - 1) : codes;
    }

    public static String getValueByKey(String key) {
        HashMap element = CodesFactory.getInstance().getSourceCode();
        String label = element.get(key) == null ? "" : element.get(key).toString();
        return label;
    }

    /**
     * @Title: encodeString @Description: TODO(对字符串进行编码转换，转换成自己输入的编码格式) @param
     * str @param entype @return String 返回类型 create_time
     * 2015-4-3 @throws
     */
    public static String encodeString(String str, EncodeType entype) {

        try {
            if (str != null && !str.equals(""))
                return URLEncoder.encode(str, entype.toString());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @Title: decodeString @Description:
     * TODO(字符串解码，解码为自己传入的格式)，适用于接受js端使用URLENCODE转码的字符 @param str @param
     * entype @return String 返回类型 @create_time 2015-4-3 @throws
     */
    public static String decodeString(String str, EncodeType entype) {
        try {
            if (str != null && !str.equals(""))
                return URLDecoder.decode(str, entype.toString());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public static Map<String, String> getAllValueByCode(String code) {
        Code element = CodesFactory.getInstance().getCode(code);
        Map<String, String> result = element.getItems();
        return result;
    }

    public static void main(String[] args) {
        logger.info(getCodesByValues("product.riskRank", "低风险,中低风险"));
        // logger.info(Integer.valueOf("11"));
        logger.info(Integer.valueOf(null));

    }
}
