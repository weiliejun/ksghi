package com.itech.ups.app.system.monitor.application.service;

import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.base.application.domain.CurrentManager;

import java.util.List;
import java.util.Map;

public interface MonitorService {

    List findBusinessLogs(Map params, int rowStart, int rowEnd);

    long findBusinessLogsTotalCount(Map params);

    List findLoginLogs(Map params, int rowStart, int rowEnd);

    long findLoginLogsTotalCount(Map params);

    List findWithdrawAudits(Map<String, Object> params, int rowStart, int rowEnd);

    long findWithdrawAuditsTotal(Map<String, Object> params);

    void saveBusinessLog(CurrentManager currentManager, String functionModule, String functionDescription, String operationData);

    void saveLoginLog(CurrentManager currentManager);

    void saveLogoffLog(CurrentManager currentManager);

    public BusinessLog selectByOperationData(String operationData);
}
