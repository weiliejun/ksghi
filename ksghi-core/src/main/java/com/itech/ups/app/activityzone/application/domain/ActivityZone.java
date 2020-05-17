package com.itech.ups.app.activityzone.application.domain;

import java.math.BigDecimal;

public class ActivityZone implements java.io.Serializable {
    private static final long serialVersionUID = 7737429611257367254L;

    private String id;

    private String code;

    private String name;

    private String startDate;

    private String endDate;

    private String description;

    private String activityUrl;

    private Long clicks;

    private String dataStatus;

    private String creatorId;

    private String creatorName;

    private String createTime;

    private String editorId;

    private String editorName;

    private String editTime;

    private String status;

    private BigDecimal sequnum;

    private String isPlacedTop;

    private String remark;

    private String isTimeLimit;

    private String activityPicture;

    private String workStatus;

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
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

    public BigDecimal getSequnum() {
        return sequnum;
    }

    public void setSequnum(BigDecimal sequnum) {
        this.sequnum = sequnum;
    }

    public String getIsPlacedTop() {
        return isPlacedTop;
    }

    public void setIsPlacedTop(String isPlacedTop) {
        this.isPlacedTop = isPlacedTop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsTimeLimit() {
        return isTimeLimit;
    }

    public void setIsTimeLimit(String isTimeLimit) {
        this.isTimeLimit = isTimeLimit;
    }

    public String getActivityPicture() {
        return activityPicture;
    }

    public void setActivityPicture(String activityPicture) {
        this.activityPicture = activityPicture;
    }
}
