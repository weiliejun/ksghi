package com.itech.ups.app.business.stats.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ExpExcelFSHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.stats.application.service.OperatorDataService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

@Controller
public class OperatorData extends AbstractActionParent {

    private final String[] pTitle = {"指标编码:indexCode:20:center", "指标名称:indexName:30:center", "填报内容:content:30:center", "填报说明:desc:30:center"};
    private final String[] enterprisePTitle = {"指标编码:indexCode:20:center", "指标名称:indexName:30:center", "频度:frequency:30:center", "金额(数量):amount:30:center", "填报说明:desc:30:center"};
    @Autowired
    private OperatorDataService operatorDataService;

    /**
     * @param request
     * @param model
     * @return
     * @description 互联网金融信息披露数据统计列表
     * @version 1.0
     * @author 张可乐
     * @update 2017-9-21 下午2:47:01
     */
    @RequestMapping(value = "/business/stats/operatordata/disclosure/list")
    public String disclosure(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);
        // 查询条件中日期处理
        String statsDate = "";
        if (params.get("statsDate") != null && StringHelper.isNotEmpty(params.get("statsDate").toString())) {
            statsDate = params.get("statsDate").toString();
            if (statsDate.compareTo(DateHelper.getYMDFormatDate(new Date())) > 0) {
                statsDate = DateHelper.getYMDFormatDate(new Date());
            } else if (statsDate.compareTo(DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"))) < 0) {
                statsDate = DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"));
            }
        } else {
            statsDate = DateHelper.thisBeforDay();
        }
        statsDate = statsDate.substring(0, 7);
        params.put("statsDate", statsDate);
        params.put("monthEndDate", DateHelper.getMonthEndDate(statsDate));
        // 默认显示50条
        params.put("maxRows", 50);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return operatorDataService.selectFinancialDisclosure(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) operatorDataService.selectFinancialDisclosureTotalCount(params);
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
        return "/business/stats/disclosure";
    }

