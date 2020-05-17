package com.itech.ups.app.fjxinfo.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FjxInfo implements Serializable {
    private static final long serialVersionUID = -6467524420429553212L;
    private String id;

    private String xqyId;

    private String bxgs;

    private String xzmc;

    private String xzdm;

    private String bxqj;

    private String jffs;

    private String jfnq;

    private String tbdh;

    private String bxje;

    private BigDecimal sjbf;

    private String zfx;

    private String createTime;

    private String remark;

    private String dataStatus;

    private BigDecimal sjxj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXqyId() {
        return xqyId;
    }

    public void setXqyId(String xqyId) {
        this.xqyId = xqyId;
    }

    public String getBxgs() {
        return bxgs;
    }

    public void setBxgs(String bxgs) {
        this.bxgs = bxgs;
    }

    public String getXzmc() {
        return xzmc;
    }

    public void setXzmc(String xzmc) {
        this.xzmc = xzmc;
    }

    public String getXzdm() {
        return xzdm;
    }

    public void setXzdm(String xzdm) {
        this.xzdm = xzdm;
    }

    public String getBxqj() {
        return bxqj;
    }

    public void setBxqj(String bxqj) {
        this.bxqj = bxqj;
    }

    public String getJffs() {
        return jffs;
    }

    public void setJffs(String jffs) {
        this.jffs = jffs;
    }

    public String getJfnq() {
        return jfnq;
    }

    public void setJfnq(String jfnq) {
        this.jfnq = jfnq;
    }

    public String getTbdh() {
        return tbdh;
    }

    public void setTbdh(String tbdh) {
        this.tbdh = tbdh;
    }

    public String getBxje() {
        return bxje;
    }

    public void setBxje(String bxje) {
        this.bxje = bxje;
    }

    public BigDecimal getSjbf() {
        return sjbf;
    }

    public void setSjbf(BigDecimal sjbf) {
        this.sjbf = sjbf;
    }

    public String getZfx() {
        return zfx;
    }

    public void setZfx(String zfx) {
        this.zfx = zfx;
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

    public BigDecimal getSjxj() {
        return sjxj;
    }

    public void setSjxj(BigDecimal sjxj) {
        this.sjxj = sjxj;
    }
}