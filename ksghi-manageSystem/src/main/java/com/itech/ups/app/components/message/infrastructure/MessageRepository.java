package com.itech.ups.app.components.message.infrastructure;

import com.itech.ups.app.user.application.domain.User;
import com.itech.ups.app.user.application.domain.UserMessage;
import com.itech.ups.app.user.application.domain.UserMessageSet;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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

@Repository
public class MessageRepository extends AbstractRepositoryParent {

    public boolean addUserMessage(UserMessage userMessage) {
        userMessage.setId(this.generateIdentifier());
        sqlMapClientTemplate.insert("message.insertUserMessage", userMessage);
        return true;
    }

    public User findUserById(String id) {
        return (User) sqlMapClientTemplate.queryForObject("message.selectUserById", id);
    }

    public UserMessageSet findUserMessageSetByUserInfoId(String userInfoId, String busiType) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userInfoId", userInfoId);
        params.put("busiType", busiType);
        return (UserMessageSet) sqlMapClientTemplate.queryForObject("message.selectUserMessageSetByUserInfoId", params);
    }
}
