package com.itech.ups.test.init;

import com.itech.core.util.DateHelper;
import com.itech.core.util.MD5Helper;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.web.taglibs.code.PropertiesCodes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

/**
 * 版本信息：v1.0 日期：2011-12-29 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class InitApplicationService {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext*.xml");
        InitApplicationService service = new InitApplicationService();
        service.initFunction(applicationContext);
        // service.initSuperManager(applicationContext);
        // service.initMerchant(applicationContext);

    }

    private void initFunction(ApplicationContext applicationContext) {
        AuthorityService service = (AuthorityService) applicationContext.getBean("authorityService");
        String propertiesLocation = "/config/applicationFunction.properties";
        InputStream resourceAsStream = PropertiesCodes.class.getResourceAsStream(propertiesLocation);
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Iterator elements = properties.values().iterator();
        int row = 0;
        while (elements.hasNext()) {
            String content = (String) elements.next();
            System.out.println((++row) + ":" + content);
            String[] values = content.split(";");
            for (int i = 0; i < values.length; i++) {
                Function function = new Function();
                function.setId(values[i].split(",")[0]);
                function.setCode(values[i].split(",")[0]);
                function.setParentCode(values[i].split(",")[1]);
                function.setName(values[i].split(",")[2]);
                function.setUrl(values[i].split(",")[3]);
                function.setNodeType(values[i].split(",")[4]);
                function.setSeqnum(new Integer(values[i].split(",")[5]));
                function.setStatus(values[i].split(",")[6]);
                if ((values[i].split(",")).length > 7) {
                    function.setIcon(values[i].split(",")[7]);
                } else {
                    function.setIcon("");
                }
                service.addFunction(function);
            }
        }
    }

    private void initMerchant(ApplicationContext applicationContext) {
		/*MerchantService service = (MerchantService) applicationContext.getBean("merchantService");
		Merchant merchant = new Merchant();
		// merchant.setName("北京君德汇富出借咨询有限公司");
		merchant.setName("北京国恒保险代理有限公司");
		merchant.setPhone("");
		merchant.setFax("");
		merchant.setPost("");
		merchant.setAddress("");
		merchant.setSummary("");
		merchant.setRemark("");
		merchant.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
		merchant.setDataStatus("valid");
		merchant = service.addMerchant(merchant);

		MerchantAccount account = new MerchantAccount();
		account.setMerchantId(merchant.getId());
		account.setUsrId("530082");
		// account.setUsrCustId("6000060000131922");
		// account.setUsrName("北京君德汇富出借咨询有限公司");
		account.setUsrCustId("6000060000187827");
		account.setUsrName("北京国恒保险代理有限公司");
		account.setInAcctId(null);
		account.setOutAcctId(null);
		account.setRemark("");
		account.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
		account.setDataStatus("valid");
		service.addMerchantAccount(account);*/
    }

    private void initSuperManager(ApplicationContext applicationContext) {
        ManagerService service = (ManagerService) applicationContext.getBean("managerService");
        Manager manager = new Manager();
        manager.setCode(ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE);
        manager.setName("系统管理员");
        manager.setPassword((new MD5Helper()).getMD5ofStr(ApplicationConstant.APP_MANAGER_INIT_PASSWORD));
        manager.setDuty("负责系统初始化");
        manager.setRemark("");
        manager.setStatus("valid");
        manager.setCreatorId(ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE);
        manager.setCreatorName("系统管理员");
        manager.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setEditorId(ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE);
        manager.setEditorName("系统管理员");
        manager.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));
        manager.setDataStatus("valid");// invalid-删除 valid有效
        service.addManager(manager);
    }

}
