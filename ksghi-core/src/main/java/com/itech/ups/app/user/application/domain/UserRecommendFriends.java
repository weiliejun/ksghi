package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class UserRecommendFriends implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4743148827847256650L;

    private String id;

    private String userInfoId;

    private String channel;

    private String recommendCode;

    private String createTime;

    private String remark;

    private String dataStatus;

    private String parentUserInfoId;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
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

    public String getParentUserInfoId() {
        return parentUserInfoId;
    }

    public void setParentUserInfoId(String parentUserInfoId) {
        this.parentUserInfoId = parentUserInfoId;
    }
}