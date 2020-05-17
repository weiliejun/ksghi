package com.itech.ups.base.application.domain;

import com.alibaba.fastjson.JSONObject;
import com.itech.ups.base.constant.BusinessConstant;
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
        // 关注通知模板id
        urlMap.put(BusinessConstant.ATTENTION_NOTIFY, "https://m.ksghi.com/");
        templateIdMap.put(MessageConstant.ATTENTION_NOTIFY, "CIW5KkHL2uyD54qZJcVr8tQ-M2mQX5te_WtBSbp6AOU");
        // 充值通知模板id
        urlMap.put(BusinessConstant.DRAWING_CASH, "https://m.ksghi.com/");
        templateIdMap.put(MessageConstant.DRAWING_CASH, "KtKXLL6O1O7Q1V5DXlbsKTZqJigRwQhY2DwyKY2OUYc");
        // 投标通知模板id
        urlMap.put(BusinessConstant.INVESTMENT, "https://m.ksghi.com/");
        templateIdMap.put(MessageConstant.INVESTMENT, "kJSeSs-502SU5LIUuTOoXhMmefu1a15N2HBOkOHZt8I");
        // 提现通知模板id
        urlMap.put(BusinessConstant.WITHDRAWING_CASH, "https://m.ksghi.com/");
        templateIdMap.put(MessageConstant.WITHDRAWING_CASH, "7eyH_4rI2pXKXWLUbUP7740MV2xNItZeAxv11GNLuhI");
		
	/*	// 关注通知模板id
		urlMap.put(BusinessConstant.ATTENTION_NOTIFY, "https://m.ksghi.com/");
		templateIdMap.put(MessageConstant.ATTENTION_NOTIFY, "CIW5KkHL2uyD54qZJcVr8tQ-M2mQX5te_WtBSbp6AOU");
		// 充值通知模板id
		urlMap.put(BusinessConstant.DRAWING_CASH, "https://m.ksghi.com/");
		templateIdMap.put(MessageConstant.DRAWING_CASH, "KtKXLL6O1O7Q1V5DXlbsKTZqJigRwQhY2DwyKY2OUYc");
		// 投标通知模板id
		urlMap.put(BusinessConstant.INVESTMENT, "https://m.ksghi.com/");
		templateIdMap.put(MessageConstant.INVESTMENT, "kJSeSs-502SU5LIUuTOoXhMmefu1a15N2HBOkOHZt8I");
		// 提现通知模板id
		urlMap.put(BusinessConstant.WITHDRAWING_CASH, "https://m.ksghi.com/");
		templateIdMap.put(MessageConstant.WITHDRAWING_CASH, "7eyH_4rI2pXKXWLUbUP7740MV2xNItZeAxv11GNLuhI");*/
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
