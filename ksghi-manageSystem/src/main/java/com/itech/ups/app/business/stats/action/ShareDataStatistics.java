package com.itech.ups.app.business.stats.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.ups.app.business.stats.application.service.ShareDataStatisticsService;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.log4j.Logger;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class ShareDataStatistics extends AbstractActionParent {
    private Logger logger = Logger.getLogger(ShareDataStatistics.class);
    private String[] pTitle = {"时间:CREATE_TIME:15:center", "复制内容按钮点击数:LINK:20:center", "微信点击数:WEIXIN:20:center", "新浪微博点击数:SINABLOG:15:left", "QQ点击数:QQ:10:center", "腾讯微博点击数:TENCENTBLOG:15:center", "Qzone点击数:QZONE:15:center", "短信点击数:SMS:15:center", "邮件点击数:YOUJIAN:20:left", "注册时手机号点击数:REGMOBILE:25:center", "注册时输入邀请码点击数:REGRECOMMEND:25:center"};
    @Autowired
    private ShareDataStatisticsService sharedataService;

    /*
     * 导出excel 2014-12-09 苏冰雪
     */
    @RequestMapping("/business/stats/sharedata/list/exportExcel")
    public String fundRecordsExportExcel(HttpServletRequest request, HttpServletResponse response, Model model, String dateRange) {
        final Map<String, Object> params = selectParams(request);

        List<HashMap> result0 = (List<HashMap>) sharedataService.findSharedata(params, 0, (int) sharedataService.findSharedataTotalCount(params));

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : result0) {
            HashMap temp = new HashMap();
            temp.put("SINABLOG", map.get("SINABLOG") == null ? "" : map.get("SINABLOG").toString());
            temp.put("QZONE", map.get("QZONE") == null ? "" : map.get("QZONE").toString());
            temp.put("LINK", map.get("LINK") == null ? "" : map.get("LINK").toString());
            temp.put("CREATE_TIME", map.get("CREATE_TIME").toString());
            temp.put("REGMOBILE", map.get("REGMOBILE") == null ? "" : map.get("REGMOBILE").toString());
            temp.put("QQ", map.get("QQ") == null ? "" : map.get("QQ").toString());
            temp.put("WEIXIN", map.get("WEIXIN") == null ? "" : map.get("WEIXIN").toString());
            temp.put("REGRECOMMEND", map.get("REGRECOMMEND") == null ? "" : map.get("REGRECOMMEND").toString());
            temp.put("SMS", map.get("SMS") == null ? "" : map.get("SMS").toString());
            temp.put("YOUJIAN", map.get("YOUJIAN") == null ? "" : map.get("YOUJIAN").toString());
            temp.put("TENCENTBLOG", map.get("TENCENTBLOG") == null ? "" : map.get("TENCENTBLOG").toString());
            result.add(temp);
        }

        String sheeTTitle = "数据分享统计";
        String fileName = "数据分享统计" + "_" + DateHelper.getYMDFormatDate(DateHelper.getCurrentDate());
        ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        return null;
    }

    /*
     * , String name, String roleType, String dateRange 数据分享统计 2014-12-08 下午 苏冰雪
     */
    @RequestMapping("/business/stats/sharedata/list")
    public String userRecharge(HttpServletRequest request, Model model) {

        final Map<String, Object> params = selectParams(request);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return sharedataService.findSharedata(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) sharedataService.findSharedataTotalCount(params);
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

        return "/business/stats/shareDataStatistics";
    }
}
