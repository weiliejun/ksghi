package com.itech.ups.app.components.integra.exception;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-3-31
 * @author  zqs
 * ===========================================================================
 *
 */

public class ProcessErrorException extends IntegraRuntimeException {

    private static final long serialVersionUID = 9198493790439709408L;

    public ProcessErrorException(String info) {
        super("数据处理异常：" + info);
    }
}
