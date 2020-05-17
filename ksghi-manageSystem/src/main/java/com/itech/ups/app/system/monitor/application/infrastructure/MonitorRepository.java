package com.itech.ups.app.system.monitor.application.infrastructure;

import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.app.monitor.application.domain.LoginLog;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件名：MonitorRepository.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */

@Repository
public class MonitorRepository extends AbstractRepositoryParent {

    public List findBusinessLogs(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("monitor.selectBusinessLogs", params);
        return results;
    }

    public long findBusinessLogsTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("monitor.selectBusinessLogsTotalCount", params);
        return totalCount;
    }

    public List findLoginLogs(Map params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        List results = sqlMapClientTemplate.queryForList("monitor.selectLoginLogs", params);
        return results;
    }

    public long findLoginLogsTotalCount(Map params) {
        long totalCount = (Long) sqlMapClientTemplate.queryForObject("monitor.selectLoginLogsTotalCount", params);
        return totalCount;
    }

    public List findWithdrawAudits(Map<String, Object> params, int rowStart, int rowEnd) {
        params.put("rowStart", rowStart);
        params.put("rowEnd", rowEnd);
        return sqlMapClientTemplate.queryForList("monitor.selectWithdrawAudits", params);
    }

    public long findWithdrawAuditsTotal(Map<String, Object> params) {
        return (Long) sqlMapClientTemplate.queryForObject("monitor.selectWithdrawAuditsTotal", params);
    }

    public void saveBusinessLog(BusinessLog log) {
        log.setId(this.generateIdentifier());
        sqlMapClientTemplate.insert("monitor.insertBusinessLog", log);
    }

    public void saveLoginLog(LoginLog log) {
        log.setId(this.generateIdentifier());
        sqlMapClientTemplate.insert("monitor.insertLoginLog", log);
    }

    public void saveLogoffLog(String sessionId, String date) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("logoffTime", date);
        params.put("sessionId", sessionId);
        sqlMapClientTemplate.update("monitor.updateLoginLog", params);
    }

    public BusinessLog selectByOperationData(String operationData) {
        return (BusinessLog)sqlMapClientTemplate.queryForObject("monitor.selectByOperationData",operationData);
    }
}
