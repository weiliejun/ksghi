package com.itech.ups.app.business.sourcecode.action;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.business.sourcecode.application.service.SourceCodeService;
import com.itech.ups.app.sourcecode.application.domain.SourceCode;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.jmesa.limit.Limit;
import org.jmesa.model.PageItems;
import org.jmesa.model.TableModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Jxc
 * @Description: 用户来源管理
 * @date 2017/1/11
 */
@Controller
public class SourceCodeController extends AbstractActionParent {

    @Autowired
    private SourceCodeService sourceCodeService;

    /**
     * @throws @author Jxc
     * @Description: 跳转列表页 void
     * @date 2017/1/11
     */
    @RequestMapping(value = {"/business/sourcecode/list"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String list(HttpServletRequest request, Model model) {

        final Map<String, Object> params = selectParams(request);

        // size>=0打开菜单链接就查询；size>0输入查询条件才查询
        if (new Integer(params.get("size").toString()).intValue() >= 0) {
            Collection<?> items = TableModelUtils.getItems("grid", "restore", request, new PageItems() {
                public Collection<?> getItems(Limit limit) {
                    Map<String, Object> map = computingPage(limit, params);
                    int rowStart = (Integer) map.get("rowStart");
                    int rowEnd = (Integer) map.get("rowEnd");
                    return sourceCodeService.selectSourceCodesByParam(params, rowStart, rowEnd);
                }

                public int getTotalRows(Limit limit) {
                    return sourceCodeService.selectSourceCodesCountByParam(params);
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

        return "/business/sourcecode/list";

    }

    /**
     * @throws @author Jxc
     * @Description: 跳新增页面 void
     * @date 2017/1/11
     */
    @RequestMapping(value = {"/business/sourcecode/add"}, method = {RequestMethod.GET})
    public String addSourceCode() {
        return "/business/sourcecode/add";
    }

    /**
     * @throws @author Jxc
     * @Description: 对一行信息的删除，url中会传过来id，需要修改下value,直接通过url跳转的话会不会出现权限问题和报错 void
     * @date 2017/1/11
     */
    @RequestMapping(value = {"/business/sourcecode/delete/{id}"}, method = RequestMethod.GET)
    public String deleteSourceCode(@PathVariable("id") String id) {
        SourceCode sourceCode = sourceCodeService.selectSourceCodeById(id);
        sourceCode.setDataStatus("invalid");
        sourceCodeService.updateSourceCode(sourceCode);
        return "redirect:/business/sourcecode/list";
    }

    /**
     * @throws @author Jxc
     * @Description: 跳转修改页面，对信息进行修改，也会需要传id，先查后改 void
     * @date 2017/1/11
     */
    @RequestMapping(value = "/business/sourcecode/edit/{id}", method = RequestMethod.GET)
    public String editSourceCode(@PathVariable("id") String id, Model model) {
        SourceCode sourceCode = sourceCodeService.selectSourceCodeById(id);
        model.addAttribute(sourceCode);
        return "/business/sourcecode/edit";
    }

    /**
     * @throws @author Jxc
     * @Description: 对填写表单信息的保存，修改和保存的区别在是否有ID是否为空 void
     * @date 2017/1/11
     */
    @RequestMapping(value = {"/business/sourcecode/save"}, method = RequestMethod.POST)
    public String saveSourceCode(SourceCode sourceCode, HttpServletRequest request) {
        if (StringHelper.isBlank(sourceCode.getId())) {
            CurrentManager currentManager = (CurrentManager) request.getSession().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
            sourceCode.setCreatorId(currentManager.getManager().getId());
            sourceCode.setCreatorName(currentManager.getManager().getName());
        }
        sourceCodeService.saveSourceCode(sourceCode);
        return "redirect:/business/sourcecode/list";
    }

    /**
     * @throws @author Jxc
     * @Description: 启用
     * @date 2017/1/11
     */
    @RequestMapping("/business/sourcecode/enable/{id}")
    public String enableStatus(HttpServletRequest request, @PathVariable("id") String id) {

        SourceCode sourceCode = sourceCodeService.selectSourceCodeById(id);
        sourceCode.setStatus("enable");
        sourceCodeService.updateSourceCode(sourceCode);
        saveBusinessLog("用户来源管理", "启用用户来源信息", sourceCode, request);
        return "redirect:/business/sourcecode/list";
    }

    /**
     * @throws @author Jxc
     * @Description: 停用
     * @date 2017/1/11
     */
    @RequestMapping("/business/sourcecode/unable/{id}")
    public String unableStatus(HttpServletRequest request, @PathVariable("id") String id) {

        SourceCode sourceCode = sourceCodeService.selectSourceCodeById(id);
        sourceCode.setStatus("unable");
        sourceCodeService.updateSourceCode(sourceCode);
        saveBusinessLog("用户来源管理", "停用用户来源信息", sourceCode, request);
        return "redirect:/business/sourcecode/list";

    }

    /**
     * @throws @author Jxc
     * @Description: 校验souceCode的唯一性
     * @date 2017/1/11
     */
    @RequestMapping(value = "/business/sourcecode/validate/soucecode", method = RequestMethod.POST)
    @ResponseBody
    public boolean validateSouceCode(String code, String id) {
        boolean result = false;
        if (StringHelper.isNotBlank(code)) {
            SourceCode sourceCode = sourceCodeService.findSourceCodeByCode(code);
            if (sourceCode == null) {
                result = true;
            } else {
                // 判断是add.jsp还是edit.jsp页面的校验
                if (StringHelper.isNotBlank(id) && id.equals(sourceCode.getId())) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

}
