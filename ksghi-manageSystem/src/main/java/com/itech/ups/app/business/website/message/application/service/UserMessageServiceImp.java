package com.itech.ups.app.business.website.message.application.service;

import com.itech.ups.app.business.website.message.application.infrastructure.UserMessageRepository;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("userMessageService")
public class UserMessageServiceImp extends AbstractServiceParent implements UserMessageService {

    @Autowired
    public UserMessageRepository repository;

    @SuppressWarnings("rawtypes")
    @Override
    public List findUserMessages(Map params, int rowStart, int rowEnd) {
        return repository.findUserMessages(params, rowStart, rowEnd);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long findUserMessagesTotalCount(Map params) {
        return repository.findUserMessagesTotalCount(params);
    }

}