package com.itech.ups.app.portal.application.service;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.manager.application.domain.Manager;

import java.util.List;


/*
 *  * @(#)SecurityService.java, 1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块业务服务层的接口
 */

public interface SecurityService {

    List<Function> findAllFunctions();

    List<Function> findManagerAuthorityFunctions(Manager manager);

}
