package com.itech.ups.app.business.website.message.application.service;

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
public interface UserMessageService {

    @SuppressWarnings({"rawtypes"})
    List findUserMessages(Map params, int rowStart, int rowEnd);

    @SuppressWarnings("rawtypes")
    long findUserMessagesTotalCount(Map params);
}
