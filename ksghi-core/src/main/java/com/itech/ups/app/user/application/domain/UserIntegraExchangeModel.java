package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class UserIntegraExchangeModel implements Serializable {

    private static final long serialVersionUID = 6572308069034982329L;
    // 地址的id
    private String addressId;
    // 收货人姓名
    private String consigneeName;
    // 手机号
    private String mobile;
    // 省
    private String province;
    // 市
    private String city;
    // 县
    private String county;
    // 详细地址
    private String address;
    // 礼品类型
    private String giftType;
    // 兑换类型
    private String exchangeType;
    // 兑换需要积分
    private String integra;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getIntegra() {
        return integra;
    }

    public void setIntegra(String integra) {
        this.integra = integra;
    }
}