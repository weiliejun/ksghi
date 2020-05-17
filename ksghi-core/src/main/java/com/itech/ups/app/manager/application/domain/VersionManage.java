package com.itech.ups.app.manager.application.domain;

import java.io.Serializable;

public class VersionManage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1232452156455L;

    private String id;
    /* 版本名称 */
    private String name;
    /* 版本类型 */
    private String type;
    /* 版本号 */
    private String version;
    /* 上线时间 */
    private String onlineTime;
    /* 下线时间 */
    private String offlineTime;
    /* 备注 */
    private String remark;
    /* 状态 */
    private String status;
    /* 存放位置 */
    private String path;

    private String createTime;

    private String forcedUpgrade;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getForcedUpgrade() {
        return forcedUpgrade;
    }

    public void setForcedUpgrade(String forcedUpgrade) {
        this.forcedUpgrade = forcedUpgrade;
    }
}
