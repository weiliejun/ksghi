package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class CurrentUser_back implements Serializable {

    private static final long serialVersionUID = -4446583162943858640L;

    private User user;

    private String ip;

    private String loginTime;

    private String sessionId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}