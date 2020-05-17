package com.itech.ups.app.business.push.action;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.apppushmanage.application.domain.AppPushManage;
import com.itech.ups.app.business.push.application.service.AppPushManageService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class AppPushManageController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(AppPushManageController.class);
    /*
     * 百度云推送应用信息
     */
    // android测试环境配置
    @Value("${androidapiKey}")
    private String androidapiKey;
    @Value("${androidsecretKey}")
    private String androidsecretKey;
    @Value("${IOSapiKey}")
    private String IOSapiKey;
    @Value("${IOSsecretKey}")
    private String IOSsecretKey;
    @Value("${pushDepolyStatus}")
    private int pushDepolyStatus;
    @Autowired
    private AppPushManageService service;

    @RequestMapping(value = {"/appPushManage/add"}, method = RequestMethod.POST, produces = "application/json")
    public String addAppPushManage(HttpServletRequest request, @RequestParam(value = "id", required = false) String id, @RequestParam(value = "messageName", required = true) String messageName, @RequestParam(value = "type", required = true) String type, @RequestParam(value = "content", required = true) String content, @RequestParam(value = "isAutoPush", required = true) String isAutoPush, @RequestParam(value = "pushTime", required = true) String pushTime, @RequestParam(value = "apptype", required = true) String apptype, @RequestParam(value = "url", required = true) String url, @RequestParam(value = "openType", required = true) String openType) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        try {
            AppPushManage appPushManage = new AppPushManage();
            if (id != null && !id.equals("")) {
                appPushManage.setId(id);
                appPushManage.setMessageName(messageName);
                appPushManage.setType(type);
                appPushManage.setContent(content);
                appPushManage.setIsAutoPush(isAutoPush);
                if (isAutoPush.equalsIgnoreCase("true")) {
                    appPushManage.setPushTime(pushTime);
                } else {
                    appPushManage.setPushTime("");
                }
                appPushManage.setCreateId(currentManager.getManager().getId());
                appPushManage.setCreateName(currentManager.getManager().getName());
                appPushManage.setApptype(apptype);
                appPushManage.setUrl(url);
                appPushManage.setOpenType(openType);

                service.updateAppPushManage(appPushManage);
            } else {
                appPushManage.setMessageName(messageName);
                appPushManage.setType(type);
                appPushManage.setContent(content);
                appPushManage.setIsAutoPush(isAutoPush);
                appPushManage.setApptype(apptype);
                appPushManage.setCreateId(currentManager.getManager().getId());
                appPushManage.setCreateName(currentManager.getManager().getName());
                appPushManage.setPushType("unpush");
                appPushManage.setStatus("push");
                appPushManage.setDataStatus("valid");
                appPushManage.setRemark("向" + apptype + "端推送");
                appPushManage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
                appPushManage.setUrl(url);
                appPushManage.setOpenType(openType);
                if (isAutoPush.equals("true")) {
                    appPushManage.setPushTime(pushTime);
                    pushTime += ":00";
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = format.parse(pushTime);
                    long pushtimeId = date.getTime();
                    pushtimeId = pushtimeId / 1000 + 70;
                    if (apptype.trim().equals("ios")) {
                        IOSPushNotificationToAll(appPushManage, pushtimeId);
                    } else if (apptype.trim().equals("android")) {
                        AndroidPushMsgToAll(appPushManage, pushtimeId);
                    } else {
                        IOSPushNotificationToAll(appPushManage, pushtimeId);
                        AndroidPushMsgToAll(appPushManage, pushtimeId);
                    }
                    appPushManage.setPushType("pushed");
                    appPushManage = service.addAppPushManage(appPushManage);
                } else {
                    appPushManage.setStatus("unpush");
                    appPushManage = service.addAppPushManage(appPushManage);
                }
            }
        } catch (Exception e) {
            logger.error("upload file error! ", e);
            ;
            e.printStackTrace();
        }
        return "redirect:/appPushManage/query";
    }

    public void AndroidPushMsgToAll(AppPushManage appPushManage, long timeId) {

        PushKeyPair pair = new PushKeyPair(androidapiKey, androidsecretKey);

        BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

        pushClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                logger.info(event.getMessage());
            }
        });
        // 创建 Android的通知
        JSONObject jsonAPS = new JSONObject();
        jsonAPS.put("description", appPushManage.getContent());
        jsonAPS.put("notification_builder_id", "0");
        jsonAPS.put("type", appPushManage.getType());
        JSONObject customContent = new JSONObject();
        customContent.put("open_type", appPushManage.getOpenType());
        customContent.put("url", appPushManage.getUrl());
        jsonAPS.put("custom_content", customContent.toString());

        try {
            // 4. specify request arguments
            PushMsgToAllRequest request = new PushMsgToAllRequest().addMsgExpires(new Integer(3600)).addMessageType(1).addMessage(jsonAPS.toString()).addSendTime(timeId) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
                    .addDeviceType(3);
            // 5. http request
            PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
            // Http请求结果解析打印
            logger.info("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime() + ",timerId: " + response.getTimerId());
        } catch (PushClientException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                try {
                    throw e;
                } catch (PushClientException e1) {
                    e1.printStackTrace();
                }
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                try {
                    throw e;
                } catch (PushServerException e1) {
                    e1.printStackTrace();
                }
            } else {
                logger.info(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
    }

    @RequestMapping(value = {"/appPushManage/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteAppPushManageById(@RequestParam("id") String id) {
        try {
            service.deleteAppPushManageById(id);
        } catch (Exception e) {
            logger.error("/appPushManage/delete! id:" + id, e);
        }
        return "redirect:/appPushManage/query";
    }

    @RequestMapping(value = {"/appPushManage/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findAppPushManageById(Model model, @RequestParam(value = "id", required = false) String id) {
        AppPushManage appPushManage = null;
        if (id != null) {
            appPushManage = service.findAppPushManageById(id);
        }
        model.addAttribute("appPushManage", appPushManage);
        model.addAttribute("pushTime", DateHelper.getYMDHMFormatDate(new Date()));
        return "manage/appPushManage/add";
    }

    public void IOSPushNotificationToAll(AppPushManage appPushManage, long timeId) {

        PushKeyPair pair = new PushKeyPair(IOSapiKey, IOSsecretKey);

        BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

        pushClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                logger.info(event.getMessage());
            }
        });

        try {
            // 4. specify request arguments
            // 创建IOS通知
            JSONObject notification = new JSONObject();
            JSONObject jsonAPS = new JSONObject();
            jsonAPS.put("alert", appPushManage.getContent());
            // jsonAPS.put("sound", "ttt"); // 设置通知铃声样式,例如"ttt"，用户自定义。
            notification.put("aps", jsonAPS);
            notification.put("type", appPushManage.getType());
            notification.put("url", appPushManage.getUrl());
            notification.put("open_type", appPushManage.getOpenType());

            PushMsgToAllRequest request = new PushMsgToAllRequest().addMsgExpires(new Integer(3600)).addMessageType(1).addMessage(notification.toString()).addSendTime(timeId) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
                    .addDepolyStatus(pushDepolyStatus) // 开发环境 IOS,//
                    // DeployStatus// => 1:
                    // Developer// 2:
                    // Production.
                    .addDeviceType(4);
            // 5. http request
            PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
            // Http请求结果解析打印
            logger.info("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime() + ",timerId: " + response.getTimerId());
        } catch (PushClientException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                try {
                    throw e;
                } catch (PushClientException e1) {
                    e1.printStackTrace();
                }
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                try {
                    throw e;
                } catch (PushServerException e1) {
                    e1.printStackTrace();
                }
            } else {
                logger.info(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
    }

    @RequestMapping(value = {"/appPushManage/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryVersionList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findAppPushManage(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findAppPushManageCount(params);
                }
            });

            model.addAttribute("results", items);
        } else {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    return new ArrayList<Object>();
                }

                public int getTotalRows(Limit limit) {
                    return (int) 0;
                }
            });

            model.addAttribute("results", items);
        }

        // 保存翻页信息,保存查询条件，回显参数
        savePageParams(request, params, model);
        // ////

        /*
         * final String startTime; final String endTime; if
         * (StringUtils.isNotBlank(dateRange)) { startTime =
         * dateRange.substring(0, 10); endTime = dateRange.substring(13, 23); }
         * else { startTime = ""; endTime = ""; }
         *
         * Collection<?> items = TableModelUtils.getItems("grid", "restore",
         * request, new PageItems() { public int getTotalRows(Limit limit) {
         * return service.findAppPushManageCount(messageName, type, pushType,
         * startTime, endTime); } public Collection<?> getItems(Limit limit) {
         * return service.findAppPushManage(messageName, type, pushType,
         * startTime, endTime, limit.getRowSelect().getRowStart(),
         * limit.getRowSelect().getRowEnd()); } });
         *
         * model.addAttribute("results", items);
         * model.addAttribute("messageName", messageName);
         * model.addAttribute("type", type); model.addAttribute("pushType",
         * pushType); model.addAttribute("dateRange", dateRange);
         */
        return "manage/appPushManage/list";
    }

    @RequestMapping(value = {"/appPushManage/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        AppPushManage apppushmanage = service.findAppPushManageById(id);

        String dataStatus = apppushmanage.getDataStatus();
        String pushstatus = apppushmanage.getStatus();
        String apptype = apppushmanage.getApptype();
        long pushtimeId = System.currentTimeMillis() / 1000 + 200;
        if (apppushmanage != null) {
            if (dataStatus.trim().equals("valid") && pushstatus.trim().equals("unpush")) {
                // apptype推送终端 ios/android/androidOrios
                if (apptype.trim().contains("ios")) {
                    IOSPushNotificationToAll(apppushmanage, pushtimeId);
                }
                if (apptype.trim().contains("android")) {
                    AndroidPushMsgToAll(apppushmanage, pushtimeId);
                    service.pushAllDeviceByXG(apppushmanage);// 信鸽推送
                    service.pushAllDeviceByXM(apppushmanage);// 小米推送
                }
                // 更新推送消息状态
                AppPushManage appPushManage = new AppPushManage();
                appPushManage.setId(id);
                appPushManage.setStatus(status);
                appPushManage.setPushType("pushed");
                if (status.equals("push")) {
                    appPushManage.setPushTime(DateHelper.getYMDHMSFormatDate(new Date()));
                }
                service.updateAppPushManage(appPushManage);
            }
        }

        return "redirect:/appPushManage/query";
    }

}
