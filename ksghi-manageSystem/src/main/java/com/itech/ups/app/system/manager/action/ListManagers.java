package com.itech.ups.app.system.manager.action;

import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.components.redis.RedisClient;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 版本信息：v1.0 日期：2011-12-19 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */
@Controller
public class ListManagers extends AbstractActionParent {
    @Autowired
    private ManagerService service;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/system/manager/list")
    public String list(HttpServletRequest request, Model model) {
        CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
        Manager managers = currentManager.getManager();
        if (managers != null) {

            String ssString = ApplicationConstant.PLATFORM_SUPER_ADMIN_CODE;
            if (ssString.equals(managers.getCode())) {
                request.setAttribute("codeName", true);
            } else {
                request.setAttribute("codeName", false);
            }

        }
        final Map<String, Object> params = selectParams(request);
        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return service.findManagers(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return (int) service.findManagersTotalCount(params);
                }
            });

            if (items != null && items.size() > 0) {
                List results = new ArrayList();
                Iterator it = items.iterator();
                while (it.hasNext()) {
                    Manager manager = (Manager) it.next();
                    String roles = "";
                    List roleList = service.findManagerRoles(manager.getId());
                    if (roleList != null && roleList.size() > 0) {
                        for (int k = 0; k < roleList.size(); k++) {
                            Role role = (Role) roleList.get(k);
                            roles = role.getName() + "; " + roles;
                        }
                    }
                    Object resultObject = redisClient.getStringOperate(manager.getCode());
                    Integer cInteger = 1;
                    if (resultObject != null) {
                        cInteger = (Integer) resultObject;
                    }

                    Map map = new HashMap();
                    if (cInteger > 3) {
                        map.put("lock", true);
                    } else {
                        map.put("lock", false);
                    }
                    map.put("id", manager.getId());
                    map.put("code", manager.getCode());
                    map.put("name", manager.getName());
                    map.put("duty", manager.getDuty());
                    map.put("status", manager.getStatus());
                    map.put("createTime", manager.getCreateTime());
                    map.put("roles", roles.equals("") ? "无" : roles);
                    results.add(map);
                }
                items = results;
            }

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

        return "system/manager/list";
    }

}
