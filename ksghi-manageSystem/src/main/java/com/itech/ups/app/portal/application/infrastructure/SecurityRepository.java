package com.itech.ups.app.portal.application.infrastructure;

import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @(#)SecurityRepository.java, 1.00, 2009-8-5
 * ===========================================================================
 * Author Mike Chen
 * Copyright 2009 Corp. All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * 子模块应用基础设施层的数据仓库类
 */

@Repository
public class SecurityRepository extends AbstractRepositoryParent {

    private static Map<String, String> elementNameMap = new HashMap<String, String>();

    static {
        elementNameMap.put("0", "root");
        elementNameMap.put("1", "subsystem");
        elementNameMap.put("2", "module");
        elementNameMap.put("3", "button");
    }

    public List<Function> findAllFunctions() {
        List functions = this.sqlMapClientTemplate.queryForList("security.selectAllFunctions");
        return functions;
    }

    public List<Function> findManagerAuthorityFunctions(String managerId) {
        List functions = sqlMapClientTemplate.queryForList("security.selectManagerAuthorityFunctions", managerId);
        return functions;
    }
}
