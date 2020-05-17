package com.itech.ups.base.web.interceptor;

import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private static final Log logger = LogFactory.getLog(SecurityInterceptor.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private Date processStartTime = null;

    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex) throws java.lang.Exception {
        Date processEndTime = new Date();
        logger.info("Execute Duration：" + (processEndTime.getTime() - processStartTime.getTime()) + "ms");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        processStartTime = new Date();
        String path = request.getRequestURI() + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
        logger.info("Execute Manager Security Interceptor：" + dateFormat.format(new Date()) + " Execute Request：" + path);

        if ((!path.startsWith(request.getContextPath() + "/portal")) &&
                (!path.startsWith(request.getContextPath() + "/chinapnr")) &&
                (!path.startsWith(request.getContextPath() + "/openapi")) &&
                (!path.startsWith(request.getContextPath() + "/business/timer")) &&
                (!path.startsWith(request.getContextPath() + "/business/trustsign")) &&
                (!path.startsWith(request.getContextPath() + "/business/trade/repayment/prepayment/repaymentOneKey")) &&
                (!path.startsWith(request.getContextPath() + "/business/trade/repayment/prepayment/updateRepayInterest")) &&
                (!path.startsWith(request.getContextPath() + "/business/borrower/zjrl/loaninfo/upload")) &&
                (!path.startsWith(request.getContextPath() + "/openaccount/company/notify"))) {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            if (currentManager != null) {
                // if (!(path.startsWith(request.getContextPath() + "/index") ||
                // path.contains("/common/"))) {
                // boolean isAuthorityRequestURl = false;
                // List<Function> authorityFunctions =
                // currentManager.getAuthorityFunctions();
                // if (authorityFunctions != null && authorityFunctions.size() >
                // 0)
                // {
                // for (Function function : authorityFunctions) {
                // String url = function.getUrl();
                // if (url != null && !"".equals(url.trim())) {
                // if (url.lastIndexOf("/") > 0) {
                // url = url.substring(0, url.lastIndexOf("/"));
                // }
                // if (path.startsWith(request.getContextPath() + url)) {
                // isAuthorityRequestURl = true;
                // break;
                // }
                // }
                // }
                // }
                // if (!isAuthorityRequestURl) {
                // response.sendRedirect(request.getContextPath() +
                // ApplicationConstant.APP_PAGE_403);
                // return false;
                // }
                // }

            } else {
                response.sendRedirect(request.getContextPath() + ApplicationConstant.APP_PAGE_TIMEOUT);
                return false;
            }
        }
        return true;

    }

}
