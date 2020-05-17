package com.itech.ups.base.application.infrastructure.dataaccess;

import com.itech.core.exception.BaseRuntimeException;

/**
 * 文件名：DataAccessException.java 版本信息：v1.0 日期：2011-12-19 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class DataAccessException extends BaseRuntimeException {

    private static final long serialVersionUID = -8988858630779488507L;

    private String message = null;// 消息

    private Object[] messageArgs = null;// 制定复合消息中的参数，支持复合消息

    public DataAccessException(String message) {
        super(message);
        this.message = message;
    }

    public DataAccessException(String message, Object[] messageArgs) {
        super(message);
        this.message = message;
        this.messageArgs = messageArgs;
    }

    public DataAccessException(String message, Object[] messageArgs, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.messageArgs = messageArgs;
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

}
