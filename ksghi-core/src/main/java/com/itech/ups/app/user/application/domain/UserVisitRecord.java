package com.itech.ups.app.user.application.domain;

public class UserVisitRecord implements java.io.Serializable {

    private static final long serialVersionUID = -1961223073063983964L;

    private String id;
    private String userInfoId;
    private String editorId;
    private String editorName;
    private String editorTime;
    private String investIntention;
    private String dataStatus;
    private String remark;
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getEditorTime() {
        return editorTime;
    }

    public void setEditorTime(String editorTime) {
        this.editorTime = editorTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvestIntention() {
        return investIntention;
    }

    public void setInvestIntention(String investIntention) {
        this.investIntention = investIntention;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

}