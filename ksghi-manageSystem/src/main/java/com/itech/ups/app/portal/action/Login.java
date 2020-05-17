package com.itech.ups.app.portal.action;

import com.itech.core.components.xtree.TreeNode;
import com.itech.core.util.DateHelper;
import com.itech.core.util.IpHelper;
import com.itech.ups.app.authority.application.domain.Function;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.components.redis.RedisClient;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.portal.application.service.SecurityService;
import com.itech.ups.app.system.authority.action.function.FunctionTreeBuildHelper;
import com.itech.ups.app.system.authority.application.service.AuthorityService;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.app.system.monitor.application.service.MonitorService;
import com.itech.ups.base.ApplicationServletContextKeys;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import com.itech.ups.base.web.components.verifycode.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件名：Login.java 版本信息：v1.0 日期：2011-12-24 Copyright Mike
 * Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class Login extends AbstractActionParent {

    @Autowired
    private ManagerService service;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RedisClient redisClient;

    private List<Function> getSequentialFunctions(List<Function> allFunctions, List<Function> authorityFunctions) {
        List<Function> results = new ArrayList<Function>();
        if (authorityFunctions != null && authorityFunctions.size() > 0) {
            for (int i = 0; i < allFunctions.size(); i++) {
                Function function1 = allFunctions.get(i);
                for (int j = 0; j < authorityFunctions.size(); j++) {
                    Function function2 = authorityFunctions.get(j);
                    if (function1.getCode().equals(function2.getCode())) {
                        results.add(function1);
                        break;
                    }
                }
            }
        }
        return results;
    }

    /* 获取验证码 */
    @RequestMapping(value = {"/portal/login/verifycode/get"}, method = RequestMethod.GET)
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        VerifyCode vCode = new VerifyCode(120, 30, 4, 0);
        request.getSession().setAttribute(ApplicationSessionKeys.LOGIN_VERIFYCODE, vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    @RequestMapping(value = {"/portal/login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        model.addAttribute("clientIp", IpHelper.getClientIpAddress(request));
        return "/portal/login";
    }

    @RequestMapping(value = {"/portal/onlogin"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> onLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "code", required = true) String code, @RequestParam(value = "password", required = true) String password, @RequestParam(value = "verifyCode", required = true) String verifyCode) throws ParseException {
        Map<String, String> model = new HashMap<String, String>();
        String keyVal = code;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        String lastDate = dateNowStr.split(" ")[0] + " " + "23:59:59";
        Integer ss = daysBetween(dateNowStr, lastDate);
        Object resultObject = redisClient.getStringOperate(keyVal);
        Integer cInteger = 1;
        if (resultObject != null) {
            cInteger = (Integer) resultObject;
        }
        String flag = "false";
        String message = "";
        String exitVerifyCode = request.getSession().getAttribute(ApplicationSessionKeys.LOGIN_VERIFYCODE).toString();

        if (code == null || code.equals("") || password == null || password.equals("")) {
            flag = "false";
            message = "用户名或密码不能为空，请填写！";
        } else if (exitVerifyCode == null || !exitVerifyCode.equalsIgnoreCase(verifyCode)) {
            flag = "false";
            message = "您输入的效验码信息不对，请核对！";
        } else if (cInteger > 3) {
            flag = "false";
            message = "用户名/密码连续输错三次，请明天再试！";
        } else {
            Manager manager = service.authenticateManager(code, password);
            if (manager != null && manager.isValid()) {
                CurrentManager currentManager = new CurrentManager();
                currentManager.setManager(manager);
                currentManager.setIp(IpHelper.getClientIpAddress(request));
                currentManager.setSessionId(request.getSession().getId());
                String date = DateHelper.getYMDHMSFormatDate(new Date());
                currentManager.setLoginTime(date);
                monitorService.saveLoginLog(currentManager);

                List<Function> allFunctions = securityService.findAllFunctions();
                List<Function> authorityFunctions = securityService.findManagerAuthorityFunctions(manager);// allFunctions;allFunctions;//
                TreeNode authorityFunctionTree = new TreeNode("root", "系统功能");
                if (authorityFunctions != null) {
                    FunctionTreeBuildHelper.buildSubTree(authorityFunctionTree, getSequentialFunctions(allFunctions, authorityFunctions));
                }
                List<Role> roles = authorityService.findRoleByManagerId(manager.getId());
                currentManager.setAuthorityFunctions(authorityFunctions);
                currentManager.setAuthorityFunctionTree(authorityFunctionTree);
                currentManager.setRoles(roles);

                putManagerToCache(request, currentManager);
                flag = "true";
                cInteger = 1;
            } else if (manager != null && !manager.isValid()) {
                flag = "false";
                message = "对不起，您的账户状态为 '无效' 状态，请联系管理员！";
            } else if (manager == null && cInteger <= 3) {
                flag = "false";
                message = "用户名或密码错误，请核对！";
                cInteger++;
                redisClient.SetStringOperate(keyVal, cInteger, ss);

            }
        }
        model.put("flag", flag);
        model.put("message", message);

        return model;
    }

    public int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 1000;
        int days = Integer.parseInt(String.valueOf(between_days));
        return days;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private synchronized void putManagerToCache(HttpServletRequest request, CurrentManager currentManager) {
        Map allManagerSessions = (Map) request.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS_SESSIONS);
        if (allManagerSessions == null) {
            allManagerSessions = new HashMap();
        }

        // if
        // (allManagerSessions.containsKey(currentManager.getManager().getCode()))//
        // 如果以前登陆过，就踢出去
        // {
        // HttpSession session = (HttpSession)
        // allManagerSessions.get(currentManager.getManager().getCode());
        // if (session != null && request.getSession() != session) {
        // try {
        // CurrentManager otherManager = (CurrentManager)
        // session.getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        // if (otherManager != null) {
        // // 记录下线日志
        // monitorService.saveLogoffLog(otherManager);
        // }
        // // otherManager = null;
        // // session.invalidate();
        // } catch (Exception e) {
        // // 如果session本身失效的话，invalidate()会报错，此时吃掉此异常；
        // }
        // allManagerSessions.remove(currentManager.getManager().getCode());
        // }
        // }

        allManagerSessions.put(currentManager.getManager().getCode(), request.getSession(false));
        request.getSession().getServletContext().setAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS_SESSIONS, allManagerSessions);

        Map allManagers = (Map) request.getSession().getServletContext().getAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS);
        if (allManagers == null) {
            allManagers = new HashMap();
        }
        allManagers.put(currentManager.getManager().getCode(), currentManager);
        request.getSession().getServletContext().setAttribute(ApplicationServletContextKeys.ONLINE_MANAGERS, allManagers);
        request.getSession().setAttribute(ApplicationSessionKeys.CURRENT_MANAGER, currentManager);
    }

}
