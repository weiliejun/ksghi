<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户帐户管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li class="active">出借端合作机构管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        出借端合作机构信息列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/manage/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">机构名</span> <input class="form-control"
                                                                                          type="text" name="orgName"
                                                                                          value="${orgName}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">机构类型</span>
                                        <itech:code property="orgType" code="organization.orgType" type="select"
                                                    value="${orgType}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">支付方式</span>
                                        <itech:code property="paymentType" code="organization.paymentType" type="select"
                                                    value="${paymentType}"/>
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
                                        <table:htmlColumn property="ORG_NAME" title="机构名" width="15%"/>
                                        <table:htmlColumn property="COMPANY_MOBILE" title="公司电话" width="10%"/>
                                        <table:htmlColumn property="ADMIN_NAME" title="管理员" width="10%"/>
                                        <table:htmlColumn property="ADMIN_MOBILE" title="手机号码" width="10%"/>
                                        <table:htmlColumn property="ORG_CODE" title="机构码" width="6%"/>
                                        <table:htmlColumn property="ORG_TYPE" title="机构类型" width="6%"/>
                                        <table:htmlColumn property="TIME_LIMIT" title="结算周期(月)" width="6%"/>
                                        <table:htmlColumn property="CREATE_TIME" title="创建时间" width="10%"/>
                                        <table:htmlColumn property="USERCOUNT" title="员工数" width="5%"/>
                                        <table:htmlColumn property="REGISTERCOUNT" title="注册数" width="5%"/>
                                        <table:htmlColumn title="数据操作" width="25%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/detail/${bean.ID}">查看详情</a>
                                            <c:if test="${bean.ORG_TYPE == '媒体' }">
                                                <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/edit?id=${bean.ID}">查看</a>
                                            </c:if>
                                            <c:if test="${bean.ORG_TYPE == '渠道' || bean.ORG_TYPE == '加盟商' }">
                                                <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/edit?id=${bean.ID}">编辑</a>
                                            </c:if>
                                            <c:if test="${bean.STATUS == 'stop'}">
                                                <a onclick="editOrgStatus('${bean.ID}');">立即合作</a>
                                            </c:if>
                                            <c:if test="${bean.STATUS == 'cooperation'}">
                                                <a onclick="editOrgStatus('${bean.ID}');">暂停合作</a>
                                            </c:if>
                                            <c:if test="${bean.ORG_TYPE == '渠道' ||bean.ORG_TYPE == '加盟商' }">
                                                <a class="setCommission"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/list/${bean.ID}">佣金比例设置</a>
                                            </c:if>
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
                    <a href="${pageContext.request.contextPath}/business/cooperateorg/manage/edit"
                       class="btn btn-primary"><i class="icon-plus"></i>新增机构</a>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $().ready(function () {
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/manage/list/exportExcel?" + $('#searchForm').serialize();
        });
    });

    function editOrgStatus(id) {
        bootbox.confirm('是否确认提交？', function (confirmed) {
            if (confirmed) {
                $.ajax({
                    type: "get",
                    url: "${pageContext.request.contextPath }/business/cooperateorg/manage/edit/status",
                    data: {id: id},
                    success: function (data) {
                        if (!data) {
                            bootbox.alert("操作失败");
                        } else {
                            location.reload();
                        }
                    },
                    error: function (data) {
                        bootbox.alert("请求失败，刷新页面重试！");
                    }

                });
            }
        });
    }

    $(".setCommission").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
</script>
</html>
