/**
 * 文件名: FileTemp.java
 *
 * @Package com.phhc.sys.common.util
 * @Description: TODO
 * @author 罗顺锋
 * @date 2015-3-26 下午4:33:26
 * @version V1.0
 */
package com.itech.ups.base.web.bean;

import com.itech.core.util.CodeHelper;
import com.itech.core.util.EncodeType;

import java.util.Date;

/**
 * @ClassName: FileTemp
 * @Description: TODO(附件临时对象)
 * @author 罗顺锋
 * @date 2015-3-26 下午4:33:26
 *
 */
public class FileTemp implements java.io.Serializable {

    // Fields
    private String filename;// 附件名称
    private String filetype;// 附件类型
    private Long filesize;// 附件大小
    private String fileurl;// 附件地址
    private Date filedate;// 上传时间

    private String redirectUrl;// 重定向链接，必选

    private String msg;// 附件下载结果，成功失败自定义

    private Integer submittype;// 客户端提交方式，如果为null视为post，如果不为null视为get方式。进行转码

    /**
     * @return the filedate
     */
    public Date getFiledate() {
        return filedate;
    }

    /**
     * @param filedate
     *            the filedate to set
     */
    public void setFiledate(Date filedate) {
        this.filedate = filedate;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     *            the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the filesize
     */
    public Long getFilesize() {
        return filesize;
    }

    /**
     * @param filesize
     *            the filesize to set
     */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    /**
     * @return the filetype
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * @param filetype
     *            the filetype to set
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    /**
     * @return the fileurl
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * @param fileurl
     *            the fileurl to set
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * @param redirectUrl
     *            the redirectUrl to set
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * @return the submittype
     */
    public Integer getSubmittype() {

        return submittype;
    }

    /**
     * @param submittype
     *            the submittype to set
     */
    public void setSubmittype(Integer submittype) {
        if (submittype != null) {
            if (filename != null) {
                filename = CodeHelper.decodeString(filename, EncodeType.UTF);

            }
            if (fileurl != null) {
                fileurl = CodeHelper.decodeString(fileurl, EncodeType.UTF);
            }
        }
        this.submittype = submittype;
    }
}
