package com.itech.ups.base.web.action;

import com.alibaba.fastjson.JSON;
import com.itech.core.util.DateHelper;
import com.itech.ups.app.business.sourcecode.application.service.SourceCodeService;
import com.itech.ups.app.sourcecode.application.domain.SourceCode;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmesa.limit.Limit;
import org.jmesa.model.TableModelUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ===========================================================================
 * Copyright 2009 CHENGANG Corp. All Rights Reserved.
 * @version 2.0, 2009-7-26
 * @author  Jack Chen
 * ===========================================================================
 *
 */
public class AbstractActionParent {

    protected static final String connectJunyuanUrl = "http://wx.kingstartimes.com/QuerySecurityNetValues?token=Vu8azqQ__";
    protected static final String newConnectJunyuanUrl = "http://wx.kingstartimes.com/QuerySecurityInfo?token=Vu8azqQ__";
    protected static final int len = 4;
    private static final Log logger = LogFactory.getLog(AbstractActionParent.class);
    @Autowired
    private SourceCodeService sourceCodeService;

    public static void main(String[] args) {
        String ss = "a,b,c,";
        List<String> asList = Arrays.asList(ss.split(","));
        System.out.println(Arrays.asList(ss.split(",")));
    }

    /**
     * 记录业务日志
     *
     * @param request
     * @param
     * @param data
     */
    protected void saveBusinessLog(String functionModule, String functionDescription, Object data, HttpServletRequest request) {
        logger.info("进入记录业务日志处理");
        try {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            MonitorService monitorService = (MonitorService) context.getBean("monitorService");
            // String operationData = BeanHelper.getProperties(data);
            String operationData = new JSONObject(data).toString();
            logger.info("异常调试！");
            // if (operationData != null && operationData.length() > 1300) {
            // operationData = operationData.substring(0, 1300);
            // }
            String message = "操作人员:" + currentManager.getManager().getName() + " 操作时间:" + DateHelper.getYMDHMSFormatDate(new Date()) + " 操作功能模块：" + functionModule + " 操作功能描述:" + functionDescription + " 操作数据:" + operationData;
            logger.info(message);
            monitorService.saveBusinessLog(currentManager, functionModule, functionDescription, operationData);
        } catch (Exception e) {
            logger.error(e);
        }
        logger.info("记录业务日志处理结束！");
    }

    /**
     * jemsa记忆功能
     *
     * @param request
     * @return Map<String   ,   Object>
     * @author xsp
     * @since 2016.10.24
     */
    protected Map<String, Object> selectParams(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 读取保存的查询条件并复制
        Map parameters = (Map) request.getSession().getAttribute(request.getRequestURI());// 保存的查询条件
        if (null != parameters) {
            params.putAll(parameters);
        }
        params.put("queryString", request.getQueryString());

        int i = 0;
        if (request.getQueryString() == null && null != params.get("size")) {
            i = new Integer(params.get("size").toString()).intValue();
        }
        Map parameterMap = request.getParameterMap();
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            String[] paraValues = request.getParameterValues(paraName);
            if (paraValues != null && paraValues.length >= 1) {
                String tempValue = "";
                if (paraValues.length == 1) {
                    tempValue = request.getParameter(paraName).trim();
                } else { // paraValues.length > 1
                    for (String v : paraValues) {
                        if (StringUtils.isNotBlank(v) && !"null".equalsIgnoreCase(v)) {
                            tempValue += v + ",";
                        }
                    }
                }

                if (StringUtils.isNotBlank(tempValue) && !"null".equalsIgnoreCase(tempValue)) {
                    // 【userClassification -用户分类】特殊处理
                    if ("userClassification".equals(paraName)) {
                        userClassification(params, tempValue);
                    } else {
                        // 复选框 特殊处理
                        if (tempValue.endsWith(",")) {
                            List checkValues = Arrays.asList(tempValue.split(","));
                            // tempValue =
                            // tempValue.substring(0,tempValue.length()-1);
                            params.put(paraName, checkValues);
                        } else {
                            params.put(paraName, tempValue);
                        }
                    }
                } else {
                    if (params.containsKey(paraName)) {
                        params.remove(paraName);
                        // 删除用户分类中的字段
                        if ("userClassification".equals(paraName)) {
                            remove_UserClassification_Key(params);
                        }
                    }
                }
                // 每页显示页数
                if (!"maxRows".equals(paraName)) {
                    i++;
                }
            } else {
                if (params.containsKey(paraName)) {
                    params.remove(paraName);
                    // 删除用户分类中的字段
                    if ("userClassification".equals(paraName)) {
                        remove_UserClassification_Key(params);
                    }
                }
            }
        }
        params.put("size", i);

