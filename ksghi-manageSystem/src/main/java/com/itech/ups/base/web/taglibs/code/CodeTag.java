package com.itech.ups.base.web.taglibs.code;

import com.itech.ups.app.business.sourcecode.application.service.SourceCodeService;
import com.itech.ups.app.sourcecode.application.domain.SourceCode;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 版本信息：v1.0 日期：2012-1-16 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class CodeTag extends SimpleTagSupport {

    private String code;

    private String property;

    private String type;

    private String value;

    private String defaultValue;

    private String bind;

    private String dataSource;// 数据来源（数据库or properties文件）

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter w = super.getJspContext().getOut();
        String outContent = "";
        if (type.equals("text")) {
            outContent = getTextTypeContent();
        } else if (type.equals("radio")) {
            outContent = getRadioTypeContent();
        } else if (type.equals("checkbox")) {
            outContent = getCheckboxTypeContent();
        } else if (type.equals("select")) {
            outContent = getSelectTypeContent();
        } else if (type.equals("sourceCode")) {
            outContent = getSourceCodeContent();
        } else if (type.equals("multiSelect")) {
            outContent = getMultiselectContent();
        }

        w.write(outContent);

    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    private String getCheckboxTypeContent() {
        String content = "";
        Code element = CodesFactory.getInstance().getCode(code);
        List<String> values = element.getValues();
        if (!values.isEmpty()) {
            Iterator<String> it = values.iterator();
            while (it.hasNext()) {
                String key = it.next();
                String label = element.getItems().get(key);
                String checked = "";

                if (value == null || value.equals("")) {
                    if (defaultValue != null && defaultValue.equals(key)) {
                        checked = "checked";
                    }
                } else if (value != null && hasKey(value, key)) {
                    checked = "checked";
                }
                content = content + "<label class='checkbox-inline'><input type='checkbox' " + checked + " id='" + property + "' name='" + property + "' value='" + key + "' />" + label + "</label>";
            }
        }
        return content;
    }

    private boolean hasKey(String value, String key) {
        boolean b = false;
        String[] values = value.replace("[", "").replace("]", "").replace("'", "").replace(" ", "").split(",");
        for (String v : values) {
            if (key.equals(v)) {
                b = true;
                break;
            }
        }
        return b;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    private String getMultiselectContent() {
        String content = "";
        Code element = CodesDBFactory.getInstance().getCodeByDB(code);
        List<String> values = element.getValues();
        if (!values.isEmpty()) {
            content = "<select  id='" + property + "' name='" + property + "' class='form-control' multiple='multiple'>";
            if (bind != null) {
                String[] bindArray = bind.split("=>");
                content = "<select  id='" + property + "' name='" + property + "' class='form-control'" + bindArray[0] + "=\"" + bindArray[1] + "\">";
            }
            String selected = "";
            if (StringUtils.isBlank(value) && StringUtils.isBlank(defaultValue)) {
                selected = "selected='selected'";
            }
            // content = content + "<option value='' " + selected +
            // ">请选择</option>";

            Iterator<String> it = values.iterator();
            while (it.hasNext()) {
                String key = it.next();
                String label = element.getItems().get(key);
                selected = "";
                if (StringUtils.isBlank(value)) {
                    if (defaultValue != null && defaultValue.indexOf(key) >= 0) {
                        selected = "selected='selected'";
                    }
                } else if (StringUtils.isNotBlank(value) && value.equals(key)) {
                    selected = "selected='selected'";
                }
                content = content + "<option value='" + key + "' " + selected + ">" + label + "</option>";
            }
            content = content + "</select>";
            String script = "<script type=\"text/javascript\">";
            script += "$('#" + property + "').multiselect({enableFiltering:true,filterPlaceholder:'搜索',includeSelectAllOption:true,numberDisplayed: 1});";
            script += "</script>";
            content = content + script;
        }
        return content;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    private String getRadioTypeContent() {
        String content = "";
        Code element = CodesFactory.getInstance().getCode(code);
        List<String> values = element.getValues();
        if (!values.isEmpty()) {
            Iterator<String> it = values.iterator();
            while (it.hasNext()) {
                String key = it.next();
                String label = element.getItems().get(key);
                String checked = "";
                if (value == null || value.equals("")) {
                    if (defaultValue != null && defaultValue.equals(key)) {
                        checked = "checked";
                    }
                } else if (value != null && value.equals(key)) {
                    checked = "checked";
                }
                content = content + "<label class='radio-inline'><input type='radio' " + checked + " id='" + property + "' name='" + property + "' value='" + key + "' />" + label + "</label>";
            }
        }
        return content;
    }

    private String getSelectTypeContent() {
        String content = "";
        Code element = null;
        if ("DB".equalsIgnoreCase(dataSource)) {
            element = CodesDBFactory.getInstance().getCodeByDB(code);
        } else {
            element = CodesFactory.getInstance().getCode(code);
        }
        CodesFactory.getInstance().getCode(code);
        List<String> values = element.getValues();
        if (!values.isEmpty()) {
            content = "<select  id='" + property + "' name='" + property + "' class='form-control'>";
            if (bind != null) {
                String[] bindArray = bind.split("=>");
                content = "<select  id='" + property + "' name='" + property + "' class='form-control'" + bindArray[0] + "=\"" + bindArray[1] + "\">";
            }
            String selected = "";
            if (StringUtils.isBlank(value) && StringUtils.isBlank(defaultValue)) {
                selected = "selected='selected'";
            }
            content = content + "<option value='' " + selected + ">请选择</option>";

            Iterator<String> it = values.iterator();
            while (it.hasNext()) {
                String key = it.next();
                String label = element.getItems().get(key);
                selected = "";
                if (StringUtils.isBlank(value)) {
                    if (defaultValue != null && defaultValue.equals(key)) {
                        selected = "selected='selected'";
                    }
                } else if (StringUtils.isNotBlank(value) && value.equals(key)) {
                    selected = "selected='selected'";
                }
                content = content + "<option value='" + key + "' " + selected + ">" + label + "</option>";
            }
            content = content + "</select>";
        }
        return content;
    }

    private String getSourceCodeContent() {

        /*
         * //注释：CodesFactory.getInstance()会填充一个用户来源的map,现在改成从表中取list HashMap map
         * = CodesFactory.getInstance().getSourceCode(); String label =
         * "<a target='_blank' href='" + (map.get(value) == null ? "#" :
         * map.get(value).toString()) + "'>" + (map.get(value) == null ? "" :
         * map.get(value).toString()) + "</a>"; return label;
         */

        String content = "";
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        SourceCodeService sourceCodeService = (SourceCodeService) context.getBean("sourceCodeService");
        List<SourceCode> sourceCodes = sourceCodeService.selectSourceCodesByParam(new HashedMap(), 0, 0);
        if (!sourceCodes.isEmpty()) {
            content = "<select  id='" + property + "' name='" + property + "' class='form-control'>";
            if (bind != null) {
                String[] bindArray = bind.split("=>");
                content = "<select  id='" + property + "' name='" + property + "' class='form-control'" + bindArray[0] + "=\"" + bindArray[1] + "\">";
            }
            String selected = "";
            if (StringUtils.isBlank(value) && StringUtils.isBlank(defaultValue)) {
                selected = "selected='selected'";
            }
            content = content + "<option value='' " + selected + ">请选择</option>";
            for (SourceCode sourceCode : sourceCodes) {
                String key = sourceCode.getSourceCode();
                String label = sourceCode.getSourceName();
                selected = "";
                if (StringUtils.isBlank(value)) {
                    if (defaultValue != null && defaultValue.equals(key)) {
                        selected = "selected='selected'";
                    }
                } else if (StringUtils.isNotBlank(value) && value.equals(key)) {
                    selected = "selected='selected'";
                }
                content = content + "<option value='" + key + "' " + selected + ">" + label + "</option>";
            }
            content = content + "</select>";
        }
        return content;
    }

    private String getTextTypeContent() {
        String content = "";
        Code element = null;
        if ("DB".equalsIgnoreCase(dataSource)) {
            element = CodesDBFactory.getInstance().getCodeByDB(code);
        } else {
            element = CodesFactory.getInstance().getCode(code);
        }
        CodesFactory.getInstance().getCode(code);
        // String
        // label=element.getItems().get(value)==null?"":element.getItems().get(value);
        String label = "";
        String[] values_ = value.split(",");
        for (int i = 0; i < values_.length; i++) {
            if (values_[i] != null && !values_[i].equals("")) {
                label += element.getItems().get(values_[i]) == null ? element.getItems().get(defaultValue) : element.getItems().get(values_[i]);
                label += ",";
            }
        }

        // String
        // label=element.getItems().get(value)==null?element.getItems().get(defaultValue):element.getItems().get(value);
        if (StringUtils.isBlank(label)) {
            label = (value == null) ? "" : value;// label="";
        } else {
            label = label.substring(0, label.length() - 1);
        }
        return label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

}
