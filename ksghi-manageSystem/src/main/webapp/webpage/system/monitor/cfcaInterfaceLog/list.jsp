<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>安心签调用监控</title>
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
                <li class="active">安心签调用监控</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>安心签日志列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" class="form-inline" name="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/cfcainterfacelog/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">接口类型</span>
                                        <select id="roleType" name="businessType" class="form-control">
                                            <option value="">请选择</option>
                                            <option value="3001"
                                                    <c:if test="${businessType == '3001'}">selected="selected"</c:if> >
                                                个人用户注册
                                            </option>
                                            <option value="3002"
                                                    <c:if test="${businessType == '3002'}">selected="selected"</c:if> >
                                                企业用户注册
                                            </option>
                                            <option value="3203"
                                                    <c:if test="${businessType == '3203'}">selected="selected"</c:if> >
                                                合同签章
                                            </option>
                                        </select>
                                    </div>
                                </div>
                                <!-- 总开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">开始日期</span>
                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">结束日期</span>
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
                            </div>
                            <!-- 总结束 -->
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="TX_CODE" title="接口类型" width="20%">
                                            <c:if test="${bean.TX_CODE == '3001'}">
                                                个人用户注册
                                            </c:if>
                                            <c:if test="${bean.TX_CODE == '3002'}">
                                                企业用户注册
                                            </c:if>
                                            <c:if test="${bean.TX_CODE == '3203'}">
                                                合同签章
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="REQ" title="请求参数" width="30%">
                                            <c:if test="${not empty bean.REQ}">
                                                <a style="cursor: pointer;" onclick="viewContent(this)">&lt;查看详情&gt;</a>
                                                <div style="display: none;">${bean.REQ}</div>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="RES" title="返回参数" width="30%">
                                            <c:if test="${not empty bean.RES}">
                                                <a style="cursor: pointer;" onclick="viewContent(this)">&lt;查看详情&gt;</a>
                                                <div style="display: none;">${bean.RES}</div>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATE_TIME" title="创建时间" width="20%"/>
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
    });

    function viewContent(currentObj) {
        var data = $(currentObj).next().html();
        $.colorbox({html: data, width: "60%", height: "60%", scrolling: true});
    }
</script>
</html>
