package com.itech.ups.app.thirdparty.exception;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-3-29
 * @author  zqs
 * ===========================================================================
 *
 */

public class DataProcessingException extends ChinapnrRuntimeException {

    private static final long serialVersionUID = 3564446195892219193L;

    public DataProcessingException() {
        super("数据处理异常！");
    }
}
