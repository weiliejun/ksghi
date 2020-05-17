package com.itech.ups.app.finance.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class SchoolLoanLimit implements Serializable {
    /**
     * @fields serialVersionUID
     */

    private static final long serialVersionUID = 1L;

    private String id;

    private String schoolCategory;

    private String facultyCategory;

    private BigDecimal loanLimit;

    private String remark;

    private String createTime;

    private String dataStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolCategory() {
        return schoolCategory;
    }

    public void setSchoolCategory(String schoolCategory) {
        this.schoolCategory = schoolCategory;
    }

    public String getFacultyCategory() {
        return facultyCategory;
    }

    public void setFacultyCategory(String facultyCategory) {
        this.facultyCategory = facultyCategory;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
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