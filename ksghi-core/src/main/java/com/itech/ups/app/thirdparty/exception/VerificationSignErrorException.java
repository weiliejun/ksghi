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

public class VerificationSignErrorException extends ChinapnrRuntimeException {

    private static final long serialVersionUID = -4124976552071712134L;

    public VerificationSignErrorException() {
        super("验证签名出错（请检查参与签名的参数是否正确）");
    }
}
