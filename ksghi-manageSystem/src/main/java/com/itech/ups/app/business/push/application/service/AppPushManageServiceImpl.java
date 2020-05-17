package com.itech.ups.app.business.push.application.service;

import com.itech.ups.app.apppushmanage.application.domain.AppPushManage;
import com.itech.ups.app.business.push.application.infrastructure.AppPushManageRepository;
import com.itech.ups.app.components.message.exception.ParameterNullPointerException;
import com.tencent.xinge.*;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Sender;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AppPushManageService")
public class AppPushManageServiceImpl implements AppPushManageService {
    // 信鸽对象(测试)
    // private static final XingeApp xinge = new XingeApp(2100244708,
    // "5cacadf6b8c0d4089ae00e6f4d074f57");
    // 包名
    private static final String PACKAGE_NAME = "com.ksghi";

    @Value("${xg.appId}")
    private long xgAppId;

    @Value("${xg.appSecret}")
    private String xgAppSecret;

    @Value("${mi.appSecret}")
    private String miAppSecret;

    @Resource
    private AppPushManageRepository appPushManageRepository;

    @Override
    public AppPushManage addAppPushManage(AppPushManage appPushManage) {
        return appPushManageRepository.addAppPushManage(appPushManage);
    }

    @Override
    public void deleteAppPushManageById(String id) {
        appPushManageRepository.deleteAppPushManageById(id);
    }

    @Override
    public List<AppPushManage> findAppPushManage(Map<String, Object> params, int rowStart, int rowEnd) {
        return appPushManageRepository.findAppPushManage(params, rowStart, rowEnd);
    }

    @Override
    public AppPushManage findAppPushManageById(String id) {
        AppPushManage appPushManage = appPushManageRepository.findAppPushManageById(id);
        return appPushManage;

    }

    @Override
    public int findAppPushManageCount(Map<String, Object> params) {
        return appPushManageRepository.findAppPushManageCount(params);
    }

    @Override
    public void updateAppPushManage(AppPushManage appPushManage) {
        appPushManageRepository.updateAppPushManage(appPushManage);
    }

    @Override
    public void updateStatusById(AppPushManage appPushManage) {
        appPushManageRepository.updateStatusById(appPushManage);

    }

    @Override
    public Map<String, ?> pushAllDeviceByXG(AppPushManage appPushManage) {
        Message message = new Message();
        message.setTitle(appPushManage.getMessageName());
        message.setContent(appPushManage.getContent());
        // message.setExpireTime(3600*24);//消息离线存储多久，单位为秒，最长存储时间 3 天。选填，默认为
        // 3天，设置为 0 等同于使用默认值
        // message.setSendTime("");//消息定时推送的时间，格式为 year-mon-day
        // hour:min:sec，若小于服务器当前时间则立即推送。选填，默认为空字符串，代表立即推送
        TimeInterval acceptTime1 = new TimeInterval(0, 0, 23, 59);
        message.addAcceptTime(acceptTime1);
        message.setType(Message.TYPE_NOTIFICATION);// 消息类型。TYPE_NOTIFICATION:
        // 通知； TYPE_MESSAGE:
        // 透传消息。必填注意： TYPE_MESSAGE
        // 类型消息 默认在终端是不展示的，不会弹出通知
        message.setMultiPkg(0);// 0 表示按注册时提供的包名分发消息；1 表示按 access id 分发消息，所有以该
        // access id 成功注册推送的 app 均可收到消息。选填，默认为 0
        Style style = new Style(3, 1, 1, 1, 0);
        message.setStyle(style);// 通知样式，透传消息可不填
        ClickAction action = new ClickAction();
        String openType = appPushManage.getOpenType();
        if ("1".equals(openType)) {
            action.setActionType(ClickAction.TYPE_ACTIVITY);
            action.setActivity("com.ksghi.act.MainActivity");
        } else if ("2".equals(openType)) {
            action.setActionType(ClickAction.TYPE_ACTIVITY);
            action.setActivity("com.ksghi.act.ProductDetailsActivity");
        } else if ("3".equals(openType)) {
            action.setActionType(ClickAction.TYPE_ACTIVITY);
            action.setActivity("com.ksghi.act.WebActivity");
        } else {

        }
        // action.setUrl(appPushManage.getUrl());
        // action.setConfirmOnUrl(0);//打开 url 时是否需要用户确认，1 需要，0 不需要，默认为 0。
        // actionType 为 TYPE_URL 时生效
        // action.setActivity("");
        // action.setAtyAttrIntentFlag(1);
        // action.setAtyAttrPendingIntentFlag(1);
        // action.setIntent("intent:#Intent;component=com.ksghi/.act.ChangePasswordActivity;end");
        message.setAction(action);

        Map<String, Object> custom = new HashMap<String, Object>();
        custom.put("open_type", appPushManage.getOpenType());
        custom.put("url", appPushManage.getUrl());
        message.setCustom(custom);
        // message.setLoopTimes(1);
        // message.setLoopInterval(3);
        XingeApp xinge = new XingeApp(xgAppId, xgAppSecret);
        JSONObject ret = xinge.pushAllDevice(0, message);
        return null;
    }

    @Override
    public Map<String, ?> pushAllDeviceByXM(AppPushManage appPushManage) {
        if (appPushManage == null) {
            throw new ParameterNullPointerException("App推送消息是参数appPushManage为空");
        }
        Sender sender = new Sender(miAppSecret);
        String messagePayload = "";
        String openType = appPushManage.getOpenType();
        String url = appPushManage.getUrl();

        String title = appPushManage.getMessageName();
        String description = appPushManage.getContent();
        com.xiaomi.xmpush.server.Message message = null;
        if ("1".equals(openType)) {
            message = new com.xiaomi.xmpush.server.Message.Builder().title(title).description(description).payload(messagePayload)//
                    .passThrough(0)// 设置消息是否通过透传的方式送给app，1表示透传消息，0表示通知栏消息
                    .restrictedPackageName(PACKAGE_NAME).notifyType(-1).extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_LAUNCHER_ACTIVITY).build();
        } else if ("2".equals(openType)) {
            message = new com.xiaomi.xmpush.server.Message.Builder().title(title).description(description).payload(messagePayload)//
                    .passThrough(0)// 设置消息是否通过透传的方式送给app，1表示透传消息，0表示通知栏消息
                    .restrictedPackageName(PACKAGE_NAME).notifyType(-1).extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_ACTIVITY).extra(Constants.EXTRA_PARAM_INTENT_URI, "intent:#Intent;component=com.ksghi/.act.ProductDetailsActivity;end").extra("url", url).build();
        } else if ("3".equals(openType)) {
            message = new com.xiaomi.xmpush.server.Message.Builder().title(title).description(description).payload(messagePayload)//
                    .passThrough(0)// 设置消息是否通过透传的方式送给app，1表示透传消息，0表示通知栏消息
                    .restrictedPackageName(PACKAGE_NAME).notifyType(-1).extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_ACTIVITY).extra(Constants.EXTRA_PARAM_INTENT_URI, "intent:#Intent;component=com.ksghi/.act.WebActivity;end").extra("url", url).build();
        } else {

        }
        try {
            sender.broadcastAll(message, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } // 向所用设备发送消息，不重试。
        return null;
    }
}