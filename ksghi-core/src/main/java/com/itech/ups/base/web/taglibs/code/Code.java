package com.itech.ups.base.web.taglibs.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2012-1-16 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class Code {

    private String name;

    private Map<String, String> items = new HashMap<String, String>();

    private List<String> values = new LinkedList<String>();

    public Code(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getItems() {
        return items;
    }

    public void addItem(String value, String label) {
        items.put(value, label);
        values.add(value);
    }

    public List getValues() {
        return values;
    }

}
