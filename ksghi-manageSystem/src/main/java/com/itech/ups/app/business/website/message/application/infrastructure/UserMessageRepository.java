package com.itech.ups.app.business.website.message.application.infrastructure;

import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-3-27
 * @author  zqs
 * ===========================================================================
 *
 */
@Repository
public class UserMessageRepository extends AbstractRepositoryParent {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List findUserMessages(Map params, int rowStart, int rowEnd) {
        String userName = (String) params.get("userName");
        String busiType = (String) params.get("busiType");
        String nickName = (String) params.get("nickName");
        String mobile = (String) params.get("mobile");
        if (userName == null || userName.trim().length() == 0)
            params.remove("userName");
        if (busiType == null || busiType.trim().length() == 0)
            params.remove("busiType");
        if (mobile == null || mobile.trim().length() == 0)
            params.remove("mobile");
        if (nickName == null || nickName.trim().length() == 0)
            params.remove("nickName");
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("website.selectUserMessages", params);
        return results;
    }

    @SuppressWarnings("rawtypes")
    public long findUserMessagesTotalCount(Map params) {
        String userName = (String) params.get("userName");
        String busiType = (String) params.get("busiType");
        String nickName = (String) params.get("nickName");
        String mobile = (String) params.get("mobile");
        if (userName == null || userName.trim().length() == 0)
            params.remove("userName");
        if (busiType == null || busiType.trim().length() == 0)
            params.remove("busiType");
        if (mobile == null || mobile.trim().length() == 0)
            params.remove("mobile");
        if (nickName == null || nickName.trim().length() == 0)
            params.remove("nickName");
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("website.selectUserMessagesTotalCount", params);
        return totalCount;
    }
}