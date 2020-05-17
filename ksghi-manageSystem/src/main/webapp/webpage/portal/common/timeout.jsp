<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理控制台-系统超时</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            bootbox.alert('由于您之前的操作停留的时间过长，为了您账户的访问安全，请重新登录!', function () {
                top.location.href = "${pageContext.request.contextPath}/portal/login";
            });
        });
    </script>
</head>
</html>
