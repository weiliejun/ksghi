package com.itech.ups.base.components.domain;

import com.alibaba.fastjson.JSONObject;
import com.itech.ups.base.constant.MessageConstant;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author 张可乐
 * @version 1.0
 * @description 微信模板消息模型
 * @update 2017-1-16 下午4:28:05
 */
public class TemplateMessage {
    // 标题颜色
    public static final String TOPCOLOR = "#FF0000";
    // 关键词颜色
    public static final String COLOR = "#173177";
    // 详情urlMap
    public static final Map<String, String> urlMap = new HashMap<String, String>();
    // 模板消息templateIdMap
    public static final Map<String, String> templateIdMap = new HashMap<String, String>();

    static {
        // 满标放款通知模板id
        urlMap.put(MessageConstant.LOAN_SUCCESS, "");
        templateIdMap.put(MessageConstant.LOAN_SUCCESS, "WLJyLpwMWFkBbP7UN1FAshnrjsQU6El_q3DD31zlA1A");
        // 项目流标通知模板id
        urlMap.put(MessageConstant.LEAVE_TENDER, "");
        templateIdMap.put(MessageConstant.LEAVE_TENDER, "dTRDAeV592k6JDeHP1CdYa2eCxhOhIo-YIO5-eI23no");
        //提前回款到账通知模板id
        urlMap.put(MessageConstant.RECEIVABLE_ACCOUNT, "");
        templateIdMap.put(MessageConstant.RECEIVABLE_ACCOUNT, "I1AYKmaMgYufuIHw5Ha7qQPrMWql56YMdg4hC1657GY");
        //正常回款到账通知模板id
        urlMap.put(MessageConstant.RECEIVABLE_ACCOUNT_NORMAL, "");
        templateIdMap.put(MessageConstant.RECEIVABLE_ACCOUNT_NORMAL, "I1AYKmaMgYufuIHw5Ha7qQPrMWql56YMdg4hC1657GY");
        //新标发布通知模板的id
        urlMap.put(MessageConstant.NEW_TENDER, "");
        templateIdMap.put(MessageConstant.NEW_TENDER, "tkOnAxEicmDw9BR8yONxBO8XG4bQ6h1Ruj0X3UaGFKA");
    }

    // 用户openId
    private String touser;
    // 模板数据
    private Map<String, String> data;
    // 通知类型
    private String notifyType;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    /**
     * @return
     * @description 对象转换成模板消息json字符串
     * @version 1.0
     * @author 张可乐
     * @update 2017-1-16 下午4:37:45
     */
    public String toJsonString() {
        JSONObject json = new JSONObject();
        json.put("touser", getTouser());
        json.put("template_id", templateIdMap.get(getNotifyType()));
        json.put("url", urlMap.get(getNotifyType()));
        json.put("topcolor", TOPCOLOR);
        JSONObject dataJson = new JSONObject();
        Map<String, String> dataMap = getData();
        for (Entry<String, String> entry : dataMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JSONObject jsonTemp = new JSONObject();
            jsonTemp.put("value", value);
            jsonTemp.put("color", COLOR);
            dataJson.put(key, jsonTemp);
        }
        json.put("data", dataJson);
        return json.toJSONString();
    }
}
