package com.itech.ups.base.util;

import com.itech.core.util.DateHelper;

import java.util.Random;

/**
 * 版本信息：v1.0 日期：2012-12-15 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class FileHelper {

    public static String disposeFileName(String originalFilename) {
        String fileName = "";
        if (originalFilename != null) {
            fileName = originalFilename.replaceAll(" ", "_").replaceAll("　", "_");// 过滤中英文空格
            fileName = fileName.toLowerCase();
        }
        return fileName;
    }

    public static String getTempFileName(String extension) {
        long random = new Random(100000000).nextLong();
        String tmpFileName = "upload_tmp_" + DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;
        return tmpFileName;
    }
    //
    // public static File getTempFile(HttpServletRequest request,String
    // fileName){
    // String realPath =
    // request.getSession().getServletContext().getRealPath("/");
    // String tmpFileName = realPath +
    // ApplicationConstant.APP_UPLOAD_FILE_TEMP_PATH + "/" + fileName;
    // File tempFile=new File(tmpFileName);
    // return tempFile;
    // }
}