        return params;
    }

    /**
     * easyui记忆功能
     *
     * @param request
     * @return Map<String   ,   Object>
     * @author xsp
     * @since 2016.10.24
     */
    protected Map<String, Object> selectParamsEasyui(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 读取保存的查询条件并复制
        Map parameters = (Map) request.getSession().getAttribute(request.getRequestURI());// 保存的查询条件
        if (null != parameters) {
            params.putAll(parameters);
        }
        int i = 0;
        Map parameterMap = request.getParameterMap();
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            String paraValue = request.getParameter(paraName).trim();
            if (StringUtils.isNotBlank(paraValue) && !"null".equalsIgnoreCase(paraValue)) {
                // 【userClassification -用户分类】特殊处理
                if ("userClassification[]".equals(paraName)) {
                    String[] paraValues = request.getParameterValues(paraName);
                    String tempValue = "";
                    if (paraValues.length == 1) {
                        tempValue = paraValue;

                    } else if (paraValues.length > 1) {
                        for (String v : paraValues) {
                            tempValue += v + ",";
                        }
                    }
                    params.put("userClassification", tempValue);
                    userClassification(params, tempValue);
                } else {
                    params.put(paraName, paraValue);
                }

                if (!"rows".equals(paraName) && !"page".equals(paraName) && !"rowStart".equals(paraName) && !"rowEnd".equals(paraName)) {
                    i++;
                }

            } else {
                if (params.containsKey(paraName)) {
                    params.remove(paraName);
                    // 删除用户分类中的字段
                    if ("userClassification".equals(paraName)) {
                        remove_UserClassification_Key(params);
                    }
                }
            }
        }
        params.put("size", i);
        return params;
    }

    protected void setPromptInfo(String promptInfo, HttpServletRequest request) {
        request.getSession().setAttribute(ApplicationSessionKeys.PROMPT_INFO, promptInfo);
    }

    /**
     * 功能：删除用户分类查询条件 [复选查询]
     *
     * @param params
     */
    public void remove_UserClassification_Key(Map<String, Object> params) {

        // 内部或普通用户推荐
        if (params.containsKey("labelRecommendFlag")) {
            params.remove("labelRecommendFlag");
        }
        if (params.containsKey("labelRecommend")) {
            params.remove("labelRecommend");
        }

        // 内部或普通用户
        if (params.containsKey("labelRegisterFlag")) {
            params.remove("labelRegisterFlag");
        }
        if (params.containsKey("labelRegister")) {
            params.remove("labelRegister");
        }

        // 机构用户推荐
        if (params.containsKey("orgRecommendFlag")) {
            params.remove("orgRecommendFlag");
        }
        if (params.containsKey("orgRecommend")) {
            params.remove("orgRecommend");
        }

        // 机构用户
        if (params.containsKey("orgRegisterFlag")) {
            params.remove("orgRegisterFlag");
        }
        if (params.containsKey("orgRegister")) {
            params.remove("orgRegister");
        }

        //
        if (params.containsKey("userClassificationFlag")) {
            params.remove("userClassificationFlag");
        }

    }

    /**
     * 用户分类
     *
     * @param
     * @return Map<String   ,   Object>
     * @author xsp
     * @since 2016.10.24
     */
    protected Map<String, Object> userClassification(Map<String, Object> params, String userClassification) {
        String userClassificationFlag = "false";
        if (null != userClassification && !"".equalsIgnoreCase(userClassification)) {
            userClassificationFlag = "true";
            String[] conditionArr = userClassification.replace("'", "").split(",");
            String labelRecommendFlag = "false";
            List<String> labelRecommend = new ArrayList<String>();// 内部或普通用户推荐
            String labelRegisterFlag = "false";
            List<String> labelRegister = new ArrayList<String>();// 内部或普通用户
            String orgRecommendFlag = "false";
            List<String> orgRecommend = new ArrayList<String>();// 机构用户推荐
            String orgRegisterFlag = "false";
            List<String> orgRegister = new ArrayList<String>();// 机构用户
            Pattern pattern = Pattern.compile("^([a-zA-Z0-9]+)\\-([a-zA-Z0-9]+)\\-([a-zA-Z0-9]+)$");
            for (String conditionStr : conditionArr) {
                Matcher matcher = pattern.matcher(conditionStr);
                while (matcher.find()) {// 如果找到 开始替换
                    if ("label".equals(matcher.group(1))) {
                        if ("register".equals(matcher.group(3))) {
                            labelRegisterFlag = "true";
                            labelRegister.add(matcher.group(2));
                        } else if ("recommend".equals(matcher.group(3))) {
                            labelRecommendFlag = "true";
                            labelRecommend.add(matcher.group(2));
                        }
                    } else if ("org".equals(matcher.group(1))) {
                        if ("register".equals(matcher.group(3))) {
                            orgRegisterFlag = "true";
                            orgRegister.add(matcher.group(2));
                        } else if ("recommend".equals(matcher.group(3))) {
                            orgRecommendFlag = "true";
                            orgRecommend.add(matcher.group(2));
                        }
                    }
                }

            }
            params.put("labelRecommendFlag", labelRecommendFlag);
            params.put("labelRecommend", labelRecommend);

            params.put("labelRegisterFlag", labelRegisterFlag);
            params.put("labelRegister", labelRegister);

            params.put("orgRecommendFlag", orgRecommendFlag);
            params.put("orgRecommend", orgRecommend);

            params.put("orgRegisterFlag", orgRegisterFlag);
            params.put("orgRegister", orgRegister);

        }
        params.put("userClassificationFlag", userClassificationFlag);
        params.put("userClassification", userClassification);

        return params;
    }

    /**
     * @param limit
     * @param params
     * @return
     * @description 计算分页信息
     * @version 1.0
     * @update 2017年6月20日 下午5:45:33
     */
    public Map<String, Object> computingPage(Limit limit, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (params.get("maxRows") != null) {
            limit.getRowSelect().setMaxRows(new Integer(params.get("maxRows").toString()));
        }
        int rowStart = limit.getRowSelect().getRowStart();
        int rowEnd = limit.getRowSelect().getRowEnd();
        if (params.get("queryString") == null) {
            if (params.get("page") != null) {
                limit.getRowSelect().setPage(new Integer(params.get("page").toString()));
            }
            if (params.get("rowStart") != null) {
                rowStart = new Integer(params.get("rowStart").toString()).intValue();
            }
            if (params.get("rowEnd") != null) {
                // 数据改变前数据总数
                int oldTotalRows = new Integer(params.get("totalRows").toString()).intValue();
                // 数据改变后数据总数
                int newTotalRows = limit.getRowSelect().getTotalRows();
                // 页面展示最大数
                int maxRows = new Integer(params.get("maxRows").toString()).intValue();
                // 当前页
                int currentPage = new Integer(params.get("page").toString());
                rowEnd = new Integer(params.get("rowEnd").toString()).intValue();
                if (newTotalRows > oldTotalRows) {
                    // 新增数据
                    // 当前页 * 每页最多显示条数 >= 增加记录后的总条数时候，可显示条数+ 新增记录条数
                    // 否则说明当前页已显示最大条数
                    if (currentPage * maxRows >= newTotalRows) {
                        rowEnd = rowEnd + newTotalRows - oldTotalRows;
                    }
                }
            }
        }
        map.put("rowStart", rowStart);
        map.put("rowEnd", rowEnd);
        return map;
    }

    /**
     * @param request
     * @param params
     * @param model
     * @description 保存分页和查询条件
     * @version 1.0
     * @update 2017年6月20日 下午5:46:04
     */
    public void savePageParams(HttpServletRequest request, Map<String, Object> params, Model model) {
        // 保存翻页信息
        Limit limit = (Limit) request.getAttribute("grid" + TableModelUtils.LIMIT_ATTR);
        params.put("page", limit.getRowSelect().getPage());
        params.put("rowStart", limit.getRowSelect().getRowStart());
        params.put("rowEnd", limit.getRowSelect().getRowEnd());
        params.put("maxRows", limit.getRowSelect().getMaxRows());
        params.put("totalRows", limit.getRowSelect().getTotalRows());
        // 保存查询条件，回显参数
        request.getSession().setAttribute(request.getRequestURI(), params);
        model.addAllAttributes((Map<String, Object>) request.getSession().getAttribute(request.getRequestURI()));
    }

    /**
     * @return
     */
    public List<SourceCode> getSourceCodesByParam() {
        return sourceCodeService.selectSourceCodesByParam(new HashedMap(), 0, 0);
    }

    /**
     * 获取表单上传的文件
     * 配置文件中如果去除了springboot项目默认的多部件解析器 依赖commons-fileUpload包
     * 使用springMvc中的CommonsMultipartResolver进行解析
     * 将传递HttpServletRequest或者ShiroHttpServletRequest解析成为MultipartHttpServletRequest并返回表单中所有的MultipartFile
     *
     * @return
     * @Author 李洪斌
     * @Description //TODO
     * @Date 2019/7/23 19:09
     * @Param
     **/
    public Map<String, MultipartFile> getFormMultipartFile(HttpServletRequest request) {
        //将当前上下文初始化给  CommonsMultipartResolver （多部分解析器）
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        //检查form中是否有enctype="multipart/form-data"
        if (resolver.isMultipart(request)) {
            return multipartRequest.getFileMap();
        }
        return null;
    }
}
