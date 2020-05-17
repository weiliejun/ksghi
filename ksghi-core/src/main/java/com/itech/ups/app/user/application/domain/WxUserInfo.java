package com.itech.ups.app.user.application.domain;

//微信参数实体
public class WxUserInfo implements java.io.Serializable {
    private String wxappid;// 第三方用户唯一凭证
    private String wxsecret;// 第三方用户唯一凭证密钥，即appsecret
    private String wxopenid;// 用户唯一id
    private String mvjinke;// 微金客M版连接地址

    private Integer type;// 0：订阅号，1：服务号

    private String wxdyappid;// 微信订阅号appid
    private String wxdysecret;// 微信订阅号secretid

    private String isBind;// 是否绑定微信

    public String getIsBind() {
        return isBind;
    }

    public void setIsBind(String isBind) {
        this.isBind = isBind;
    }

    public String getWxdyappid() {
        return wxdyappid;
    }

    public void setWxdyappid(String wxdyappid) {
        this.wxdyappid = wxdyappid;
    }

    public String getWxdysecret() {
        return wxdysecret;
    }

    public void setWxdysecret(String wxdysecret) {
        this.wxdysecret = wxdysecret;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getWxsecret() {
        return wxsecret;
    }

    public void setWxsecret(String wxsecret) {
        this.wxsecret = wxsecret;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMvjinke() {
        return mvjinke;
    }

    public void setMvjinke(String mvjinke) {
        this.mvjinke = mvjinke;
    }
}
