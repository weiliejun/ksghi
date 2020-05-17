<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户详细</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>${orgInfo.orgName }－用户详细
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" name="searchForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/media/userlist" role="form">
                        <input type="hidden" name="orgId" value="${orgInfo.id }"/> <input type="hidden"
                                                                                          name="timeStatus"
                                                                                          value="${timeStatus }"/>
                        <input type="hidden" name="openType" value="${openType }"/> <input type="hidden" name="bankCard"
                                                                                           value="${bankCard }"/> <input
                            type="hidden" name="souceCode" value="${souceCode }"/>
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <c:if test="${timeStatus == 'register' }">
                                    <div class="form-group" style="padding-left: 0px;">
                                        <label class="control-label">注册时间</label>
                                        <div class="input-group-div">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="icon-calendar"></i></span>
                                                <input id="registerTime" name="registerTime" size="30" type="text"
                                                       class="form-control" readonly="readonly"
                                                       value="${registerTime}"/>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${timeStatus == 'bankCard' }">
                                    <div class="form-group" style="padding-left: 0px;">
                                        <label class="control-label">绑卡时间</label>
                                        <div class="input-group-div">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="icon-calendar"></i></span>
                                                <input id="bankCardTime" name="bankCardTime" size="30" type="text"
                                                       class="form-control" readonly="readonly"
                                                       value="${bankCardTime}"/>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${timeStatus == 'openAccount' }">
                                    <div class="form-group" style="padding-left: 0px;">
                                        <label class="control-label">开户时间</label>
                                        <div class="input-group-div">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="icon-calendar"></i></span>
                                                <input id="openTime" name="openTime" size="30" type="text"
                                                       class="form-control" readonly="readonly" value="${openTime}"/>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <div class="form-group">
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
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="NICK_NAME" title="用户昵称" width="15%"/>
                                        <table:htmlColumn property="NAME" title="用户姓名" width="15%"/>
                                        <table:htmlColumn property="MOBILE" title="手机号码" width="15%"/>
                                        <table:htmlColumn property="CREATE_TIME" title="注册时间" width="15%"/>
                                        <table:htmlColumn property="OPENTIME" title="开户时间" width="15%"/>
                                        <table:htmlColumn property="BANKCARDTIME" title="绑卡时间" width="15%"/>
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
        $('#registerTime').daterangepicker();
        $('#openTime').daterangepicker();
        $('#bankCardTime').daterangepicker();
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/media/userlist/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
>
</html>
