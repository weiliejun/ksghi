package com.itech.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.app.product.application.domain.ProductUploadFile;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2017-03-14
 * @author  xsp
 * ===========================================================================
 *
 */

public class UploadFileHelper {

    public static String createThumb(String fileId, String realPath, String picPath, String rootPath, FileSynchronizer fileSynce) throws Exception {
        int UPLOAD_SMALL_PICTURE_MAX_WIDTH = 120;
        int UPLOAD_SMALL_PICTURE_MAX_HEIGHT = 120;
        String smallPictureFileName = fileId + "_thumbnail.jpg";
        String smallPictureFilePath = realPath + rootPath + "/" + smallPictureFileName;
        File smallPictureFile = new File(smallPictureFilePath);
        if (smallPictureFile.exists()) {
            FileUtils.forceDeleteOnExit(smallPictureFile);
        }
        BufferedImage image = ImageHelper.resizeImage(realPath + picPath, ImageHelper.IMAGE_JPEG, UPLOAD_SMALL_PICTURE_MAX_WIDTH, UPLOAD_SMALL_PICTURE_MAX_HEIGHT);
        ImageHelper.saveImage(image, smallPictureFilePath, ImageHelper.IMAGE_JPEG);

        fileSynce.syncFile(new File(smallPictureFilePath), rootPath, smallPictureFileName); // 上传到网站端

        return rootPath + "/" + smallPictureFileName;

    }

