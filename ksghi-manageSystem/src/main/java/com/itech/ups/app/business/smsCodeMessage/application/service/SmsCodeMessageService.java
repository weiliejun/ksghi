package com.itech.ups.app.business.smsCodeMessage.application.service;

import com.itech.ups.app.smsCodeMessage.application.domain.SmsCodeMessage;

import java.util.List;
import java.util.Map;


public interface SmsCodeMessageService {

    SmsCodeMessage findSmsCodeMessageById(String id);

    List<SmsCodeMessage> findSmsCodeMessagesByUserInfoId(String userInfoId);

    List<SmsCodeMessage> findSmsCodeMessagesByUsrMp(String usrMp);

    int findSmsCodeMessagesTotalCount(Map<String, Object> params);

    List<SmsCodeMessage> findSmsCodeMessages(Map<String, Object> params, int rowStart, int rowEnd);

    SmsCodeMessage addSmsCodeMessage(SmsCodeMessage smsCodeMessage);

    void editSmsCodeMessage(SmsCodeMessage smsCodeMessage);
}