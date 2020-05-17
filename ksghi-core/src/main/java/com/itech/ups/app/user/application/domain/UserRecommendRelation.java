package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class UserRecommendRelation implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6605265101823858894L;

    private String id;

    private String userInfoId;

    private String recommendCode;

    private String paraentRecommendCode;

    private String codePath;

    private Integer recommendLevel;

    private String channel;

    private String createTime;

    private String remark;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    public String getParaentRecommendCode() {
        return paraentRecommendCode;
    }

    public void setParaentRecommendCode(String paraentRecommendCode) {
        this.paraentRecommendCode = paraentRecommendCode;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public Integer getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(Integer recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}