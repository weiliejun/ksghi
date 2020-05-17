package com.itech.ups.app.components.message;

import com.alibaba.fastjson.JSON;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.components.message.exception.ParameterNullPointerException;
import com.itech.ups.app.components.message.exception.TemplateInexistenceException;
import com.itech.ups.app.components.message.infrastructure.MessageRepository;
import com.itech.ups.app.components.message.mail.MailEntity;
import com.itech.ups.app.components.message.mail.MailSenderService;
import com.itech.ups.app.components.message.sms.SmsClient;
import com.itech.ups.app.components.message.wechat.WechatClient;
import com.itech.ups.app.user.application.domain.User;
import com.itech.ups.app.user.application.domain.UserMessage;
import com.itech.ups.app.user.application.domain.UserMessageSet;
import com.itech.ups.base.application.domain.TemplateMessage;
import com.itech.ups.base.application.service.AbstractServiceParent;
import com.itech.ups.base.constant.BusinessConstant;
import com.itech.ups.base.constant.MessageConstant;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-4-13
 * @author  zqs
 * ===========================================================================
 *
 */
@Service("messageSender")
public class MessageSender extends AbstractServiceParent {
    private static final Log logger = LogFactory.getLog(MessageSender.class);

    @Autowired
    private WechatClient wechatClient;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SmsClient smsClient;

    @Autowired
    private MailSenderService mailSenderService;

    private static String[] getTmplVariable(String context) {

        String[] variables = StringUtils.substringsBetween(context, "${", "}");

        return variables;
    }

    private static Map<String, String> tmplAssignment(String busiType, String type, Map<String, String> values) throws ParameterNullPointerException, TemplateInexistenceException {

        Map<String, String> result = new HashMap<String, String>();

        Map<String, String> tmplResult = MessageTemplateParse.getTmpl(busiType, type);

        Set<String> keys = tmplResult.keySet();
        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            result.put(key, tmplResult.get(key));
        }

        if (MapUtils.isNotEmpty(result)) {
            if (type.equalsIgnoreCase("email") || type.equalsIgnoreCase("website")) {
                String title = result.get("title");
                if (StringUtils.isBlank(title)) {
                    return result;
                    // throw new TemplateInexistenceException("未定义title模板内容！");
                }
                String[] variablesTitle = getTmplVariable(title);
                if (!ArrayUtils.isEmpty(variablesTitle)) {
                    for (String variable : variablesTitle) {

                        String val = values.get(variable);
                        if (StringUtils.isEmpty(val)) {
                            return result;
                            // throw new
                            // ParameterNullPointerException(variable);
                        }
                        title = title.replace("${" + variable + "}", val);
                    }
                    result.put("title", title);
                }
            }

            String content = result.get("content");
            if (StringUtils.isBlank(content)) {
                return result;
                // throw new TemplateInexistenceException("未定义content模板内容！");
            }
            String[] variables = getTmplVariable(content);
            if (!ArrayUtils.isEmpty(variables)) {
                for (String variable : variables) {

                    String val = values.get(variable);
                    if (StringUtils.isEmpty(val)) {
                        return result;
                        // throw new ParameterNullPointerException(variable);
                    }
                    content = content.replace("${" + variable + "}", val);
                }
                result.put("content", content);
            }
        }

