package com.itech.ups.app.business.website.activityzone.action;

import com.itech.core.util.CodeHelper;
import com.itech.ups.app.activityzone.application.domain.ActivityZone;
import com.itech.ups.app.business.website.activityzone.application.service.ActivityService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*
 * @author  huangguohu  2015-08-18
 */
@Controller
public class ActivityZoneList extends AbstractActionParent {

    @Autowired
    private ActivityService activityservice;

    @Value("${activity.previewUrl}")
    private String previewUrl;

    @RequestMapping("/business/website/activityzone/list")
    public String list(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return activityservice.findActivityList(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) activityservice.findActivityTotalCount(params);
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
        // ////

        return "/business/website/activityzone/list";
    }

    @RequestMapping(value = {"/business/website/activityzone/{workStatus}/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String updateActivityZoneWorkStatus(HttpServletRequest request, @PathVariable String workStatus, @PathVariable String id) {

        ActivityZone activityZone = activityservice.findActivityById(id);
        activityZone.setWorkStatus(workStatus);
        activityservice.editActivity(activityZone);
        saveBusinessLog("活动专区管理", CodeHelper.getValueByCode("advertise.status", workStatus) + "活动信息", activityZone, request);

        return "redirect:/business/website/activityzone/list";

    }

}