    /*
     * 导出excel
     */
    @RequestMapping("/business/stats/operatordata/disclosure/list/exportExcel")
    public String disclosureExportExcel(HttpServletRequest request, HttpServletResponse response, String activateName, String activateCode, String activityLotteryCode, String type, String name, String mobile, String status) {
        final Map<String, Object> params = selectParams(request);
        // 查询条件中日期处理
        String statsDate = "";
        if (params.get("statsDate") != null && StringHelper.isNotEmpty(params.get("statsDate").toString())) {
            statsDate = params.get("statsDate").toString();
            if (statsDate.compareTo(DateHelper.getYMDFormatDate(new Date())) > 0) {
                statsDate = DateHelper.getYMDFormatDate(new Date());
            } else if (statsDate.compareTo(DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"))) < 0) {
                statsDate = DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"));
            }
        } else {
            statsDate = DateHelper.thisBeforDay();
        }
        statsDate = statsDate.substring(0, 7);
        params.put("monthEndDate", DateHelper.getMonthEndDate(statsDate));
        List<Map<String, Object>> result0 = (List<Map<String, Object>>) operatorDataService.selectFinancialDisclosure(params, 0, (int) operatorDataService.selectFinancialDisclosureTotalCount(params));

        saveExcel(request, response, statsDate, result0, "disclosure");
        return null;
    }

    /**
     * @param request
     * @param model
     * @return
     * @description 企业数据报送统计列表
     * @version 1.0
     * @author 张可乐
     * @update 2017-9-21 下午2:47:41
     */
    @RequestMapping(value = "/business/stats/operatordata/enterprise/list")
    public String activitylottery(HttpServletRequest request, Model model) {
        final Map<String, Object> params = selectParams(request);
        // 查询条件中日期处理
        String statsDate = "";
        if (params.get("statsDate") != null && StringHelper.isNotEmpty(params.get("statsDate").toString())) {
            statsDate = params.get("statsDate").toString();
            if (statsDate.compareTo(DateHelper.getYMDFormatDate(new Date())) > 0) {
                statsDate = DateHelper.getYMDFormatDate(new Date());
            } else if (statsDate.compareTo(DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"))) < 0) {
                statsDate = DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"));
            }
        } else {
            statsDate = DateHelper.thisBeforDay();
        }
        statsDate = statsDate.substring(0, 7);
        params.put("statsDate", statsDate);
        params.put("monthStartDate", DateHelper.getMonthStartDate(statsDate));
        params.put("monthEndDate", DateHelper.getMonthEndDate(statsDate));
        params.put("yearStartDate", DateHelper.getYearStartDate(statsDate));
        // 默认显示50条
        params.put("maxRows", 50);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return operatorDataService.selectenterpriseData(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) operatorDataService.selectenterpriseDataTotalCount(params);
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
        return "/business/stats/enterprise";
    }

    /*
     * 导出excel
     */
    @RequestMapping("/business/stats/operatordata/enterprise/list/exportExcel")
    public String enterpriseExportExcel(HttpServletRequest request, HttpServletResponse response) {
        final Map<String, Object> params = selectParams(request);
        // 查询条件中日期处理
        String statsDate = "";
        if (params.get("statsDate") != null && StringHelper.isNotEmpty(params.get("statsDate").toString())) {
            statsDate = params.get("statsDate").toString();
            if (statsDate.compareTo(DateHelper.getYMDFormatDate(new Date())) > 0) {
                statsDate = DateHelper.getYMDFormatDate(new Date());
            } else if (statsDate.compareTo(DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"))) < 0) {
                statsDate = DateHelper.getYMDFormatDate(DateHelper.stringToDate("2014-08-08", "yyyy-MM-dd"));
            }
        } else {
            statsDate = DateHelper.thisBeforDay();
        }
        params.put("monthStartDate", DateHelper.getMonthStartDate(statsDate));
        params.put("monthEndDate", DateHelper.getMonthEndDate(statsDate));
        params.put("yearStartDate", DateHelper.getYearStartDate(statsDate));
        List<Map<String, Object>> result0 = (List<Map<String, Object>>) operatorDataService.selectenterpriseData(params, 0, (int) operatorDataService.selectenterpriseDataTotalCount(params));
        saveExcel(request, response, statsDate, result0, "enterprise");
        return null;
    }

    public void saveExcel(HttpServletRequest request, HttpServletResponse response, String statsDate, List<Map<String, Object>> result0, String type) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if ("enterprise".equals(type)) {
            for (Map<String, Object> map : result0) {
                HashMap temp = new HashMap();
                temp.put("indexCode", map.get("indexCode") == null ? "" : map.get("indexCode").toString());
                temp.put("indexName", map.get("indexName") == null ? "" : map.get("indexName").toString());
                temp.put("frequency", map.get("frequency") == null ? "" : map.get("frequency").toString());
                temp.put("amount", map.get("amount") == null ? "" : map.get("amount").toString());
                temp.put("desc", map.get("desc") == null ? "" : map.get("desc").toString());
                result.add(temp);
            }
            String sheeTTitle = "企业数据报送_" + statsDate;
            String fileName = "企业数据报送_" + statsDate;
            ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", enterprisePTitle, result, null);
        }
        if ("disclosure".equals(type)) {
            for (Map<String, Object> map : result0) {
                HashMap temp = new HashMap();
                temp.put("indexCode", map.get("indexCode") == null ? "" : map.get("indexCode").toString());
                temp.put("indexName", map.get("indexName") == null ? "" : map.get("indexName").toString());
                temp.put("content", map.get("content") == null ? "" : map.get("content").toString());
                temp.put("desc", map.get("desc") == null ? "" : map.get("desc").toString());
                result.add(temp);
            }
            Calendar ca = DateHelper.getYMDFormatCalendar(statsDate + "-01");
			/*int month = ca.get(Calendar.MONTH) + 1;
			String sheeTTitle = "互金信息披露报数" + month + "月";
			String fileName = "互金信息披露报数" + month + "月";*/
            String sheeTTitle = "互金信息披露报数_" + statsDate;
            String fileName = "互金信息披露报数_" + statsDate;
            ExpExcelFSHelper.expExcel(request, response, fileName, sheeTTitle, "", pTitle, result, null);
        }
    }

    /*
     * 下载excel
     */
    @RequestMapping("/business/stats/operatordata/download/{fileName}")
    public String enterpriseExportExcel(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName) {
        Calendar a = Calendar.getInstance();
        a.add(Calendar.MONTH, -1);
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String basePath = realPath + ApplicationConstant.DOWNLOAD_EXCEL_FILE_PATH;
        String exportFileName = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            //String fileName = "";
			/*if ("enterprise".equals(type)) {
				fileName = "企业数据报送_" + statsDate;
			} else {
				int month = a.get(Calendar.MONTH) + 1;
				fileName = "互金信息披露报数" + month + "月";
			}*/
            in = new FileInputStream(basePath + "/" + fileName + ".xls");
            exportFileName = new String((fileName + ".xls").getBytes("GBK"), "iso-8859-1");
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=GBK");
            response.setContentType("application/msexcel");// 设定输出类型
            response.setHeader("Content-Disposition", "attachment; filename=" + exportFileName);
            out = response.getOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
