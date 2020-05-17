<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录日志监控</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/bootstrapmultiselect.jsp" %>
</head>
<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>系统监控数据管理</li>
                <li class="active">登录日志监控</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>登录日志列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" class="form-inline" name="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/loginlog/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录账号</span> <input name="managerCode"
                                                                                           type="text"
                                                                                           class="form-control"
                                                                                           value="${managerCode }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录人姓名</span> <input name="managerName"
                                                                                            type="text"
                                                                                            class="form-control"
                                                                                            value="${managerName }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录终端</span>
                                        <itech:code property="terminal" code="loginlog.terminal" type="select"
                                                    value="${terminal}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录人角色类型</span>
                                        <itech:code property="roleType" code="loginlog.roleType" type="select"
                                                    value="${roleType}"/>
                                    </div>
                                </div>
                                <%-- <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户分类</span>
                                        <itech:code property="userClassification" code="userClassification" type="multiSelect" value="" defaultValue="${userClassification}" />
                                        <input type="hidden" name="userClassification" value="" />
                                    </div>
                                </div> --%>
                                <!-- 总开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">登录结束日期</span>
                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <!--结束 -->
                                <!-- 开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                    <button type="button" id="exportBtn" class="btn btn-primary">
                                        <i class="icon-file-excel"></i>导出Excel
                                    </button>
                                </div>
                                <!--结束 -->
                            </div>
                            <!-- 总结束 -->
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <c:if test="${bean.ROLE_TYPE == ApplicationConstant.PLATFORM_SUPER_ADMIN_ROLE_TYPE }">
                                            <table:htmlColumn property="MANAGER_CODE" title="登录账号" width="10%"/>
                                        </c:if>
                                        <c:if test="${bean.ROLE_TYPE != ApplicationConstant.PLATFORM_SUPER_ADMIN_ROLE_TYPE  }">
                                            <table:htmlColumn property="MANAGER_CODE" title="登录账号" width="10%">
                                                <c:if test="${bean.MANAGER_CODE != null}">
                                                    ${fn:substring(bean.MANAGER_CODE,0,3)}****${fn:substring(bean.MANAGER_CODE,(fn:length(bean.MANAGER_CODE) -4),fn:length(bean.MANAGER_CODE))}
                                                </c:if>
                                            </table:htmlColumn>
                                        </c:if>
                                        <table:htmlColumn property="MANAGER_NAME" title="登录人姓名" width="12%"/>
                                        <table:htmlColumn property="nickName" title="登录人昵称" width="13%">
                                            ${bean.NICK_NAME}
                                        </table:htmlColumn>
                                        <%-- 											<table:htmlColumn property="USER_CLASS_NAME" title="用户分类" width="7%" /> --%>
                                        <table:htmlColumn property="IP" title="Ip地址" width="10%"/>
                                        <table:htmlColumn property="LOGIN_TIME" title="登录时间" width="13%"/>
                                        <table:htmlColumn property="terminal" title="登录终端" width="10%">
                                            <itech:code code="loginlog.terminal" type="text" value="${bean.TERMINAL}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="LOGOFF_TIME" title="下线时间" width="15%"/>
                                        <table:htmlColumn property="roleType" title="登录人角色类型" width="10%">
                                            <itech:code code="loginlog.roleType" type="text" value="${bean.ROLE_TYPE}"/>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
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
    $().ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/system/monitor/loginlog/list/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>
