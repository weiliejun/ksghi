<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>活动专区管理列表</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>网站内容管理</li>
                <li>信息发布管理</li>
                <li class="active">活动专区管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>活动专区管理列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/website/activityzone/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!-- 总开始 -->
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动结束日期</span>

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
                                    <div class="input-group">
                                        <span class="input-group-addon">活动状态</span>
                                        <itech:code property="activitystatus" code="activitystatus" type="select"
                                                    value="${activitystatus}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动名称</span> <input name="name" type="text"
                                                                                           class="form-control"
                                                                                           value="${name }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-4">
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
                                        <table:htmlColumn property="name" title="活动名称" width="12%"/>
                                        <table:htmlColumn property="startDate" title="活动有效期" width="15%"/>

                                        <table:htmlColumn property="status" title="活动状态" width="5%">
                                            <itech:code code="activitystatus" type="text" value="${bean.status}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="description" title="活动说明" width="18%"/>
                                        <table:htmlColumn property="activityUrl" title="活动链接URL" width="15%"/>

                                        <table:htmlColumn property="createTime" title="创建时间" width="13%"/>
                                        <table:htmlColumn property="isPlacedTop" title="是否置顶" width="3%">
                                            <itech:code code="activityistop" type="text" value="${bean.isPlacedTop}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="workStatus" title="状态" width="5%">
                                            <itech:code code="advertise.status" type="text" value="${bean.workStatus}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="clicks" title="点击次数" width="3%"/>
                                        <table:htmlColumn title="数据操作" width="10%" sortable="false">
                                            <a title="预览" onclick="viewActivity('${bean.activityUrl}');"><i
                                                    class="icon-binoculars"></i></a>
                                            <a href="${pageContext.request.contextPath}/business/website/activityzone/edit/${bean.id}"
                                               title="编辑"><i class="icon-pencil"></i></a>
                                            <c:if test="${bean.workStatus == 'unable' }">
                                                <a href="${pageContext.request.contextPath}/business/website/activityzone/enable/${bean.id}"
                                                   title="启用">已停用</a>
                                            </c:if>
                                            <c:if test="${bean.workStatus == 'enable' }">
                                                <a href="${pageContext.request.contextPath}/business/website/activityzone/unable/${bean.id}"
                                                   title="停用">已启用</a>
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
                    <a href="${pageContext.request.contextPath}/business/website/activityzone/add"
                       class="btn btn-primary"><i class="icon-plus"></i>新增活动展示</a>
                </div>
            </div>

        </div>
    </div>
    <!-- page content end -->
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });

    function viewActivity(url) {
        //window.open("${previewUrl}"+url);
        window.open(url);
    }
</script>
</html>
