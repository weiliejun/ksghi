package com.itech.ups.base.web.taglibs.menu;

import com.itech.core.components.xtree.TreeNode;
import com.itech.ups.base.ApplicationSessionKeys;
import com.itech.ups.base.application.domain.CurrentManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 版本信息：v1.0 日期：2012-1-16 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class AdminHeaderTag extends SimpleTagSupport {

    public String channel;

    @Override
    public void doTag() throws JspException, IOException {
        CurrentManager currentManager = (CurrentManager) this.getJspContext().getAttribute(ApplicationSessionKeys.CURRENT_MANAGER, PageContext.SESSION_SCOPE);
        String contextPath = ((HttpServletRequest) ((PageContext) this.getJspContext()).getRequest()).getContextPath();
        TreeNode functionTree = currentManager.getAuthorityFunctionTree();
        JspWriter writer = super.getJspContext().getOut();
        StringBuffer outContent = new StringBuffer();
        outContent.append("<div class='container'>");
        outContent.append("    <div id='header' class='navbar' role='navigation'>");
        outContent.append("		<div class='navbar-collapse collapse'>");
        outContent.append("    		<ul class='nav navbar-nav'>");
        outContent.append(packageHeaderMenuContent((PageContext) this.getJspContext(), functionTree, channel));
        outContent.append("    	    </ul>");
        // outContent.append(" <ul class='nav navbar-nav navbar-right'>");
        // outContent.append(" <li class='dropdown'>");
        // outContent.append(" <a href='#' class='dropdown-toggle'
        // data-toggle='dropdown'>");
        // outContent.append(" <i class='icon-user'></i><label>&nbsp;"
        // + currentManager.getManager().getName() +
        // "&nbsp;</label><b class='caret'></b>");
        // outContent.append(" </a>");
        // outContent.append(" <ul class='dropdown-menu'>");
        // outContent.append(" <li><a href='" + contextPath +
        // "/'><i class='icon-lock'></i>修改密码</a></li>");
        // outContent.append(" <li><a href='" + contextPath +
        // "/logoff'><i class='icon-exit'></i>退出系统</a></li>");
        // outContent.append(" </ul>");
        // outContent.append(" </li>");
        // outContent.append(" </ul>");
        outContent.append("        </div>");
        outContent.append("     </div>");
        outContent.append("</div>");
        writer.write(outContent.toString());
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    private String packageHeaderMenuContent(PageContext pageContext, TreeNode functionTree, String channel) {
        String contextPath = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
        StringBuilder outContent = new StringBuilder();
        if (channel.equals("") || channel.equals("index")) {
            outContent.append("<li class='active'><a href='" + contextPath + "/index' class='nav-btn-icon' data-toggle2='tooltip' data-placement='bottom' title='' data-original-title='控制台首页'><span>首&nbsp;&nbsp;页</span></a></li>");
        } else {
            outContent.append("<li class=''><a href='" + contextPath + "/index' class='nav-btn-icon' data-toggle2='tooltip' data-placement='bottom' title='' data-original-title='控制台首页'><span>首&nbsp;&nbsp;页</span></a></li>");
        }
        if (functionTree.getId().equals("root")) {
            List<TreeNode> slist = functionTree.getChildren();
            if (slist != null && !slist.isEmpty()) {
                Iterator<TreeNode> it1 = slist.iterator();
                while (it1.hasNext()) {
                    TreeNode subSystemNode = (TreeNode) it1.next();
                    String code1 = subSystemNode.getId();
                    String name1 = subSystemNode.getName();
                    String url1 = (String) subSystemNode.getAttribute("url");
                    String nodeType1 = (String) subSystemNode.getAttribute("nodeType");
                    String status1 = (String) subSystemNode.getAttribute("status");
                    String icon1 = (String) subSystemNode.getAttribute("icon");
                    if (channel.equals(code1)) {
                        outContent.append("<li class='dropdown active'>");
                        outContent.append("	  <a href='#' class='nav-btn-icon dropdown-toggle' data-toggle='dropdown' data-toggle2='tooltip' data-placement='bottom' title='' data-original-title='" + name1 + "'><span>" + name1 + "</span></a>");
                        outContent.append("	  <ul class='dropdown-menu'>");
                    } else {
                        outContent.append("<li class='dropdown'>");
                        outContent.append("	  <a href='#' class='nav-btn-icon dropdown-toggle' data-toggle='dropdown' data-toggle2='tooltip' data-placement='bottom' title='' data-original-title='" + name1 + "'><span>" + name1 + "</span></a>");
                        outContent.append("	  <ul class='dropdown-menu'>");
                    }

                    List<TreeNode> mlist = subSystemNode.getChildren();
                    if (mlist != null && !mlist.isEmpty()) {
                        for (int i = 0; i < mlist.size(); i++) {
                            TreeNode moduleNode = (TreeNode) mlist.get(i);
                            String name2 = moduleNode.getName();
                            outContent.append("<li class='dropdown-header'>" + name2 + "</li>");
                            List<TreeNode> alist = moduleNode.getChildren();
                            if (alist != null && !alist.isEmpty()) {
                                Iterator<TreeNode> it3 = alist.iterator();
                                while (it3.hasNext()) {
                                    TreeNode subModuleNode = (TreeNode) it3.next();
                                    String name3 = subModuleNode.getName();
                                    String code3 = subModuleNode.getId();
                                    String url3 = (String) subModuleNode.getAttribute("url");
                                    String nodeType3 = (String) subModuleNode.getAttribute("nodeType");
                                    String status3 = (String) subModuleNode.getAttribute("status");
                                    // outContent.append("<li><a href='"+
                                    // contextPath + url3
                                    // +"'><i class='icon-forward'
                                    // style='color:#999;'></i>"
                                    // + name3 + "</a></li>");
                                    outContent.append("<li><a href='" + contextPath + url3 + "'>" + name3 + "</a></li>");
                                }
                            }
                            if (i < (mlist.size() - 1)) {
                                outContent.append("<li class='divider'></li>");
                            }
                        }
                    }
                    outContent.append("</ul></li>");
                }
            }
        }
        return outContent.toString();
    }

}