        return result;
    }

    /**
     * @return
     * @description 获取微信模板消息对象
     * @version 1.0
     * @author 张可乐
     * @update 2017-10-27 下午3:44:12
     */
    private static TemplateMessage getTemplateMessage(String busiType, String wxOpenId, Map<String, String> params) {
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTouser(wxOpenId);
        templateMessage.setNotifyType(busiType);
        Map<String, String> wechatData = new HashMap<String, String>();
        if (MessageConstant.LOAN_SUCCESS.equals(busiType)) {// 微信满标放款通知
            wechatData.put("first", params.get(""));// 标题
            wechatData.put("keyword2", params.get("amount") + "元");// 投标金额
            wechatData.put("keyword3", params.get("time"));// 放款时间
            wechatData.put("keyword1", params.get("name"));// 产品名称
        } else if (MessageConstant.LEAVE_TENDER.equals(busiType)) {// 微信项目流标通知
            wechatData.put("first", MessageConstant.DRAWING_CASH_FIRST);// 标题
            wechatData.put("keyword2", params.get("productName"));// 出借项目
            wechatData.put("keyword1", params.get("date"));// 出借时间
            wechatData.put("keyword3", params.get("amount") + "元");// 出借金额
        } else if (MessageConstant.RECEIVABLE_ACCOUNT_NORMAL.equals(busiType)) {// 微信正常回款到账提醒通知
            wechatData.put("first", MessageConstant.RECEIVABLE_ACCOUNT_NORMAL_FIRST);// 标题
            wechatData.put("keyword2", params.get("productName"));//
            wechatData.put("keyword1", params.get("amount") + "元");//
            wechatData.put("keyword3", params.get("time"));//
        } else if (MessageConstant.RECEIVABLE_ACCOUNT.equals(busiType)) {// 微信提前回款到帐通知
            wechatData.put("first", MessageConstant.OPEN_ACCOUNT_FIRST);// 标题
            wechatData.put("keyword1", params.get("productName"));// 汇款项目
            wechatData.put("keyword2", params.get("amount") + "元");// 回款金额
            wechatData.put("keyword3", params.get("time"));// 回款时间
        } else if (MessageConstant.NEW_TENDER.equals(busiType)) {// 新标上线通知
            wechatData.put("first", "尊敬的用户，新标上线啦，" + params.get("tenderStartTime") + "准时开标。");// 标题
            wechatData.put("keyword1", params.get("name"));// 项目名称
            wechatData.put("keyword2", params.get("annualRate") + "%");// 年化收益率
            wechatData.put("timeLimit", params.get("time"));// 项目期限
            wechatData.put("keyword4", params.get("repayTypeStr"));// 还款方式
        }
        wechatData.put("remark", BusinessConstant.REMARK);
        templateMessage.setData(wechatData);
        return templateMessage;
    }

    /**
     * @param userInfoId
     * @param busiType
     * @param wxOpenId
     * @param params
     * @return
     * @throws ParameterNullPointerException
     * @throws TemplateInexistenceException
     * @description 发送微信消息
     * @version 1.0
     * @author 张可乐
     * @update 2017-10-27 下午3:54:13
     */
    public boolean wechatMessageSend(String userInfoId, String busiType, String wxOpenId, Map<String, String> params) throws ParameterNullPointerException {
        boolean result = false;
        String type = MessageType.wechat.toString();
        TemplateMessage templateMessage = null;
        if (StringUtils.isBlank(wxOpenId)) {
            throw new ParameterNullPointerException("wxOpenId");
        }
        try {
            templateMessage = getTemplateMessage(busiType, wxOpenId, params);
            result = wechatClient.sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        if (result) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserInfoId(userInfoId);
            userMessage.setBusiType(busiType);
            userMessage.setType(type);
            userMessage.setContent(JSON.toJSONString(templateMessage));
            userMessage.setStatus("unread");
            userMessage.setReceiveAddress(wxOpenId);
            userMessage.setDataStatus("valid");
            userMessage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));

            // 业务私有域数据
            String busiPriv = params.get("busiPriv");
            userMessage.setBusiPriv(busiPriv);
            result = messageRepository.addUserMessage(userMessage);
        }
        return result;
    }

    public boolean busiMessageSend(String userInfoId, String busiType, Map<String, String> params) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;

        if (StringUtils.isBlank(userInfoId)) {
            return result;
            // throw new ParameterNullPointerException("userInfoId");
        }

        UserMessageSet userMessageSet = messageRepository.findUserMessageSetByUserInfoId(userInfoId, busiType);
        if (null != userMessageSet) {
            User user = messageRepository.findUserById(userInfoId);
            if (null != user) {
                String smsStatus = userMessageSet.getSmsStatus();
                String emailStatus = userMessageSet.getEmailStatus();
                String websiteStatus = userMessageSet.getWebsiteStatus();
                String wechatStatus = userMessageSet.getWechatStatus();// 微信
                String wxOpenId = user.getWxopenid();
                if (StringUtils.isNotBlank(smsStatus)) {
                    if (smsStatus.equals("valid")) {
                        String mobile = user.getMobile();
                        if (StringUtils.isNotBlank(mobile)) {
                            result = mobileMessageSend(userInfoId, busiType, mobile, params);
                        }
                    }
                }
                if (StringUtils.isNotBlank(emailStatus)) {
                    if (emailStatus.equals("valid")) {
                        String email = user.getEmail();
                        if (StringUtils.isNotBlank(email)) {
                            result = emailMessageSend(userInfoId, busiType, email, params);
                        }
                    }
                }
                if (StringUtils.isNotBlank(websiteStatus)) {
                    if (websiteStatus.equals("valid")) {
                        result = webSiteMessageSend(userInfoId, busiType, params);
                    }
                }
                // 设置发送微信消息且已绑定微信
                if (StringUtils.isNotBlank(wechatStatus) && StringUtils.isNotBlank(wxOpenId)) {
                    if (wechatStatus.equals("valid")) {
                        result = wechatMessageSend(userInfoId, busiType, wxOpenId, params);
                    }
                }
            }
        }

        return result;
    }

    public boolean emailMessageSend(String userInfoId, String busiType, String to, Map<String, String> params) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;
        String type = MessageType.email.toString();

        MailEntity mailEntity = new MailEntity();

        if (StringUtils.isBlank(to)) {
            return result;
            // throw new ParameterNullPointerException("to");
        }
        mailEntity.setTo(to);

        Map<String, String> tmpl = tmplAssignment(busiType, type, params);

        String title = tmpl.get("title");
        if (StringUtils.isBlank(title)) {
            return result;
            // throw new TemplateInexistenceException("未定义title模板内容！");
        }
        mailEntity.setSubject(title);

        String content = tmpl.get("content");
        if (StringUtils.isBlank(content)) {
            return result;
        }
        mailEntity.setText(content);
        try {
            mailSenderService.sendMailWithPureText(mailEntity);
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        if (result) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserInfoId(userInfoId);
            userMessage.setBusiType(busiType);
            userMessage.setType(type);
            userMessage.setTopic(title);
            userMessage.setContent(content);
            userMessage.setStatus("unread");
            userMessage.setReceiveAddress(to);
            userMessage.setDataStatus("valid");
            userMessage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));

            // 业务私有域数据
            String busiPriv = params.get("busiPriv");
            userMessage.setBusiPriv(busiPriv);

            result = messageRepository.addUserMessage(userMessage);
        }

        return result;
    }

    public boolean emailMessageSend(String[] tos, String subject, String content) throws ParameterNullPointerException {
        boolean result = false;

        if (ArrayUtils.isEmpty(tos)) {
            return result;
            // throw new ParameterNullPointerException("tos");
        }

        for (int i = 0; i < tos.length; i++) {
            String to = tos[i];
            if (StringUtils.isNotBlank(to)) {
                MailEntity mailEntity = new MailEntity();
                mailEntity.setTo(to);
                mailEntity.setSubject(subject);
                mailEntity.setText(content);
                try {
                    mailSenderService.sendMailWithPureText(mailEntity);
                    result = result & result;
                } catch (Exception e) {
                    result = false;
                    result = result & result;
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * @param busiType
     * @param tos
     * @param params   邮件模板里面需要的参数
     * @param filePath 多文件是文件路径之间以“,”分隔
     * @return
     * @throws ParameterNullPointerException
     * @description 发送带附件的邮件
     * @version 1.0
     * @author 徐赛平
     * @update 2018年2月9日 下午3:50:15
     */
    public boolean emailMimeMessageSend(String busiType, String[] tos, Map<String, String> params, String filePath) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;
        String type = MessageType.email.toString();

        if (ArrayUtils.isEmpty(tos)) {
            return result;
        }

        for (int i = 0; i < tos.length; i++) {
            String to = tos[i];
            if (StringUtils.isBlank(to)) {
                return result;
            }
            MailEntity mailEntity = new MailEntity();
            mailEntity.setTo(to);

            Map<String, String> tmpl = tmplAssignment(busiType, type, params);
            String title = tmpl.get("title");
            if (StringUtils.isBlank(title)) {
                return result;
            }
            mailEntity.setSubject(title);

            String content = tmpl.get("content");
            if (StringUtils.isBlank(content)) {
                return result;
            }
            mailEntity.setText(content);
            mailEntity.setFilePath(filePath);
            try {
                mailSenderService.sendMimeMessage(mailEntity);
                result = true;
            } catch (Exception e) {
                result = false;
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean mobileMessageSend(String mobile, String content) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;

        try {
            result = smsClient.sendSms(mobile, content);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public boolean mobileMessageSend(String userInfoId, String busiType, String mobile, Map<String, String> params) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;
        String type = MessageType.sms.toString();

        if (StringUtils.isBlank(mobile)) {
            return result;
            // throw new ParameterNullPointerException("mobile");
        }

        Map<String, String> tmpl = tmplAssignment(busiType, type, params);

        String content = tmpl.get("content");
        if (StringUtils.isBlank(content)) {
            return result;
            // throw new TemplateInexistenceException("未定义content模板内容！");
        }

        try {
            result = smsClient.sendSms(mobile, content);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        if (result) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserInfoId(userInfoId);
            userMessage.setBusiType(busiType);
            userMessage.setType(type);
            userMessage.setContent(content);
            userMessage.setStatus("unread");
            userMessage.setReceiveAddress(mobile);
            userMessage.setDataStatus("valid");
            userMessage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));

            // 业务私有域数据
            String busiPriv = params.get("busiPriv");
            userMessage.setBusiPriv(busiPriv);

            result = messageRepository.addUserMessage(userMessage);
        }

        return result;
    }

    public boolean mobileVoiceMessageSend(String userInfoId, String busiType, String mobile, String content, String busiPriv) throws ParameterNullPointerException {
        boolean result = false;
        String type = MessageType.sms.toString();

        if (StringUtils.isBlank(mobile)) {
            return result;
            // throw new ParameterNullPointerException("mobile");
        }

        try {
            result = smsClient.sendVoice(new String[]{mobile}, content);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        if (result) {
            UserMessage userMessage = new UserMessage();
            userMessage.setUserInfoId(userInfoId);
            userMessage.setBusiType(busiType);
            userMessage.setType(type);
            userMessage.setContent("语音验证码：" + content);
            userMessage.setStatus("unread");
            userMessage.setReceiveAddress(mobile);
            userMessage.setDataStatus("valid");
            userMessage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));

            // 业务私有域数据
            userMessage.setBusiPriv(busiPriv);

            result = messageRepository.addUserMessage(userMessage);
        }

        return result;
    }

    public boolean webSiteMessageSend(String userInfoId, String busiType, Map<String, String> params) throws ParameterNullPointerException, TemplateInexistenceException {
        boolean result = false;
        String type = MessageType.website.toString();

        Map<String, String> tmpl = tmplAssignment(busiType, type, params);

        UserMessage userMessage = new UserMessage();

        if (StringUtils.isBlank(userInfoId)) {
            return result;
            // throw new ParameterNullPointerException("userInfoId");
        }
        userMessage.setUserInfoId(userInfoId);
        userMessage.setBusiType(busiType);
        userMessage.setType(type);

        String title = tmpl.get("title");
        if (StringUtils.isBlank(title)) {
            return result;
            // throw new TemplateInexistenceException("未定义title模板内容！");
        }
        userMessage.setTopic(title);

        String content = tmpl.get("content");
        if (StringUtils.isBlank(content)) {
            return result;
            // throw new TemplateInexistenceException("未定义content模板内容！");
        }
        userMessage.setContent(content);

        userMessage.setDataStatus("valid");
        userMessage.setCreateTime(DateHelper.getYMDHMFormatDate(new Date()));
        userMessage.setStatus("unread");

        // 业务私有域数据
        String busiPriv = params.get("busiPriv");
        userMessage.setBusiPriv(busiPriv);

        result = messageRepository.addUserMessage(userMessage);

        return result;
    }
}
