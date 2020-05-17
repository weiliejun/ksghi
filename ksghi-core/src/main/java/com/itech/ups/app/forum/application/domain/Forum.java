package com.itech.ups.app.forum.application.domain;

public class Forum implements java.io.Serializable {
    private String id;

    private String name;

    private String description;

    private String parentId;

    private Integer sequnum;

    private Integer postsNum;

    private Integer postsReplyNum;

    private String creatorId;

    private String creatorName;

    private String createTime;

    private String editorId;

    private String editorName;

    private String editTime;

    private String dataStatus;

    private String code;

    private String logo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getPostsNum() {
        return postsNum;
    }

    public void setPostsNum(Integer postsNum) {
        this.postsNum = postsNum;
    }

    public Integer getPostsReplyNum() {
        return postsReplyNum;
    }

    public void setPostsReplyNum(Integer postsReplyNum) {
        this.postsReplyNum = postsReplyNum;
    }

    public Integer getSequnum() {
        return sequnum;
    }

    public void setSequnum(Integer sequnum) {
        this.sequnum = sequnum;
    }
}