<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>合作平台管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>
<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站用户管理</li>
                <li>合作平台管理</li>
                <li class="active">合作平台查询</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>合作平台信息列表</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 right-border">
            <form name="roleForm" id="searchForm" action="${pageContext.request.contextPath}/manage/partnerManage/list"
                  role="form" class="form-inline">
                <div class="panel panel-search">
                    <div class="panel-body">
                        <div class="form-group col-md-3 col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon">合作平台网站名称</span> <input class="form-control" type="text"
                                                                                       name="name" value="${name}">
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon">合作平台网站地址</span> <input class="form-control" type="text"
                                                                                       name="url" value="${url}">
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon">法人代表</span> <input class="form-control" type="text"
                                                                                   name="ownerName"
                                                                                   value="${ownerName}">
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon">电话</span> <input class="form-control" type="text"
                                                                                 name="phone" value="${phone}">
                            </div>
                        </div>
                        <div class="form-group col-md-3 col-xs-6">
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
                    <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean" stateAttr="restore">
                        <table:htmlTable width="100%">
                            <table:htmlRow sortable="true" filterable="false">
                                <table:htmlColumn property="name" title="合作平台网站名称" width="15%"/>
                                <table:htmlColumn property="url" title="合作平台网站地址" width="15%"/>
                                <table:htmlColumn property="ip" title="合作平台网站IP" width="7%"/>
                                <table:htmlColumn property="ownerName" title="法人代表" width="5%"/>
                                <table:htmlColumn property="address" title="公司地址" width="20%"/>
                                <table:htmlColumn property="phone" title="电话" width="10%"/>
                                <table:htmlColumn property="createTime" title="创建时间" width="10%"/>
                                <table:htmlColumn title="数据操作" width="18%" sortable="false">
                                    <a id="key_${bean.id}" href="javascript:void(0)" title="生成密钥"
                                       onclick="genarateKey('${bean.id}')"><i class="icon-plus"></i>生成密钥</a>
                                    <c:if test="${bean.status=='open'}">
                                        <a id="status_${bean.id}" href="javascript:void(0)" title="状态开关"
                                           onclick="changeStatus('${bean.id}','close')"><i class="icon-plus"></i>暂停</a>
                                    </c:if>
                                    <c:if test="${bean.status=='close'}">
                                        <a id="status_${bean.id}" href="javascript:void(0)" title="状态开关"
                                           onclick="changeStatus('${bean.id}','open')"><i class="icon-plus"></i>开启</a>
                                    </c:if>
                                    <a href="${pageContext.request.contextPath}/manage/partnerManage/toEdit/${bean.id}"
                                       title="修改"><i class="icon-pencil"></i>修改</a>
                                    <a href="javascript:void(0)" title="删除" onclick="deleteData('${bean.id}')"><i
                                            class="icon-remove2"></i>删除</a>
                                </table:htmlColumn>
                            </table:htmlRow>
                        </table:htmlTable>
                    </table:tableModel>
                </div>
            </form>
            <div class="col-md-12 text-right">
                <a href="${pageContext.request.contextPath}/manage/partnerManage/toAdd" class="btn btn-primary"><i
                        class="icon-plus"></i>新增合作平台信息</a>
                <!--  <a href="#" class="btn btn-primary"><i class="icon-plus"></i>生成密钥</a> -->
            </div>
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
<!-- page content end -->
</body>
<script type="text/javascript">
    //删除
    function deleteData(id) {
        bootbox.confirm('您确定要删除该条数据吗？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/manage/partnerManage/delete/' + id;
                return false;
            }
        });
    }

    //状态开关
    function changeStatus(id, status) {
        var clickEvent = $("#status_" + id).attr("onclick");
        $("#status_" + id).removeAttr("onclick");
        jQuery.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/manage/partnerManage/changeStatus/' + status + '/' + id,
            success: function (data) {
                bootbox.alert(data.msg);
                if (status == 'open') {
                    $("#status_" + id).attr("onclick", "changeStatus('" + id + "','close')");
                    $("#status_" + id).html('<i class="icon-plus"></i>暂停');
                } else if (status == 'close') {
                    $("#status_" + id).attr("onclick", "changeStatus('" + id + "','open')");
                    $("#status_" + id).html('<i class="icon-plus"></i>开启');
                }
            },
            error: function (data) {
                $("#status_" + id).attr("onclick", clickEvent);
            }
        });
    }

    //生成密钥
    function genarateKey(id) {
        var clickEvent = $("#key_" + id).attr("onclick");
        $("#key_" + id).removeAttr("onclick");
        jQuery.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/manage/partnerManage/genarateKey/' + id,
            success: function (data) {
                bootbox.alert(data.msg);
                $("#key_" + id).attr("onclick", clickEvent);
            },
            error: function (data) {
                $("#key_" + id).attr("onclick", clickEvent);
            }
        });
    }
</script>
</html>