    /**
     * @param jsonStr
     * @param fileId
     * @param key
     * @return
     * @description 把包含鍵為key的某個jsonObj從jsonArray中剔除，返回剔除後的 json 數組
     * @version 1.0
     * @author 徐赛平
     * @update 2017年3月14日 上午11:32:55
     */
    public static JSONArray deleteFileForJSONStr(String jsonStr, String fileType, String key) {
        JSONArray resultJSONArray = new JSONArray();

        JSONArray jsonAry = null;
        try {
            jsonAry = JSON.parseArray(jsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (null != jsonAry) {
            for (int i = 0; i < jsonAry.size(); i++) {
                JSONObject jsonObj = null;
                try {
                    jsonObj = jsonAry.getJSONObject(i);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (null != jsonObj) {
                    if (jsonObj.toString().contains(key)) {
                        try {
                            if (!jsonObj.getString(key).equals(fileType)) {
                                resultJSONArray.add(jsonObj);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return resultJSONArray;
    }

    /**
     * @param jsonStr
     * @param fileId
     * @param key
     * @return
     * @description json数组是否包含某一文件类型（比如 身份证正面）
     * @version 1.0
     * @author 徐赛平
     * @update 2017年3月14日 上午11:37:35
     */
    public static boolean hasFileType(String jsonStr, String fileType, String key) {
        boolean resultCode = false;

        JSONArray jsonAry = null;
        try {
            jsonAry = JSON.parseArray(jsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (null != jsonAry) {
            for (int i = 0; i < jsonAry.size(); i++) {
                JSONObject jsonObj = null;
                try {
                    jsonObj = jsonAry.getJSONObject(i);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (null != jsonObj) {
                    if (jsonObj.toString().contains(key)) {
                        try {
                            if (jsonObj.getString(key).equals(fileType)) {
                                resultCode = true;
                                break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return resultCode;
    }

    /**
     * @param realPath   项目的实际路径
     * @param uploadPath
     * @param file       上传的文件
     * @param fileType   文件类型
     * @param fileSynce
     * @return
     * @throws Exception
     * @description 上传附件资料
     * @version 1.0
     * @author 徐赛平
     * @update 2017年3月14日 下午1:19:48
     */
    /*
     * public static JSONObject uploadFile(String realPath, String uploadPath,
     * MultipartFile file, String fileType, FileSynchronizer fileSynce) throws
     * Exception {
     *
     * JSONObject result = null;
     *
     * String fileName = file.getOriginalFilename(); String extension =
     * StringHelper.unqualify(fileName).toLowerCase();
     *
     * String type = "unknown"; if (extension.toLowerCase().equals("jpg") ||
     * extension.equals("jpeg")) { type = "jpg"; } else if
     * (extension.toLowerCase().equals("png")) { type = "png"; } else if
     * (extension.toLowerCase().equals("pdf")) { type = "pdf"; } if
     * (!type.equals("unknown")) {
     *
     * String id = new UploadFileHelper().generateIdentifier(); String
     * tmpFileName = fileName; fileName = id + "." + extension;
     *
     * String rootPath = uploadPath + "/" + fileType; File rootFile = new
     * File(realPath + rootPath); if (!rootFile.exists()) {
     * FileUtils.forceMkdir(rootFile); }
     *
     * String filePath = rootPath + "/" + fileName; File uploadFilePath = new
     * File(realPath + filePath);
     *
     * file.transferTo(uploadFilePath); //文字水印 2016 - 11 - 28
     * //WaterMark.pressText("微金客", realPath + filePath, "SimSun", 1, 255, 20,
     * 0, 10); //图片水印 2016 - 11 - 28 //WaterMark.pressImage(realPath+
     * "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath, 0,
     * 0); if (type.equals("pdf")) { //图片水印 2016 - 11 - 28
     * WaterMark.pdfWaterMark(realPath+
     * "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath); }
     * else { //图片水印 2016 - 11 - 28 WaterMark.pressImage(realPath+
     * "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath, 0,
     * 0); }
     *
     * UploadFile uploadFile = new UploadFile(); uploadFile.setId(id);
     * uploadFile.setName(tmpFileName); uploadFile.setPath(filePath);
     * uploadFile.setType(type); String thumbnailPath = ""; thumbnailPath =
     * createThumb(id, realPath, filePath, rootPath, fileSynce);
     * uploadFile.setThumbnail(thumbnailPath); result = (JSONObject)
     * JSON.toJSON(uploadFile);
     *
     * fileSynce.syncFile(uploadFilePath, rootPath, fileName); // 上传到网站端 }
     * return result; }
     */
    public static org.json.JSONObject uploadFile(String realPath, String uploadPath, MultipartFile file, String objId, FileSynchronizer fileSynce) throws Exception {

        org.json.JSONObject result = null;

        String fileName = file.getOriginalFilename();
        String extension = StringHelper.unqualify(fileName).toLowerCase();

        String type = "unknown";
        if (extension.toLowerCase().equals("jpg") || extension.equals("jpeg")) {
            type = "jpg";
        } else if (extension.toLowerCase().equals("png")) {
            type = "png";
        } else if (extension.toLowerCase().equals("pdf")) {
            type = "pdf";
        }
        if (!type.equals("unknown")) {

            String id = new UploadFileHelper().generateIdentifier();
            String tmpFileName = fileName;
            fileName = id + "." + extension;

            String rootPath = uploadPath + "/" + objId;
            File rootFile = new File(realPath + rootPath);
            if (!rootFile.exists()) {
                FileUtils.forceMkdir(rootFile);
            }

            String filePath = rootPath + "/" + fileName;
            File uploadFilePath = new File(realPath + filePath);

            file.transferTo(uploadFilePath);
            // 文字水印 2016 - 11 - 28
            // WaterMark.pressText("微金客", realPath + filePath, "SimSun", 1, 255,
            // 20, 0, 10);
            // 图片水印 2016 - 11 - 28
            // WaterMark.pressImage(realPath+"/assets/ui/themes/base/img/logo/logo-wjk.png",
            // realPath + filePath, 0, 0);
            if (type.equals("pdf")) {
                // 图片水印 2016 - 11 - 28
                WaterMark.pdfWaterMark(realPath + "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath);
            } else {
                // 图片水印 2016 - 11 - 28
                WaterMark.pressImage(realPath + "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath, 0, 0);
            }

            ProductUploadFile uploadFile = new ProductUploadFile();
            uploadFile.setId(id);
            uploadFile.setName(tmpFileName);
            uploadFile.setPath(filePath);
            uploadFile.setType(type);
            String thumbnailPath = "";
            if (type.equals("pdf")) {
                thumbnailPath = pdfIndexToJpg(id, realPath, filePath, rootPath, fileSynce);
            } else {
                thumbnailPath = createThumb(id, realPath, filePath, rootPath, fileSynce);
            }
            uploadFile.setThumbnail(thumbnailPath);
            result = new org.json.JSONObject(uploadFile);

            fileSynce.syncFile(uploadFilePath, rootPath, fileName); // 上传到网站端
        }
        return result;
    }


    public static org.json.JSONObject uploadFile(String realPath, String uploadPath, MultipartFile file, String objId, MoreSystemFileSynchronizer moreSystemFileSynce) throws Exception {

        org.json.JSONObject result = null;

        String fileName = file.getOriginalFilename();
        String extension = StringHelper.unqualify(fileName).toLowerCase();

        String type = "unknown";
        if (extension.toLowerCase().equals("jpg") || extension.equals("jpeg")) {
            type = "jpg";
        } else if (extension.toLowerCase().equals("png")) {
            type = "png";
        } else if (extension.toLowerCase().equals("pdf")) {
            type = "pdf";
        }
        if (!type.equals("unknown")) {

            String id = new UploadFileHelper().generateIdentifier();
            String tmpFileName = fileName;
            fileName = id + "." + extension;

            String rootPath = uploadPath + "/" + objId;
            File rootFile = new File(realPath + rootPath);
            if (!rootFile.exists()) {
                FileUtils.forceMkdir(rootFile);
            }

            String filePath = rootPath + "/" + fileName;
            File uploadFilePath = new File(realPath + filePath);
            file.transferTo(uploadFilePath);

            // 文字水印 2016 - 11 - 28
            // WaterMark.pressText("微金客", realPath + filePath, "SimSun", 1, 255,
            // 20, 0, 10);
            if (type.equals("pdf")) {
                // 图片水印 2016 - 11 - 28
                WaterMark.pdfWaterMark(realPath + "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath);
            } else {
                // 图片水印 2016 - 11 - 28
                WaterMark.pressImage(realPath + "/assets/ui/themes/base/img/logo/logo-wjk.png", realPath + filePath, 0, 0);
            }

            ProductUploadFile uploadFile = new ProductUploadFile();
            uploadFile.setId(id);
            uploadFile.setName(tmpFileName);
            uploadFile.setPath(filePath);
            uploadFile.setType(type);
            String thumbnailPath = "";
            if (type.equals("pdf")) {
                thumbnailPath = pdfIndexToJpg(id, realPath, filePath, rootPath, moreSystemFileSynce);
            } else {
                thumbnailPath = createThumb(id, realPath, filePath, rootPath, moreSystemFileSynce);
            }
            uploadFile.setThumbnail(thumbnailPath);
            result = new org.json.JSONObject(uploadFile);

            moreSystemFileSynce.syncFile(uploadFilePath, rootPath, fileName); // 上传到网站端
        }
        return result;
    }


    public static String createThumb(String fileId, String realPath, String picPath, String rootPath, MoreSystemFileSynchronizer fileSynce) throws Exception {
        int UPLOAD_SMALL_PICTURE_MAX_WIDTH = 120;
        int UPLOAD_SMALL_PICTURE_MAX_HEIGHT = 120;
        String smallPictureFileName = fileId + "_thumbnail.jpg";
        String smallPictureFilePath = realPath + rootPath + "/" + smallPictureFileName;
        File smallPictureFile = new File(smallPictureFilePath);
        if (smallPictureFile.exists()) {
            FileUtils.forceDeleteOnExit(smallPictureFile);
        }
        BufferedImage image = ImageHelper.resizeImage(realPath + picPath, ImageHelper.IMAGE_JPEG, UPLOAD_SMALL_PICTURE_MAX_WIDTH, UPLOAD_SMALL_PICTURE_MAX_HEIGHT);
        ImageHelper.saveImage(image, smallPictureFilePath, ImageHelper.IMAGE_JPEG);

        fileSynce.syncFile(new File(smallPictureFilePath), rootPath, smallPictureFileName); // 上传到网站端

        return rootPath + "/" + smallPictureFileName;

    }


    public static String pdfIndexToJpg(String fileId, String realPath, String pdfPath, String jpgDestPath, FileSynchronizer fileSynce) throws Exception {

        String jpgPath = null;

        File file = new File(realPath + pdfPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

        PDFFile pdffile = new PDFFile(buf);
        PDFPage page = pdffile.getPage(1);

        Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));
        Image img = page.getImage(rect.width, rect.height, rect, null, // null
                // for
                // the
                // ImageObserver
                true, // fill background with white
                true // block until drawing is done
        );
        BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);

        jpgPath = jpgDestPath + "/" + fileId + "_thumbnail.jpg";
        FileOutputStream out = new FileOutputStream(realPath + jpgPath);

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tag);
        param.setQuality(1f, false);// 1f是提高生成的图片质量

        encoder.setJPEGEncodeParam(param);
        encoder.encode(tag); // JPEG编码

        out.close();

        channel.close();
        raf.close();
        fileSynce.syncFile(new File(realPath + jpgPath), jpgDestPath, fileId + "_thumbnail.jpg");
        return jpgPath;
    }


    public static String pdfIndexToJpg(String fileId, String realPath, String pdfPath, String jpgDestPath, MoreSystemFileSynchronizer fileSynce) throws Exception {

        String jpgPath = null;

        File file = new File(realPath + pdfPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

        PDFFile pdffile = new PDFFile(buf);
        PDFPage page = pdffile.getPage(1);

        Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));
        Image img = page.getImage(rect.width, rect.height, rect, null, // null
                // for
                // the
                // ImageObserver
                true, // fill background with white
                true // block until drawing is done
        );
        BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);

        jpgPath = jpgDestPath + "/" + fileId + "_thumbnail.jpg";
        FileOutputStream out = new FileOutputStream(realPath + jpgPath);

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tag);
        param.setQuality(1f, false);// 1f是提高生成的图片质量

        encoder.setJPEGEncodeParam(param);
        encoder.encode(tag); // JPEG编码

        out.close();

        channel.close();
        raf.close();
        fileSynce.syncFile(new File(realPath + jpgPath), jpgDestPath, fileId + "_thumbnail.jpg");
        return jpgPath;
    }


    public static String generateIdentifier() {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = format.format(new Date().getTime()) + new Double(Math.random() * 100000).intValue();
        while (uuid.length() < 22) {
            uuid = uuid + "0";
        }
        uuid = uuid.substring(2);

        return uuid;
    }

}
