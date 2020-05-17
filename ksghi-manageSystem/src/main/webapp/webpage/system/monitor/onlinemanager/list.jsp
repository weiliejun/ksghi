<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>在线人员监控</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>系统监控数据管理</li>
                <li class="active">在线人员监控</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>在线人员列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/onlinemanager/list">
                        <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean" stateAttr="restore">
                            <table:htmlTable width="100%">
                                <table:htmlRow sortable="true" filterable="false">
                                    <table:htmlColumn property="managerCode" title="账号" width="20%"/>
                                    <table:htmlColumn property="managerName" title="姓名" width="20%"/>
                                    <table:htmlColumn property="ip" title="Ip地址" width="20%"/>
                                    <table:htmlColumn property="loginTime" title="登录时间" width="20%"/>
                                    <table:htmlColumn property="sessionId" title="Session 标识" width="20%"/>
                                </table:htmlRow>
                            </table:htmlTable>
                        </table:tableModel>
                    </form>
                    <script type="text/javascript">
                        function onInvokeAction(id) {
                            $.jmesa.setExportToLimit(id, '');
                            $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
                        }
                    </script>
                </div>
                <div class="col-sm-offset-6 col-sm-12"></div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>


<script type="text/javascript">

</script>
</html>
