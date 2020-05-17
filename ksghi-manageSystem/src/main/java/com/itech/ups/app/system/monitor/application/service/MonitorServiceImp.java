package com.itech.ups.app.system.monitor.application.service;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.components.util.BusinessHelper;
import com.itech.ups.app.monitor.application.domain.BusinessLog;
import com.itech.ups.app.monitor.application.domain.LoginLog;
import com.itech.ups.app.system.monitor.application.infrastructure.MonitorRepository;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.application.service.AbstractServiceParent;
import com.itech.ups.base.web.taglibs.code.Code;
import com.itech.ups.base.web.taglibs.code.CodesDBFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("monitorService")
public class MonitorServiceImp extends AbstractServiceParent implements MonitorService {

    @Autowired
    public MonitorRepository monitorRepository;

    @Override
    public List findBusinessLogs(Map params, int rowStart, int rowEnd) {
        return monitorRepository.findBusinessLogs(params, rowStart, rowEnd);
    }

    @Override
    public long findBusinessLogsTotalCount(Map params) {
        return monitorRepository.findBusinessLogsTotalCount(params);
    }

    @Override
    public List findLoginLogs(Map params, int rowStart, int rowEnd) {
        List<Map<String, Object>> LoginLogs = monitorRepository.findLoginLogs(params, rowStart, rowEnd);
        Code code = CodesDBFactory.getInstance().getCodeByDB("userClassification");
        for (Map<String, Object> LoginLog : LoginLogs) {
            if (code != null) {
                BusinessHelper.userClassConvert(LoginLog, code.getItems());
            }
        }
        return LoginLogs;
    }

    @Override
    public long findLoginLogsTotalCount(Map params) {
        return monitorRepository.findLoginLogsTotalCount(params);
    }

    @Override
    public List findWithdrawAudits(Map<String, Object> params, int rowStart, int rowEnd) {
        return monitorRepository.findWithdrawAudits(params, rowStart, rowEnd);
    }

    @Override
    public long findWithdrawAuditsTotal(Map<String, Object> params) {
        return monitorRepository.findWithdrawAuditsTotal(params);
    }

    public void saveBusinessLog(CurrentManager cmanager, String functionModule, String functionDescription, String operationData) {

        BusinessLog log = new BusinessLog();
        String operationTime = DateHelper.getYMDHMSFormatDate(new Date());
        log.setManagerId(cmanager.getManager().getId());
        log.setManagerCode(cmanager.getManager().getCode());
        log.setManagerName(cmanager.getManager().getName());
        log.setSessionId(cmanager.getSessionId());
        log.setIp(cmanager.getIp());
        log.setOperationTime(operationTime);
        log.setFunctionModule(functionModule);
        log.setFunctionDescription(functionDescription);
        log.setOperationData(operationData);
        monitorRepository.saveBusinessLog(log);
    }

    @Override
    public void saveLoginLog(CurrentManager currentManager) {
        LoginLog loginLog = new LoginLog();
        loginLog.setManagerId(currentManager.getManager().getId());
        loginLog.setManagerCode(currentManager.getManager().getCode());
        loginLog.setManagerName(currentManager.getManager().getName());
        loginLog.setSessionId(currentManager.getSessionId());
        loginLog.setIp(currentManager.getIp());
        loginLog.setLoginTime(currentManager.getLoginTime());
        loginLog.setRoleType(ApplicationConstant.PLATFORM_SUPER_ADMIN_ROLE_TYPE);
        loginLog.setTerminal("pc");
        monitorRepository.saveLoginLog(loginLog);
    }

    @Override
    public void saveLogoffLog(CurrentManager currentManager) {
        String date = DateHelper.getYMDHMSFormatDate(new Date());
        monitorRepository.saveLogoffLog(currentManager.getSessionId(), date);
    }

    @Override
    public BusinessLog selectByOperationData(String operationData) {
        return monitorRepository.selectByOperationData(operationData);
    }
}
