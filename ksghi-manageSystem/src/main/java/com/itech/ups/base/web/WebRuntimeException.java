package com.itech.ups.base.web;

import com.itech.core.exception.BaseRuntimeException;

/*
 * ===========================================================================
 * Copyright 2007 CHENGANG Corp. All Rights Reserved.
 * @version 1.0, 2007-9-3
 * @author  Jack Chen
 * ===========================================================================
 *
 */

public class WebRuntimeException extends BaseRuntimeException {

    private static final long serialVersionUID = 962502039474876180L;

    public WebRuntimeException() {
        super();
        // constructor from parent
    }

    public WebRuntimeException(String message) {
        super(message);
        // constructor from parent
    }

    public WebRuntimeException(String message, Throwable cause) {
        super(message, cause);
        // constructor from parent
    }

    public WebRuntimeException(Throwable cause) {
        super(cause);
        // constructor from parent
    }

}
