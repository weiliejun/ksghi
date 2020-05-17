package com.itech.ups.app.advertise.application.domain;

import java.io.Serializable;

public class Advertise implements Serializable {

    private static final long serialVersionUID = 7737429611257367254L;

    private String id;

    private String code;

    private String name;

    private String channel;

    private String type;

    private String description;

    private String targetUrl;

    private String advertisePicture;

    private String advertiseText;

    private Long clicks;

    private String dataStatus;

    private String creatorId;

    private String creatorName;

    private String createTime;

    private String editorId;

    private String editorName;

    private String editTime;

    private String status;

    private Integer sequnum;

    private String advertiseVideoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getAdvertisePicture() {
        return advertisePicture;
    }

    public void setAdvertisePicture(String advertisePicture) {
        this.advertisePicture = advertisePicture;
    }

    public String getAdvertiseText() {
        return advertiseText;
    }

    public void setAdvertiseText(String advertiseText) {
        this.advertiseText = advertiseText;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSequnum() {
        return sequnum;
    }

    public void setSequnum(Integer sequnum) {
        this.sequnum = sequnum;
    }

    public String getAdvertiseVideoUrl() {
        return advertiseVideoUrl;
    }

    public void setAdvertiseVideoUrl(String advertiseVideoUrl) {
        this.advertiseVideoUrl = advertiseVideoUrl;
    }

}