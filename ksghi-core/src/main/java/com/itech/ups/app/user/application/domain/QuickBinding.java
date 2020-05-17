package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

/**
 * @author 代树理
 * @version 3.0
 * @description 用户换绑卡
 * @update 2017年5月2日 下午3:05:48
 */
public class QuickBinding implements Serializable {

    private static final long serialVersionUID = 8463698346195277013L;

    private String version;

    private String cmdId;

    private String merCustId;

    private String usrCustId;

    private String tradeType;

    private String bankId;

    private String openAcctId;

    private String usrMp;

    private String provId;

    private String areaId;

    private String smsSeq;

    private String smsCode;

    private String orgSmsExt;

    private String bgRetUrl;

    private String chkValue;

    private String respCode;

    private String respDesc;

    private String secRespCode;

    private String secRespDesc;

    private String trxId;

    private String ordId;

    private String retUrl;

    private String depoBankSeq;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCmdId() {
        return cmdId;
    }

    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    public String getMerCustId() {
        return merCustId;
    }

    public void setMerCustId(String merCustId) {
        this.merCustId = merCustId;
    }

    public String getUsrCustId() {
        return usrCustId;
    }

    public void setUsrCustId(String usrCustId) {
        this.usrCustId = usrCustId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getOpenAcctId() {
        return openAcctId;
    }

    public void setOpenAcctId(String openAcctId) {
        this.openAcctId = openAcctId;
    }

    public String getUsrMp() {
        return usrMp;
    }

    public void setUsrMp(String usrMp) {
        this.usrMp = usrMp;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getSmsSeq() {
        return smsSeq;
    }

    public void setSmsSeq(String smsSeq) {
        this.smsSeq = smsSeq;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getOrgSmsExt() {
        return orgSmsExt;
    }

    public void setOrgSmsExt(String orgSmsExt) {
        this.orgSmsExt = orgSmsExt;
    }

    public String getBgRetUrl() {
        return bgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        this.bgRetUrl = bgRetUrl;
    }

    public String getChkValue() {
        return chkValue;
    }

    public void setChkValue(String chkValue) {
        this.chkValue = chkValue;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getSecRespCode() {
        return secRespCode;
    }

    public void setSecRespCode(String secRespCode) {
        this.secRespCode = secRespCode;
    }

    public String getSecRespDesc() {
        return secRespDesc;
    }

    public void setSecRespDesc(String secRespDesc) {
        this.secRespDesc = secRespDesc;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getRetUrl() {
        return retUrl;
    }

    public void setRetUrl(String retUrl) {
        this.retUrl = retUrl;
    }

    public String getDepoBankSeq() {
        return depoBankSeq;
    }

    public void setDepoBankSeq(String depoBankSeq) {
        this.depoBankSeq = depoBankSeq;
    }
}
