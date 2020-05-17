<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒体用户出借佣金管理－用户出借明细</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li class="active">媒体业绩统计管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        媒体用户出借佣金管理－用户出借明细
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/media/childChannelNumberdetail"
                          role="form">
                        <input type="hidden" name="souceCode" value="${souceCode }"/> <input type="hidden"
                                                                                             name="orgCode"
                                                                                             value="${orgCode }"/>
                        <input type="hidden" name="back" value="${back }"/>
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group" style="padding-left: 0px;">
                                    <label class="control-label">成标时间</label>
                                    <div class="input-group-div">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar"></i></span> <input
                                                id="statisticsTime" name="statisticsTime" size="30" type="text"
                                                class="form-control" readonly="readonly" value="${statisticsTime}"/>
                                        </div>
                                    </div>
                                </div>
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
                        <div class="form-group">
                            <label>共<strong class="stat_strong">${totalMap.TOTAL }</strong>条记录，渠道来源：<strong
                                    class="stat_strong">${orgInfo.orgName }</strong>，出借金额合计：<strong
                                    class="stat_strong">${fnx:formateThousands(totalMap.TENDERSUMTOTAL,true)}</strong>元，佣金：<strong
                                    class="stat_strong">${fnx:formateThousands(totalMap.AMOUNTSUM,true)}</strong>元。
                            </label>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="TENDERLOAN_TIME" title="成标时间" width="10%"/>
                                        <table:htmlColumn property="USERNAME" title="出借人" width="9%"/>
                                        <table:htmlColumn property="MOBILE" title="手机号" width="8%"/>
                                        <table:htmlColumn property="CREATE_TIME" title="出借时间" width="8%"/>
                                        <table:htmlColumn property="CATEGORY" title="出借类型" width="8%">
                                            <itech:code code="tenderCategory" type="text" value="${bean.CATEGORY }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="INVEST_AMOUNT" title="出借金额(元)" width="8%">
                                            ${fnx:formateThousands(bean.INVEST_AMOUNT,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="INVEST_RATE" title="佣金比例(%/年)" width="8%">
                                            ${fnx:formateThousands(bean.INVEST_RATE,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="AMOUNT" title="佣金(元)" width="8%">
                                            ${fnx:formateThousands(bean.AMOUNT,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PRODUCTNAME" title="产品名称" width="8%"/>
                                        <table:htmlColumn property="TIME_LIMIT" title="产品期限" width="8%">
                                            ${bean.TIME_LIMIT }/<itech:code code="product.timeLimitUnit" type="text"
                                                                            value="${bean.TIME_LIMIT_UNIT }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="REPAY_END_DATE" title="结标时间" width="8%"/>
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
            </div>
            <div class="row">
                <div class="col-md-offset-10 col-md-2">
                    <c:if test="${back == '2' }">
                        <a href="${pageContext.request.contextPath }/business/cooperateorg/media/list/detail?mediaId=${orgInfo.id}">
                            <button id="goBackBtn" type="button" class="btn btn-primary">
                                <i class="icon-undo2"></i>返回
                            </button>
                        </a>
                    </c:if>
                    <c:if test="${back == '1' }">
                        <a href="${pageContext.request.contextPath }/business/cooperateorg/media/list">
                            <button id="goBackBtn" type="button" class="btn btn-primary">
                                <i class="icon-undo2"></i>返回
                            </button>
                        </a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $().ready(function () {
        $('#statisticsTime').daterangepicker();
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/media/childChannelNumberdetail/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>