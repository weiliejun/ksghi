<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>广告位管理列表</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li class="active">网站广告位管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>广告位信息列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/website/advertise/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">广告位标题</span> <input name="name" type="text"
                                                                                            class="form-control"
                                                                                            value="${name }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">所属板块</span>
                                        <itech:code property="channel" code="advertise.location" type="select"
                                                    value="${channel }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">展现形式</span>
                                        <itech:code property="type" code="advertiseType" type="select"
                                                    value="${type }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">状态</span>
                                        <itech:code property="status" code="advertise.status" type="select"
                                                    value="${status }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="code" title="编码" width="8%"/>
                                        <table:htmlColumn property="channel" title="所属板块" width="12%"/>
                                        <table:htmlColumn property="type" title="展现形式" width="8%">
                                            <itech:code code="advertiseType" type="text" value="${bean.type}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="sequnum" title="显示排序" width="4%"/>
                                        <table:htmlColumn property="name" title="广告位标题" width="15%"/>
                                        <table:htmlColumn property="targetUrl" title="链接URL" width="15%"/>
                                        <table:htmlColumn property="status" title="状态" width="5%">
                                            <itech:code code="advertise.status" type="text" value="${bean.status}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="clicks" title="点击次数" width="5%"/>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/website/advertise/edit/${bean.id}"
                                               title="修改广告位信息"><i class="icon-pencil"></i></a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除广告位信息"><i
                                                    class="icon-remove2"></i></a>
                                            <c:if test="${bean.status == 'unable' }">
                                                <a href="${pageContext.request.contextPath}/business/website/advertise/enable/${bean.id}"
                                                   title="启用">已停用</a>
                                            </c:if>
                                            <c:if test="${bean.status == 'enable' }">
                                                <a href="${pageContext.request.contextPath}/business/website/advertise/unable/${bean.id}"
                                                   title="停用">已启用</a>
                                            </c:if>
                                            <%-- 					                    <a href="#" title="复制信息" onclick="copyAdvirst('${bean.id}');"><i class="icon-copy"></i></a> --%>
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
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <a href="${pageContext.request.contextPath}/business/website/advertise/add" class="btn btn-primary"><i
                            class="icon-plus"></i>新增广告位</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    function deleteData(id) {
        bootbox.confirm("您确定要删除该广告位信息吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/website/advertise/delete/' + id;
                return false;
            }
        });
    }

    function copyAdvirst(id) {
        var loading = '<img src="${pageContext.request.contextPath }/assets/ui/themes/base/img/finance/loading.gif">处理中...';
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/business/website/advertise/copy/" + id,
            dataType: "json",
            beforeSend: function () {
                dialog = bootbox.dialog({
                    message: loading,
                    closeButton: false
                });
            },
            complete: function () {
                dialog.modal("hide");
            },
            success: function (data) {
                bootbox.alert("处理完成！", function () {
                    window.location.href = "${pageContext.request.contextPath}/business/website/advertise/list";
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                bootbox.alert("请求失败，请刷新页面后重试！");
                return false;
            }
        });
    }
</script>
</html>
