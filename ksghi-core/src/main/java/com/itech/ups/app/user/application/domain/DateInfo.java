package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class DateInfo implements Serializable {

    private static final long serialVersionUID = 3322131715197967547L;

    private String time;

    private String dateType;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

}