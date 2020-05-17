package com.itech.ups.base.web.filter;

import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义会话Cookie属性
 *
 * @author yongboy
 * @version 1.0
 * @date 2011-1-19
 */
@WebFilter(dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC}, urlPatterns = {"/*"})
public class CustomCookieFilter implements Filter {
    private static final Log log = LogFactory.getLog(CustomCookieFilter.class);
    private static final String CUSTOM_SESSION_ID = "JSESSIONID";
    private static final String HTTP_ONLY = "HttpOnly";
    private static final String SET_COOKIE = "SET-COOKIE";
    protected List<String> excludeURL = new ArrayList<String>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) rep;
        System.out.println(excludeURL);
        // if (response.containsHeader(SET_COOKIE)) {
        log.info("haha,we have one new user visit the site ...");

        String sessionId = request.getSession().getId();
        // String cookieValue = CUSTOM_SESSION_ID + "=" + sessionId + ";Path=" +
        // request.getContextPath() + ";" + HTTP_ONLY;
        String cookieValue = CUSTOM_SESSION_ID + "=" + sessionId + ";Path=/;" + HTTP_ONLY;
        log.info(SET_COOKIE + ":" + cookieValue);

        // ajax无法取得数据，被浏览器拦截了
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, If-Modified-Since");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Credentials", "true");// 允许跨域设置cookie

        response.setHeader(SET_COOKIE, cookieValue);
        // }

        String uri = ((HttpServletRequest) request).getRequestURI();
        if (uri.indexOf("/monitoring/console") != -1) {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            if (currentManager == null) {
                response.sendRedirect(request.getContextPath() + ApplicationConstant.APP_PAGE_TIMEOUT);
                return;
            }
        }
        for (String url : excludeURL) {
            if (request.getServletPath().indexOf(url) != -1) {
                chain.doFilter(request, response);
                return;
            }
        }
        chain.doFilter(new XssHttpServletRequestWrapper(request), response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        excludeURL.add("/business/website/bulletin/edit/save");
        excludeURL.add("/business/website/bulletin/add/save");
        excludeURL.add("/business/website/news/add/save");
        excludeURL.add("/business/website/news/edit/save");
        excludeURL.add("/business/website/problem/save");
        excludeURL.add("/business/website/problem/edit/save");
        excludeURL.add("/business/product/input/edit/save");
        excludeURL.add("/business/product/input/editproductborrower/save");
        excludeURL.add("/business/product/input/consultantdynamics/save");
        excludeURL.add("/business/insurance/input/updatesave");
        excludeURL.add("/business/insurance/input/save");
        excludeURL.add("/business/insurance/audit/updatesave");
//		excludeURL.add("/business/ccxbd/saveImportCcxbd");
    }
}
