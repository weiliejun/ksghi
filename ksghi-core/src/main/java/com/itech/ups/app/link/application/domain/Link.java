package com.itech.ups.app.link.application.domain;

import java.io.Serializable;

public class Link implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6035978962742612336L;

    private String id;

    private String name;

    private String url;

    private String logo;

    private Long sequnum;

    private String type;

    private String description;

    private String dataStatus;

    private String creatorId;

    private String creatorName;

    private String createTime;

    private String editorId;

    private String editorName;

    private String editTime;

    private Long views;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getSequnum() {
        return sequnum;
    }

    public void setSequnum(Long sequnum) {
        this.sequnum = sequnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Link [id=" + id + ", name=" + name + ", url=" + url + ", logo=" + logo + ", sequnum=" + sequnum + ", type=" + type + ", description=" + description + ", dataStatus=" + dataStatus + ", creatorId=" + creatorId + ", creatorName=" + creatorName + ", createTime=" + createTime + ", editorId=" + editorId + ", editorName=" + editorName + ", editTime=" + editTime + ", views=" + views + ", remark=" + remark + "]";
    }

}