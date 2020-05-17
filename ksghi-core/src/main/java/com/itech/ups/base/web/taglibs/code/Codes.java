package com.itech.ups.base.web.taglibs.code;

import java.io.Serializable;

/**
 * @author mike chen
 * @since 2.0
 */
public interface Codes extends Serializable {
    /**
     * Get the property.
     */
    public Code getCode(String code);
}
