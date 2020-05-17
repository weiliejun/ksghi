package com.itech.ups.app.system.manager.action;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.app.system.manager.application.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IsManagerExit {

    @Autowired
    private ManagerService service;

    @RequestMapping(value = {"/system/manager/isexit/{code}"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Map<String, ?> isExit(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "code") String code, @RequestParam(value = "managerId", required = false) String ignoredManagerId) {
        Map<String, String> model = new HashMap<String, String>();
        String flag = "false";
        List managers = service.findManagerByCode(code);
        if (managers != null && managers.size() > 0) {
            if (StringHelper.isBlank(ignoredManagerId)) {
                flag = "true";
            } else {
                for (int i = 0; i < managers.size(); i++) {
                    Manager manager = (Manager) managers.get(i);
                    if (!manager.getId().equals(ignoredManagerId)) {
                        flag = "true";
                        break;
                    }
                }
            }
        }
        model.put("flag", flag);
        return model;
    }
}
