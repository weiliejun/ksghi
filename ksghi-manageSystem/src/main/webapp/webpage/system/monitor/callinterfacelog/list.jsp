<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>操作存管银行接口调用监控</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>
<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>系统监控数据管理</li>
                <li class="active">操作存管银行接口调用监控</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>操作存管银行接口调用监控列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="searchForm" id="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/callinterfacelog/list">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户姓名</span> <input class="form-control"
                                                                                           type="text" name="name"
                                                                                           value="${name}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">手机号码</span> <input class="form-control"
                                                                                           type="text" name="mobile"
                                                                                           value="${mobile}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">用户客户号</span> <input class="form-control"
                                                                                            type="text" name="usrCustId"
                                                                                            value="${usrCustId}">
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">接口业务类型</span>
                                        <itech:code type="select" property="cmdId" code="callInterfaceLog.cmdId"
                                                    value="${cmdId}"/>
                                    </div>
                                </div>
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
                                        <table:htmlColumn property="USR_NAME" title="用户姓名" width="8%"/>
                                        <table:htmlColumn property="USR_MP" title="手机号码" width="9%"/>
                                        <table:htmlColumn property="USR_CUST_ID" title="用户客户号" width="9%"/>
                                        <table:htmlColumn property="VERSION" title="版本号" width="6%"/>
                                        <table:htmlColumn property="CMD_ID" title="接口业务类型" width="10%">
                                            <itech:code type="text" code="callInterfaceLog.cmdId"
                                                        value="${bean.CMD_ID}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="ORD_DATE" title="订单日期" width="8%"/>
                                        <table:htmlColumn property="TRX_ID" title="存管银行交易唯一标识" width="10%"/>
                                        <table:htmlColumn property="IN_CUST_ID" title="交易对方客户号" width="10%"/>
                                        <table:htmlColumn property="TRANS_AMT" title="交易金额" width="8%"/>
                                        <table:htmlColumn property="RESP_CODE" title="应答返回码" width="10%"/>
                                        <table:htmlColumn property="RESP_DESC" title="应答描述" width="8%">
                                            <%-- <c:if test="${fn:length(bean.RESP_DESC) gt 4}">
                                            ${fn:substring(bean.RESP_DESC,0,4)}...
                                        </c:if>
                                        <c:if test="${fn:length(bean.RESP_DESC) le 4}">
                                            ${bean.RESP_DESC}
                                        </c:if> --%>
                                            ${bean.RESP_DESC}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="SEC_RESP_CODE" title="二级应答返回码" width="10%"/>
                                        <table:htmlColumn property="SEC_RESP_DESC" title="二级应答描述" width="10%"/>
                                        <table:htmlColumn property="RESP_CONTENT" title="存管银行返回内容串" width="10%">
                                            <c:if test="${not empty bean.RESP_CONTENT}">
                                                <a style="cursor: pointer;" onclick="viewContent(this)"
                                                   data-Field="${bean.ID}">&lt;查看详情&gt;</a>
                                                <div id="content_${bean.ID}"
                                                     style="display: none;">${bean.RESP_CONTENT}</div>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="REQUEST_CONTENT" title="请求内容" width="9%">
                                            <c:if test="${not empty bean.REQUEST_CONTENT}">
                                                <a style="cursor: pointer;" onclick="viewContent(this)"
                                                   data-Field="${bean.ID}2">&lt;查看详情&gt;</a>

                                                <div id="content_${bean.ID}2"
                                                     style="display: none;">${bean.REQUEST_CONTENT}</div>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATE_TIME" title="创建时间" width="9%"/>
                                        <table:htmlColumn property="RESP_TIME" title="存管银行返回时间" width="10%"/>
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
    $(document).ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });

    function viewContent(currentObj) {
        var id = $(currentObj).attr("data-Field");
        $.colorbox({html: $("#content_" + id).html(), width: "60%", height: "60%", scrolling: true});
    }
</script>
</html>
