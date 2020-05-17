package com.itech.ups.app.business.smsCodeMessage.application.infrastructure;

import com.itech.ups.app.smsCodeMessage.application.domain.SmsCodeMessage;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SmsCodeMessageRepository extends AbstractRepositoryParent {

    public SmsCodeMessage findSmsCodeMessageById(String id) {
        return (SmsCodeMessage) sqlMapClientTemplate.queryForObject("smsCodeMessage.selectSmsCodeMessage", id);
    }

    public List<SmsCodeMessage> findSmsCodeMessagesByUserInfoId(String userInfoId) {
        return (List<SmsCodeMessage>) sqlMapClientTemplate.queryForList("smsCodeMessage.selectSmsCodeMessagesByUserInfoId", userInfoId);
    }

    public List<SmsCodeMessage> findSmsCodeMessagesByUsrMp(String usrMp) {
        return (List<SmsCodeMessage>) sqlMapClientTemplate.queryForList("smsCodeMessage.selectSmsCodeMessagesByUsrMp", usrMp);
    }

    public int findSmsCodeMessagesTotalCount(Map<String, Object> params) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("smsCodeMessage.selectSmsCodeMessagesTotalCount", params);
        return totalCount;
    }

    public List<SmsCodeMessage> findSmsCodeMessages(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return (List<SmsCodeMessage>) sqlMapClientTemplate.queryForList("smsCodeMessage.selectSmsCodeMessages", params);
    }

    public SmsCodeMessage addSmsCodeMessage(SmsCodeMessage smsCodeMessage) {
        smsCodeMessage.setId(this.generateIdentifier());
        sqlMapClientTemplate.insert("smsCodeMessage.insertSmsCodeMessage", smsCodeMessage);
        return smsCodeMessage;
    }

    public void editSmsCodeMessage(SmsCodeMessage smsCodeMessage) {
        sqlMapClientTemplate.update("smsCodeMessage.updateSmsCodeMessage", smsCodeMessage);
    }
}
