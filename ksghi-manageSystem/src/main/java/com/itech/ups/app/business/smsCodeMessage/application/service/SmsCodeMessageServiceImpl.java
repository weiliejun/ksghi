package com.itech.ups.app.business.smsCodeMessage.application.service;

import com.itech.ups.app.business.smsCodeMessage.application.infrastructure.SmsCodeMessageRepository;
import com.itech.ups.app.smsCodeMessage.application.domain.SmsCodeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("smsCodeMessageService")
public class SmsCodeMessageServiceImpl implements SmsCodeMessageService {
    @Autowired
    private SmsCodeMessageRepository smsCodeMessageRepository;

    @Override
    public SmsCodeMessage findSmsCodeMessageById(String id) {
        return smsCodeMessageRepository.findSmsCodeMessageById(id);
    }

    @Override
    public List<SmsCodeMessage> findSmsCodeMessagesByUserInfoId(String userInfoId) {
        return smsCodeMessageRepository.findSmsCodeMessagesByUserInfoId(userInfoId);
    }

    @Override
    public List<SmsCodeMessage> findSmsCodeMessagesByUsrMp(String usrMp) {
        return smsCodeMessageRepository.findSmsCodeMessagesByUsrMp(usrMp);
    }

    @Override
    public int findSmsCodeMessagesTotalCount(Map<String, Object> params) {
        return smsCodeMessageRepository.findSmsCodeMessagesTotalCount(params);
    }

    @Override
    public List<SmsCodeMessage> findSmsCodeMessages(Map<String, Object> params, int rowStart, int rowEnd) {
        return smsCodeMessageRepository.findSmsCodeMessages(params, rowStart, rowEnd);
    }

    @Override
    public SmsCodeMessage addSmsCodeMessage(SmsCodeMessage smsCodeMessage) {
        return smsCodeMessageRepository.addSmsCodeMessage(smsCodeMessage);
    }

    @Override
    public void editSmsCodeMessage(SmsCodeMessage smsCodeMessage) {
        smsCodeMessageRepository.editSmsCodeMessage(smsCodeMessage);
    }
}