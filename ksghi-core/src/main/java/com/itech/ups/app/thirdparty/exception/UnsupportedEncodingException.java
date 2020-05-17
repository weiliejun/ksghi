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

public class UnsupportedEncodingException extends ChinapnrRuntimeException {

    private static final long serialVersionUID = -8250974225741771833L;

    public UnsupportedEncodingException(String charset) {
        super("数据转换异常：不支持的字符集" + charset);
    }
}
