package com.itech.ups.app.components.message.exception;

import com.itech.core.exception.BaseRuntimeException;

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

public class MessageRuntimeException extends BaseRuntimeException {

    private static final long serialVersionUID = 6282589858600134736L;

    public MessageRuntimeException(String message) {
        super(message);
    }
}
