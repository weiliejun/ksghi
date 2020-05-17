<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String theme = request.getParameter("theme");

%>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/tree/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/assets/ui/core/plugins/tree/ztree/css/style.css"></link>

<% if (theme != null) { %>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/assets/ui/core/plugins/tree/ztree/css/style<%=theme%>.css"></link>
<%}%>