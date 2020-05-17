<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/fnx.tld" prefix="fnx" %>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="table" %>
<%@ taglib uri="http://www.itech-ups.com/jsp/taglibs" prefix="itech" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57GMT">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ui/themes/base/img/logo/favicon.ico">

<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/google-bootstrap.min.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/icomoon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/themes/base/css/public.css">
<script type="text/javascript">
    var pageContext = {
        contextPath: '${pageContext.request.contextPath}'
    };
</script>
<style type="text/css">
    #wrapper {
        position: relative;
        height: 200px; /* Desired element height */
        overflow: scroll;
    }
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.bgiframe.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/bootbox.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.jtemplates.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/themes/base/js/public.js"></script>

<!--[if lte IE 6]>
<link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie6.css" rel="stylesheet" type="text/css" >
<![endif]-->
<!--[if lt IE 9 ]>
<link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie78.css" rel="stylesheet" type="text/css" >
<![endif]-->
<!--[if IE 9 ]>
<link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie9.css" rel="stylesheet" type="text/css" >
<![endif]-->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/ui/core/js/html5shiv-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/ui/core/js/respond-1.3.0.min.js"></script>
<![endif]-->

<%@ include file="/webpage/common/plugins/daterangepicker.jsp" %>
<%@ include file="/webpage/common/plugins/datepicker.jsp" %>
<%@ include file="/webpage/common/plugins/timepicker.jsp" %>
<%@ include file="/webpage/common/plugins/form.jsp" %>
<%@ include file="/webpage/common/plugins/chosen.jsp" %>
<%@ include file="/webpage/common/plugins/jmesa.jsp" %>
<%@ include file="/webpage/common/plugins/notify.jsp" %>
<%@ include file="/webpage/common/plugins/colorbox.jsp" %>
<%@ include file="/webpage/common/plugins/datetimepicker.jsp" %>
<%@ include file="/webpage/common/plugins/template.jsp" %>
<%@ include file="/webpage/common/plugins/highcharts.jsp" %>