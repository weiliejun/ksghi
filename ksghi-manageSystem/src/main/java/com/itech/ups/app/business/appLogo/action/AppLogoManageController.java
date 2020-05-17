package com.itech.ups.app.business.appLogo.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ImageHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.appLogo.application.domain.AppLogoManage;
import com.itech.ups.app.business.appLogo.application.service.AppLogoManageService;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
public class AppLogoManageController extends AbstractActionParent {
    private final Logger logger = Logger.getLogger(AppLogoManageController.class);
    @Autowired
    private AppLogoManageService service;
    @Autowired
    private MoreSystemFileSynchronizer moreSystemFileSynce;
    @Autowired
    private FileSynchronizer fileSynchronizer;
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @RequestMapping(value = {"/appLogoManage/delete"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteAppPushManageById(@RequestParam("id") String id) {
        AppLogoManage appLogoManage = new AppLogoManage();
        appLogoManage.setId(id);
        try {
            service.deleteAppLogoManage(appLogoManage);
        } catch (Exception e) {
            logger.error("/appLogoManage/delete! id:" + id, e);
        }
        return "redirect:/appLogoManage/query";
    }

    @RequestMapping(value = {"/appLogoManage/toAdd"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findAppLogoManageById(Model model, @RequestParam(value = "id", required = false) String id) {
        if (id != null) {
            AppLogoManage appLogoManage = service.findAppLogoManageById(id);
            model.addAttribute("appLogoManage", appLogoManage);
        }
        return "manage/appLogoManage/add";
    }

    @RequestMapping(value = {"/appLogoManage/findByid"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String findById(Model model, @RequestParam(value = "id", required = false) String id) {
        AppLogoManage appLogoManage = service.findAppLogoManageById(id);
        appLogoManage.setUpload(pictureServerURL + appLogoManage.getUpload());
        model.addAttribute("appLogoManage", appLogoManage);
        return "manage/appLogoManage/edit";
    }

    @RequestMapping(value = {"/appLogoManage/query"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryVersionList(Model model, HttpServletRequest request) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findAppLogoManage(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findAppLogoManageCount(params);
                }
            });
            model.addAttribute("results", items);
        } else {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    return new ArrayList<Object>();
                }

                public int getTotalRows(Limit limit) {
                    return (int) 0;
                }
            });
            model.addAttribute("results", items);
        }
        // 保存翻页信息,保存查询条件，回显参数
        savePageParams(request, params, model);
        return "manage/appLogoManage/list";
    }

    @RequestMapping("/appLogoManage/save")
    public String save(HttpServletRequest request, @RequestParam(value = "upload", required = true) MultipartFile upload, String id, String status, String logoName, String remark, String url) throws Exception {

        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        AppLogoManage appLogoManage = new AppLogoManage();
        if (status != null) {
            appLogoManage.setStatus(status);
        } else {
            appLogoManage.setStatus("unuse");
        }
        appLogoManage.setCreateId(currentManager.getManager().getId());
        appLogoManage.setCreateName(currentManager.getManager().getName());
        appLogoManage.setCreateTime(DateHelper.getYMDHMSFormatDate(new Date()));
        appLogoManage.setLogoName(logoName);
        appLogoManage.setRemark(remark);
        appLogoManage.setUrl(url);
        if (upload != null && !upload.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String fileName = upload.getOriginalFilename();
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

                String rootPath = ApplicationConstant.APP_UPLOAD_LOGO_PICTURE_FILE_PATH + "/" + id;
                File rootFile = new File(realPath + rootPath);
                if (!rootFile.exists()) {
                    FileUtils.forceMkdir(rootFile);
                }
                String filePath = rootPath + "/" + fileName;
                File file = new File(realPath + filePath);

                upload.transferTo(file);
                fileSynchronizer.syncFile(file, rootPath, fileName); // 上传到网站端
                appLogoManage.setUpload(filePath);
            }
        }
        if (!id.equals("") && id != null) {
            appLogoManage.setId(id);
            appLogoManage = service.editAppLogoManage(appLogoManage);
        } else {
            appLogoManage = service.addAppLogoManage(appLogoManage);
        }
        saveBusinessLog("AppLogo管理", "新增AppLogo图片", appLogoManage, request);
        return "redirect:/appLogoManage/query";
    }

    @RequestMapping(value = {"/appLogoManage/updateStatusById"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String updateStatusById(@RequestParam("id") String id, @RequestParam("status") String status) {

        try {
            AppLogoManage appLogoManage = new AppLogoManage();
            appLogoManage.setId(id);
            appLogoManage.setStatus(status);
            if (status.equals("used")) {
                appLogoManage.setStartTime(DateHelper.getYMDHMSFormatDate(new Date()));
            } else if (status.equals("stop")) {
                appLogoManage.setEndTime(DateHelper.getYMDHMSFormatDate(new Date()));
            }
            service.editAppLogoManage(appLogoManage);
        } catch (Exception e) {
            logger.error("/appLogoManage/updateStatusById error! id:" + id, e);
        }
        return "redirect:/appLogoManage/query";
    }
}
