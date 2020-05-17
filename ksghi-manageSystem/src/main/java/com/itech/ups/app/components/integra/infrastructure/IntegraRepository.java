package com.itech.ups.app.components.integra.infrastructure;

import com.itech.ups.app.user.application.domain.UserIntegra;
import com.itech.ups.app.user.application.domain.UserIntegraRule;
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
public class IntegraRepository extends AbstractRepositoryParent {

    public UserIntegra addUserIntegra(UserIntegra userIntegra) {
        userIntegra.setId(generateIdentifier());
        sqlMapClientTemplate.insert("integra.insertUserIntegra", userIntegra);
        return userIntegra;
    }

    public void editUserInfoForIntegraAmount(String userInfoId, String integraType, long integraAmount) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userInfoId", userInfoId);
        params.put("integraType", integraType);
        params.put("integraAmount", integraAmount);
        sqlMapClientTemplate.update("integra.updateUserInfo", params);
    }

    public UserIntegraRule findUserIntegraRuleByBusiType(String busiType) {
        return (UserIntegraRule) sqlMapClientTemplate.queryForObject("integra.selectUserIntegraRuleByBusiType", busiType);
    }
}
