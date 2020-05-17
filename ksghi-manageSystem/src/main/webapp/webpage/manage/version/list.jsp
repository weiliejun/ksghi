<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="table" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>版本管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/css/jmesa.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/css/daterangepicker.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jquery.jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/date.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/daterangepicker.js"></script>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>版本管理</li>
                <li class="active">版本列表</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>版本列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" class="form-inline" name="searchForm"
                          action="${pageContext.request.contextPath}/version/query" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">类型</span>
                                        <itech:code property="type" code="app.versionType" type="select"
                                                    value="${type}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">状态</span>
                                        <itech:code type="select" code="app.apkStatus" property="status"
                                                    value="${status}"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">上线开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">上线结束日期</span>

                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <!--结束 -->
                                <!-- 开始 -->
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                                <!--结束 -->
                                <!-- 总结束 -->
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="name" title="编号" width="15%"/>
                                        <table:htmlColumn property="type" title="类型" width="8%"/>
                                        <table:htmlColumn property="version" title="版本号" width="8%"/>
                                        <table:htmlColumn property="onlineTime" title="上线时间" width="12%"/>
                                        <table:htmlColumn property="offlineTime" title="下线时间" width="12%"/>
                                        <table:htmlColumn property="remark" title="备注" width="16%"/>
                                        <table:htmlColumn property="status" title="状态" width="8%">
                                            <itech:code property="status" type="text" code="app.apkStatus"
                                                        value="${bean.status}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="forcedUpgrade" title="强制更新" width="8%">
                                            <c:if test="${bean.forcedUpgrade == 'false'}">
                                                否
                                            </c:if>
                                            <c:if test="${bean.forcedUpgrade == 'true'}">
                                                是
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn title="操作" editable="false" filterable="false"
                                                          sortable="false" width="13%">
                                            <a href='${pageContext.request.contextPath}/version/toModify?id=${bean.id}'>编辑</a>
                                            <a href="javascript:void(0);" onclick="updateStatus('grid','${bean.id}');">删除</a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                        <div class="row">
                            <div class="col-md-offset-10 col-md-2">
                                <a href="${pageContext.request.contextPath}/version/toAdd" class="btn btn-primary"><i
                                        class="icon-plus"></i>新增版本</a>
                            </div>
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
    });

    function updateStatus(tableid, id) {
        updateWithLimitInfoForJSP("${pageContext.request.contextPath}/version/delete", tableid, id);
    }
</script>
</html>
