<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="java.text.SimpleDateFormat" %>
<%
    CurrentManager currentManager = (CurrentManager) session.getAttribute(ApplicationSessionKeys.CURRENT_MANAGER);
%>
<!DOCTYPE html>
<html>
<head>
    <title>北京国恒保险代理管理系统v1.0</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="fragment" content="!">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ui/themes/base/img/logo/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/themes/layout/css/layout.css"
          type="text/css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/themes/layout/js/layout.js"></script>
    <%@ include file="/webpage/system/manager/rights.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/themes/layout/js/app.js"></script>
</head>
<body id="ext-body">
<div id="loading">
    <span class="title">北京国恒保险代理管理系统 V1.0</span><span class="logo"></span>
</div>
<div id="header-nav">
    <ul>
        <li><span>您好，<%=currentManager.getManager().getName() + "（IP: " + currentManager.getIp() + "）"%></span>
        <li>
        <li>|</li>
        <li><a href="javascript:void(0)" onclick="changePassword()">修改密码</a></li>
        <li>|</li>
        <li><a href="${pageContext.request.contextPath}/portal/logoff">安全退出</a></li>
    </ul>
</div>
<div id="header-content">
    <strong>北京国恒保险代理管理系统 V1.0</strong>
</div>
<div id='welcome-content' style='display: none'>
    <iframe name="dashboardFrame" onload="resizeFrameHeight();resizeFrameWidth();"
            src="${pageContext.request.contextPath}/index/dashboard" style="width: 100%; height: 100%; border: 0;"
            scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
</div>
<div id='footer-content' style='display: none'>
    Copyright ©<%
    java.util.Date currentTime = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    out.println(formatter.format(currentTime));
%>
    KINGSTAR FORTUNE CORPORATION, inc. <a href="https://www.ksghi.com/" target="_blank">北京国恒保险代理有限公司版权所有。保留所有权利。</a>
</div>
</body>

<script type="text/javascript">
    function resizeFrameHeight() {
        var pTar = dashboardFrame;
        if (pTar) {  //ff
            if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight) {
                pTar.height = pTar.contentDocument.body.offsetHeight;
            } //ie
            else if (pTar.Document && pTar.Document.body.scrollHeight) {
                pTar.height = pTar.Document.body.scrollHeight;
            }
        }
    }

    function resizeFrameWidth() {
        var pTar = dashboardFrame;
        if (pTar) {  //ff
            if (pTar.contentDocument && pTar.contentDocument.body.offsetWidth) {
                pTar.width = pTar.contentDocument.body.offsetWidth;
            }  //ie
            else if (pTar.Document && pTar.Document.body.scrollWidth) {
                pTar.width = pTar.Document.body.scrollWidth;
            }
        }
    }

    function changePassword() {
        //dashboardFrame.window.changePassword();
        var win = new Ext.Window({
            title: '修改密码',
            width: 480,
            height: 360,
            html: "<iframe name=password width=480 height=360 frameborder=0 scrolling=no src='${pageContext.request.contextPath}/index/password/change'></iframe>",
            resizable: false,
            modal: true,
            closable: true,
            maximizable: false,
            minimizable: false
        });
        win.show();
    }
</script>
</html>
