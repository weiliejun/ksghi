package com.itech.ups.app.business.website.news.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ImageHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.website.news.application.service.NewsService;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.news.application.domain.News;
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
import org.springframework.web.bind.annotation.RequestParam;
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
 * @version 1.0, 2014-4-5
 * @author  zqs
 * ===========================================================================
 *
 */
@Controller
public class EditNews extends AbstractActionParent {

    @Autowired
    private NewsService service;

    @Autowired
    private FileSynchronizer fileSynce;
    // 新增图片服务器访问地址
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @Autowired
    private FileSynchronizer moreSystemFileSynce;

    @RequestMapping("/business/website/news/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {

        News news = service.findNews(id);
        model.addAttribute("news", news);
        // 获取图片地址WjkPictureSystem
        model.addAttribute("pictureServerURL", pictureServerURL);

        return "business/website/news/edit";
    }

    @RequestMapping("/business/website/news/edit/save")
    public String save(HttpServletRequest request, News news, @RequestParam(value = "sourceLogoFile", required = true) MultipartFile sourceLogoFile, MultipartFile videoFile) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);

        News newsTmp = service.findNews(news.getId());

        if (news.getPublishStatus().equals("issue") && !newsTmp.getPublishStatus().equals(news.getPublishStatus())) {
            news.setPublishTime(DateHelper.getYMDHMSFormatDate(new Date()));
            news.setPublisherId(currentManager.getManager().getId());
            news.setPublisherName(currentManager.getManager().getName());
        }

        news.setEditorId(currentManager.getManager().getId());
        news.setEditorName(currentManager.getManager().getName());
        news.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        String realPath = request.getSession().getServletContext().getRealPath("/");
        if (sourceLogoFile != null && !sourceLogoFile.isEmpty()) {

            String fileName = sourceLogoFile.getOriginalFilename();
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
                String rootPath = ApplicationConstant.APP_UPLOAD_NEWS_SOURCE_LOGO_FILE_PATH + "/" + news.getId();
                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    rootFile.mkdirs();
                }
                String filePath = rootPath + "/" + fileName;
                File file = new File(realPath + filePath);

                sourceLogoFile.transferTo(file);
                fileSynce.syncFile(file, rootPath, fileName); // 上传到网站端
                news.setSourceLogo(filePath);
            }
        }
        if (videoFile != null && !videoFile.isEmpty()) {
            String videoName = videoFile.getOriginalFilename();
            String extension = StringHelper.unqualify(videoName).toLowerCase();

            if (extension.toLowerCase().equals("asx") || extension.equals("asf") || extension.toLowerCase().equals("mpg") || extension.toLowerCase().equals("3gp") || extension.equals("mp4") || extension.toLowerCase().equals("avi") || extension.toLowerCase().equals("flv")) {
                String rootPath = ApplicationConstant.APP_UPLOAD_NEWS_SOURCE_LOGO_VIDEO + "/" + news.getId();

                videoName = DateHelper.getCurrentDate().getTime() + "_" + new Random(100000000).nextLong() + "." + extension;

                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }

                String filePath = rootPath + "/" + videoName;
                File file = new File(realPath + filePath);

                videoFile.transferTo(file);
                moreSystemFileSynce.syncFile(file, rootPath, videoName); // 上传到网站端
                news.setVideoUrl(filePath);
            }
        }
        service.editNews(news);
        saveBusinessLog("媒体报道管理", "修改媒体报道信息", news, request);

        return "redirect:/business/website/news/list";
    }
}