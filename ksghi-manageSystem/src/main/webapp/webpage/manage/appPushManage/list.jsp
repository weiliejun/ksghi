<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>消息推送管理</title>
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
                <li>消息推送管理</li>
                <li class="active">消息推送列表</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>消息推送列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" class="form-inline" name="searchForm"
                          action="${pageContext.request.contextPath}/appPushManage/query" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">消息名称</span> <input id="messageName"
                                                                                           name="messageName"
                                                                                           type="text"
                                                                                           class="form-control"
                                                                                           value="${messageName}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">消息类型</span>
                                        <itech:code property="type" code="appPushManageType" type="select"
                                                    value="${type}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">状态</span>
                                        <itech:code property="pushType" type="select" code="app.pushManageStatus"
                                                    value="${pushType}"/>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">推送开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">推送结束日期</span>

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
                                        <table:htmlColumn property="messageName" title="消息名称" width="8%"/>
                                        <table:htmlColumn property="type" title="消息类型" width="8%">
                                            <itech:code property="type" type="text" code="appPushManageType"
                                                        value="${bean.type}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="content" title="推送内容" width="20%"/>
                                        <table:htmlColumn property="createTime" title="创建时间" width="15%"/>
                                        <table:htmlColumn property="isAutoPush" title="自动推送" width="5%">
                                            <itech:code property="isAutoPush" type="text" code="app.isAutoPush"
                                                        value="${bean.isAutoPush}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="pushTime" title="推送时间" width="15%"/>
                                        <table:htmlColumn property="apptype" title="推送终端" width="8%">
                                            <itech:code property="apptype" type="text" code="app.pushAppType"
                                                        value="${bean.apptype}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="pushType" title="状态" width="5%">
                                            <itech:code property="pushType" type="text" code="app.pushManageStatus"
                                                        value="${bean.pushType}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="usernum" title="查看用户数" width="8%"/>
                                        <table:htmlColumn title="操作" editable="false" filterable="false"
                                                          sortable="false" width="20%">
                                            <c:if test="${bean.pushType=='unpush'}">
                                                <a href='${pageContext.request.contextPath}/appPushManage/toAdd?id=${bean.id}'
                                                   style="color: #64d2f4;">编辑</a>
                                                <a href="javascript:void(0);" onclick="deleteData('${bean.id}')"
                                                   style="color: #64d2f4;">删除</a>
                                                <a href="javascript:void(0);" onclick="push('${bean.id}')"
                                                   style="color: #64d2f4;">立即推送</a>
                                            </c:if>
                                            <c:if test="${bean.pushType=='pushed'}">
                                                <a href='${pageContext.request.contextPath}/appPushManage/toAdd?id=${bean.id}'
                                                   style="color: #d2d2d2;">编辑</a>
                                                <a href="javascript:void(0);" onclick="deleteData('${bean.id}')"
                                                   style="color: #d2d2d2;">删除</a>
                                                <c:if test="${bean.status=='stop'}">
                                                    <a style="color: #d2d2d2;">已停用</a>
                                                </c:if>
                                                <c:if test="${bean.status=='push'}">
                                                    <a href="javascript:void(0);" onclick="stop('${bean.id}')"
                                                       style="color: #d2d2d2;">停用</a>
                                                </c:if>
                                            </c:if>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                        <div class="row">
                            <div class="col-md-offset-10 col-md-2">
                                <a href="${pageContext.request.contextPath}/appPushManage/toAdd"
                                   class="btn btn-primary"><i class="icon-plus"></i>新增消息</a>
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

    function deleteData(id) {
        bootbox.confirm('确定要删除吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appPushManage/delete?id=' + id;
                return false;
            }
        });
    }

    function push(id) {
        bootbox.confirm('确定立即推送此消息？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appPushManage/updateStatusById?status=push&id=' + id;
                return false;
            }
        });
    }

    function stop(id, status) {
        bootbox.confirm('确定停用此消息？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/appPushManage/updateStatusById?status=stop&id=' + id;
                return false;
            }
        });
    }
</script>
</html>
