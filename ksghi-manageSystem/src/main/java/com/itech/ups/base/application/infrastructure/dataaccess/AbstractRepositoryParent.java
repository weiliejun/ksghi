package com.itech.ups.base.application.infrastructure.dataaccess;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：AbstractRepositoryParent.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Repository
public abstract class AbstractRepositoryParent {

    private static final Log logger = LogFactory.getLog(AbstractRepositoryParent.class);

    @Autowired
    public SqlMapClientTemplate sqlMapClientTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AbstractRepositoryParent() {
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
        return sqlMapClientTemplate;
    }

    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 防止sql注入
     */
    public String transactSqlInject(String str) {
        return str.replaceAll(".*([';]+|(--)+).*", " ");
    }

}
