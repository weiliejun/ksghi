package com.itech.ups.app.business.stats.action.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Page2Json {

    public static String page2JsonForDataGrid(Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotalRow() + "");
        map.put("rows", page.getList());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
