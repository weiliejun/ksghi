package com.itech.ups.app.business.website.activityzone.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ImageHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.activityzone.application.domain.ActivityZone;
import com.itech.ups.app.business.website.activityzone.application.service.ActivityService;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * @author  huangguohu  2015-08-18
 */
@Controller
public class AddActivity extends AbstractActionParent {

    @Autowired
    private ActivityService activityservice;

    @Autowired
    private MoreSystemFileSynchronizer moreSystemFileSynce;

    @RequestMapping("/business/website/activityzone/add")
    public String add(HttpServletRequest request, Model model) {
        return "/business/website/activityzone/add";
    }

    @RequestMapping("/business/website/activityzone/add/save")
    public String save(HttpServletRequest request, ActivityZone activityzone, String dateRange, @RequestParam(value = "pictureFile", required = true) MultipartFile pictureFile) throws Exception {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        if (activityzone.getIsTimeLimit().equals("yes")) {
            if (!("").equals(dateRange)) {
                String startDate = dateRange.substring(0, 10);
                String endDate = dateRange.substring(13, 23);
                activityzone.setStartDate(startDate);
                activityzone.setEndDate(endDate);
            }
        } else if (activityzone.getIsTimeLimit().equals("no")) {
            activityzone.setStartDate("");
            activityzone.setEndDate("");
        }
        if (activityzone.getIsTimeLimit().equals("yes")) {
            Date startda = DateHelper.stringToDate(dateRange.substring(0, 10), "yyyy-mm-dd");
            Date ende = DateHelper.stringToDate(dateRange.substring(13, 23), "yyyy-mm-dd");

            Date date = new Date();
            SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
            String nowDate = matter.format(date);
            Date now = DateHelper.stringToDate(nowDate, "yyyy-mm-dd");
            // 2:预热中;3:进行中;1:已结束
            if (ende.getTime() >= now.getTime() && startda.getTime() <= now.getTime()) {
                activityzone.setStatus("3");
            } else if (ende.getTime() > now.getTime()) {
                activityzone.setStatus("2");
            } else if (startda.getTime() < now.getTime()) {
                activityzone.setStatus("1");
            }
        }
        activityzone.setWorkStatus("enable");
        activityzone.setDataStatus("valid");
        activityzone.setCreatorId(currentManager.getManager().getId());
        activityzone.setCreatorName(currentManager.getManager().getName());
        activityzone.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        activityzone.setEditorId(currentManager.getManager().getId());
        activityzone.setEditorName(currentManager.getManager().getName());
        activityzone.setEditTime(DateHelper.getYMDHMSFormatDate(new Date()));

        activityzone = activityservice.addActivity(activityzone);
        saveBusinessLog("网站广告位管理", "新增广告位信息", activityzone, request);

        if (pictureFile != null && !pictureFile.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String fileName = pictureFile.getOriginalFilename();
            String extension = StringHelper.unqualify(fileName).toLowerCase();

            int type = ImageHelper.IMAGE_UNKNOWN;
            if (extension.toLowerCase().equals("jpg") || extension.equals("jpeg")) {
                type = ImageHelper.IMAGE_JPEG;
            } else if (extension.toLowerCase().equals("png")) {
                type = ImageHelper.IMAGE_PNG;
            }
            if (type != ImageHelper.IMAGE_UNKNOWN) {
                long random = new Random(100000000).nextLong();
                fileName = DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;

                String rootPath = ApplicationConstant.APP_UPLOAD_ADVERTISE_PICTURE_FILE_PATH + "/" + activityzone.getId();
                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }
                String filePath = rootPath + "/" + fileName;
                File file = new File(realPath + filePath);

                pictureFile.transferTo(file);
                moreSystemFileSynce.syncFile(file, rootPath, fileName); // 上传到网站端
                activityzone.setActivityPicture(filePath);
                activityservice.editActivity(activityzone);
                saveBusinessLog("网站广告位管理", "新增广告位来源图片", activityzone, request);
            }
        }

        return "redirect:/business/website/activityzone/list";
    }
}
