package com.itech.ups.app.business.website.advertise.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ImageHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.advertise.application.domain.Advertise;
import com.itech.ups.app.business.website.advertise.application.service.AdvertiseService;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Random;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-5-5
 * @author  zhaoyl
 * ===========================================================================
 *
 */
@Controller
public class EditAdvertise extends AbstractActionParent {

    @Autowired
    private AdvertiseService service;

    @Autowired
    private MoreSystemFileSynchronizer moreSystemFileSynce;

    // 新增图片服务器访问地址
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @RequestMapping("/business/website/advertise/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {

        Advertise advertise = service.findAdvertise(id);
        model.addAttribute("advertise", advertise);
        // 获取图片地址WjkPictureSystem
        model.addAttribute("pictureServerURL", pictureServerURL);

        return "business/website/advertise/edit";
    }

    @RequestMapping("/business/website/advertise/edit/save")
    public String save(HttpServletRequest request, Advertise advertise,
            /* @RequestParam(value = "pictureFile", required = true) */MultipartFile pictureFile, MultipartFile videoFile) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        advertise.setEditorId(currentManager.getManager().getId());
        advertise.setEditorName(currentManager.getManager().getName());
        advertise.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        String realPath = request.getSession().getServletContext().getRealPath("/");
        if (pictureFile != null && !pictureFile.isEmpty()) {

            String fileName = pictureFile.getOriginalFilename();
            String extension = StringHelper.unqualify(fileName).toLowerCase();
            int type = ImageHelper.IMAGE_UNKNOWN;
            if (extension.equals("jpg") || extension.equals("jpeg")) {
                type = ImageHelper.IMAGE_JPEG;
            } else if (extension.equals("png")) {
                type = ImageHelper.IMAGE_PNG;
            }
            if (type != ImageHelper.IMAGE_UNKNOWN) {
                long random = new Random(100000000).nextLong();
                fileName = DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;

                String rootPath = ApplicationConstant.APP_UPLOAD_ADVERTISE_PICTURE_FILE_PATH + "/" + advertise.getId();
                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    rootFile.mkdirs();
                }
                String filePath = rootPath + "/" + fileName;
                File file = new File(realPath + filePath);

                pictureFile.transferTo(file);
                moreSystemFileSynce.syncFile(file, rootPath, fileName); // 上传到网站端
                advertise.setAdvertisePicture(filePath);
            }
        }

        if (videoFile != null && !videoFile.isEmpty()) {
            String videoName = videoFile.getOriginalFilename();
            String extension = StringHelper.unqualify(videoName).toLowerCase();

            if (extension.toLowerCase().equals("asx") || extension.equals("asf") || extension.toLowerCase().equals("mpg") || extension.toLowerCase().equals("3gp") || extension.equals("mp4") || extension.toLowerCase().equals("avi") || extension.toLowerCase().equals("flv")) {
                String rootPath = ApplicationConstant.APP_UPLOAD_ADVERTISE_VIDEO_FILE_PATH + "/" + advertise.getId();

                videoName = DateHelper.getCurrentDate().getTime() + "_" + new Random(100000000).nextLong() + "." + extension;

                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }
                String filePath = rootPath + "/" + videoName;
                File file = new File(realPath + filePath);

                videoFile.transferTo(file);
                moreSystemFileSynce.syncFile(file, rootPath, videoName); // 上传到网站端
                advertise.setAdvertiseVideoUrl(filePath);
                saveBusinessLog("网站广告位管理", "新增广告位来源视频", advertise, request);
            }
        }

        service.editAdvertise(advertise);
        saveBusinessLog("网站广告位管理", "修改广告位信息", advertise, request);

        return "redirect:/business/website/advertise/list";
    }
}