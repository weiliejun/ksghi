package com.itech.ups.app.portal.application.service;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.portal.application.infrastructure.SecurityRepository;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @(#)SecurityServiceImp.java, 1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块业务服务层的实现类
 */

@Service("securityService")
public class SecurityServiceImp extends AbstractServiceParent implements SecurityService {

    @Autowired
    private SecurityRepository repository;

    public SecurityServiceImp() {
        super();
    }

    @Override
    public List<Function> findAllFunctions() {
        return repository.findAllFunctions();
    }

    @Override
    public List<Function> findManagerAuthorityFunctions(Manager manager) {
        List<Function> functions = null;
        if (manager.getCode().endsWith(ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE)) {
            functions = repository.findAllFunctions();
        } else {
            functions = repository.findManagerAuthorityFunctions(manager.getId());
        }
        return functions;
    }

    public SecurityRepository getRepository() {
        return repository;
    }

    public void setRepository(SecurityRepository repository) {
        this.repository = repository;
    }
}
