package com.itech.ups.base.web.taglibs.promptinfo;

import com.itech.ups.base.ApplicationSessionKeys;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PromptInfoTag extends SimpleTagSupport {

    private String type;

    @Override
    public void doTag() throws JspException, IOException {

        PageContext context = (PageContext) getJspContext();
        HttpSession session = context.getSession();
        Object oPromptInfo = session.getAttribute(ApplicationSessionKeys.PROMPT_INFO);
        if (null != oPromptInfo) {
            String promptInfo = oPromptInfo.toString();
            if (!promptInfo.isEmpty()) {
                if (type.equals("alert")) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("<script type=\"text/javascript\">");
                    sb.append("$(function(){");
                    sb.append("bootbox.alert(\"");
                    sb.append(promptInfo);
                    sb.append("\");");
                    sb.append("});");
                    sb.append("</script>");
                    context.getOut().write(sb.toString());
                } else if (type.equals("text")) {
                    context.getOut().write(promptInfo);
                }
            }
            session.removeAttribute(ApplicationSessionKeys.PROMPT_INFO);
        }
    }

    public void setType(String type) {
        this.type = type;
    }

}
