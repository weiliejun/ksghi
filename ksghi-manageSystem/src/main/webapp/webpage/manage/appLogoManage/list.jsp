<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LOGO运营管理</title>
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
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>LOGO运营管理</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/appLogoManage/query"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">创建结束日期</span>

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
                                        <table:htmlColumn property="logoName" title="名称" width="15%" sortable="true"/>
                                        <table:htmlColumn property="createTime" title="创建时间" width="15%"/>
                                        <table:htmlColumn property="startTime" title="启用时间" width="15%"/>
                                        <table:htmlColumn property="endTime" title="停用时间" width="15%"/>
                                        <table:htmlColumn property="remark" title="备注" width="20%"/>
                                        <table:htmlColumn property="status" title="状态" width="8%">
                                            <c:if test="${bean.status=='stop'}">已停用</c:if>
                                            <c:if test="${bean.status=='used'}">已启用</c:if>
                                            <c:if test="${bean.status=='unuse'}">未启用</c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn title="操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/appLogoManage/findByid?id=${bean.id}"
                                               title="预览">预览</a>
                                            <a href='${pageContext.request.contextPath}/appLogoManage/toAdd?id=${bean.id}'>编辑</a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除">删除</a>
                                            <c:if test="${bean.status == 'used' }">
                                                <a href="javascript:void(0);" onclick="stop('${bean.id}')"
                                                   style="color: #1155cc;">停用</a>
                                            </c:if>
                                            <c:if test="${bean.status == 'unuse' }">
                                                <a href="javascript:void(0);" onclick="used('${bean.id}')"
                                                   style="color: #1155cc;">启用</a>
                                            </c:if>
                                            <c:if test="${bean.status == 'stop' }">
                                                <span style="color: #d2d2d2;">已停用</span>
                                            </c:if>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-10 col-md-12">
                    <a href="${pageContext.request.contextPath}/appLogoManage/toAdd" class="btn btn-primary"><i
                            class="icon-plus"></i>新增运营LOGO</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    function onInvokeAction(id) {
        $.jmesa.setExportToLimit(id, '');
        $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
    }

    $().ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });

    function deleteData(id) {
        bootbox.confirm("您确定要删除该LOGO吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appLogoManage/delete?id=' + id;
                return false;
            }
        });
    }

    function used(id) {
        bootbox.confirm('确定启用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appLogoManage/updateStatusById?status=used&id=' + id;
                return false;
            }
        });
    }

    function stop(id) {
        bootbox.confirm('确定停用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appLogoManage/updateStatusById?status=stop&&id=' + id;
                return false;
            }
        });
    }
</script>
</html>
