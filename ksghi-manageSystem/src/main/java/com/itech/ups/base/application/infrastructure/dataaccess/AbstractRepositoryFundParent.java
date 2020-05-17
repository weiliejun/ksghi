package com.itech.ups.base.application.infrastructure.dataaccess;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：AbstractRepositoryParent.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Repository
public abstract class AbstractRepositoryFundParent {

    private static final Log logger = LogFactory.getLog(AbstractRepositoryFundParent.class);

    @Autowired
    public SqlMapClientTemplate sqlMapClientTemplateFund;

    @Autowired
    public JdbcTemplate jdbcTemplateFund;

    @Resource
    public BasicDataSource dataSourceFund;

    public AbstractRepositoryFundParent() {
        super();
    }

    /**
     * 生成UUID
     */
    public String generateIdentifier() {
        // String uuid = UUID.randomUUID().toString();
        // return uuid ;
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = format.format(new Date().getTime()) + new Double(Math.random() * 100000).intValue();
        while (uuid.length() < 22) {
            uuid = uuid + "0";
        }
        uuid = uuid.substring(2);
        return uuid;
    }

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        // try {
        sqlMapClientTemplateFund.setDataSource(dataSourceFund);
        // String
        // locationRegularExpression="C:/apache-tomcat-6.0.32/webapps/wms/WEB-INF/classes/com/itech/ups/app/business/fund/application/infrastructure/sqlmaps/ibatis-sqlmaps-MFNetValuePerformance.xml";
        // String xmlFiles[] =ResourceFinder.getFile(locationRegularExpression);
        // for(int i=0 ; i< xmlFiles.length; i++){
        // logger.info("load sqlmap config file:" + xmlFiles[i]);
        // String sqlMapFileNames = xmlFiles[i];
        // File file = new File(sqlMapFileNames);
        // InputStream is;
        // is = new FileInputStream(file);
        // SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(is);
        // sqlMapClientTemplateFund.setSqlMapClient(client);
        // }
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return sqlMapClientTemplateFund;
    }

    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplateFund) {
        this.sqlMapClientTemplateFund = sqlMapClientTemplateFund;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplateFund) {
        this.jdbcTemplateFund = jdbcTemplateFund;
    }

    /**
     * 防止sql注入
     */
    public String transactSqlInject(String str) {
        return str.replaceAll(".*([';]+|(--)+).*", " ");
    }

}
