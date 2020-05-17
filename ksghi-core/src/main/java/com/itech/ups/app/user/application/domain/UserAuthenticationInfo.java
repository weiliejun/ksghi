package com.itech.ups.app.user.application.domain;

import java.io.Serializable;

public class UserAuthenticationInfo implements Serializable {

    private static final long serialVersionUID = -5115086566948992225L;

    private String id;

    private String userInfoId;

    private String ticketId;

    private String businessType;

    private String personName;

    private String personSex;

    private String idNumber;

    private String idExpiry;

    private String detailedAddress;

    private String localCardFrontPic;

    private String localCardBackPic;

    private String localFacePic;

    private String remark;

    private String createTime;

    private String dataStatus;

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

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdExpiry() {
        return idExpiry;
    }

    public void setIdExpiry(String idExpiry) {
        this.idExpiry = idExpiry;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLocalCardFrontPic() {
        return localCardFrontPic;
    }

    public void setLocalCardFrontPic(String localCardFrontPic) {
        this.localCardFrontPic = localCardFrontPic;
    }

    public String getLocalCardBackPic() {
        return localCardBackPic;
    }

    public void setLocalCardBackPic(String localCardBackPic) {
        this.localCardBackPic = localCardBackPic;
    }

    public String getLocalFacePic() {
        return localFacePic;
    }

    public void setLocalFacePic(String localFacePic) {
        this.localFacePic = localFacePic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}