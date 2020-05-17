package com.itech.ups.app.user.application.domain;

public class User implements java.io.Serializable {

    private static final long serialVersionUID = -1961222973063983964L;

    private String id;

    private String password;

    private String name;

    private String nickName;

    private String idNo;

    private String email;

    private String mobile;

    private String photo;

    private String smallPhoto;

    private String bankCardStatus;

    private String idNoStatus;

    private String mobileStatus;

    private String emailStatus;

    private String createTime;

    private String dataStatus;

    private String remark;

    private String updateTime;

    private Long integraAmount;

    private String openAccountStatus;
    private String activateStatus;
    private String type;
    private String roleType;
    private String busiCode;
    private String instuCode;
    private String taxCode;
    private String recommendCode;
    private String sourceCode;
    private String authorizationQqId;
    private String authorizationWeiboId;
    private String orgCode;
    private String userLabel;
    private String orgPersonCode;
    private String personCode;
    private String terminal;
    private String appid;
    private String wxappid;
    private String wxsecret;
    private String wxdyappid;
    private String wxdysecret;
    private String wxopenid;
    private String userTmsId;
    private String depoAcctType;
    private String authenticationStatus;
    private String trustSignId;

    public String getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(String activateStatus) {
        this.activateStatus = activateStatus;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", name=" + name + ", nickName=" + nickName + ", idNo=" + idNo + ", email=" + email + ", mobile=" + mobile + ", photo=" + photo + ", smallPhoto=" + smallPhoto + ", bankCardStatus=" + bankCardStatus + ", idNoStatus=" + idNoStatus + ", mobileStatus=" + mobileStatus + ", emailStatus=" + emailStatus + ", createTime=" + createTime + ", dataStatus=" + dataStatus + ", remark=" + remark + ", updateTime=" + updateTime + ", integraAmount=" + integraAmount + ", openAccountStatus=" + openAccountStatus + ",authenticationStatus=" + authenticationStatus + ", type=" + type + ", roleType=" + roleType + ", busiCode=" + busiCode + ", instuCode=" + instuCode + ", taxCode=" + taxCode + ", recommendCode=" + recommendCode + ", sourceCode=" + sourceCode + ", authorizationQqId=" + authorizationQqId
                + ", authorizationWeiboId=" + authorizationWeiboId + ", orgCode=" + orgCode + ", userLabel=" + userLabel + ", orgPersonCode=" + orgPersonCode + ", personCode=" + personCode + ", terminal=" + terminal + ", appid=" + appid + ", wxappid=" + wxappid + ", wxsecret=" + wxsecret + ", wxdyappid=" + wxdyappid + ", wxdysecret=" + wxdysecret + ", wxopenid=" + wxopenid + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBankCardStatus() {
        return bankCardStatus;
    }

    public void setBankCardStatus(String bankCardStatus) {
        this.bankCardStatus = bankCardStatus;
    }

    public String getIdNoStatus() {
        return idNoStatus;
    }

    public void setIdNoStatus(String idNoStatus) {
        this.idNoStatus = idNoStatus;
    }

    public String getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(String mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getIntegraAmount() {
        return integraAmount;
    }

    public void setIntegraAmount(Long integraAmount) {
        this.integraAmount = integraAmount;
    }

    public String getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(String smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public String getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(String openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getInstuCode() {
        return instuCode;
    }

    public void setInstuCode(String instuCode) {
        this.instuCode = instuCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getAuthorizationQqId() {
        return authorizationQqId;
    }

    public void setAuthorizationQqId(String authorizationQqId) {
        this.authorizationQqId = authorizationQqId;
    }

    public String getAuthorizationWeiboId() {
        return authorizationWeiboId;
    }

    public void setAuthorizationWeiboId(String authorizationWeiboId) {
        this.authorizationWeiboId = authorizationWeiboId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getOrgPersonCode() {
        return orgPersonCode;
    }

    public void setOrgPersonCode(String orgPersonCode) {
        this.orgPersonCode = orgPersonCode;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getWxsecret() {
        return wxsecret;
    }

    public void setWxsecret(String wxsecret) {
        this.wxsecret = wxsecret;
    }

    public String getWxdyappid() {
        return wxdyappid;
    }

    public void setWxdyappid(String wxdyappid) {
        this.wxdyappid = wxdyappid;
    }

    public String getWxdysecret() {
        return wxdysecret;
    }

    public void setWxdysecret(String wxdysecret) {
        this.wxdysecret = wxdysecret;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public String getUserTmsId() {
        return userTmsId;
    }

    public void setUserTmsId(String userTmsId) {
        this.userTmsId = userTmsId;
    }

    public String getDepoAcctType() {
        return depoAcctType;
    }

    public void setDepoAcctType(String depoAcctType) {
        this.depoAcctType = depoAcctType;
    }

    public String getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(String authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getTrustSignId() {
        return trustSignId;
    }

    public void setTrustSignId(String trustSignId) {
        this.trustSignId = trustSignId;
    }

}