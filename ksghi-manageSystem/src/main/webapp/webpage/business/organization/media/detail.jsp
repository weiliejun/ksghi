<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒体用户出借佣金管理</title>
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
                        媒体用户出借佣金管理详情
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/media/list/detail"
                          role="form">
                        <input type="hidden" name="mediaId" value="${orgInfo.id }"/>
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="select-label">子渠道编号</label> <input class="form-control" type="text"
                                                                                     name="channelNumber"
                                                                                     value="${channelNumber}">
                                </div>
                                <div class="form-group" style="padding-left: 0px;">
                                    <label class="control-label">统计时间</label>
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
                            <label>共<strong class="stat_strong">${totalMap.TOTAL }</strong>条记录，媒体名称：<strong
                                    class="stat_strong">${orgInfo.orgName }</strong>，出借金额合计：<strong
                                    class="stat_strong">${fnx:formateThousands(totalMap.TENDERSUMTOTAL,true)}</strong>元，佣金：<strong
                                    class="stat_strong">${fnx:formateThousands(totalMap.PAYMENTSUMTOTAL,true)}</strong>元。
                            </label>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="SOURCE_CODE" title="子渠道编号" width="10%"/>
                                        <table:htmlColumn property="REGISTERCOUNT" title="注册用户数" width="9%">
                                            <c:if test="${bean. REGISTERCOUNT== null }">0</c:if>
                                            <c:if test="${bean.REGISTERCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${orgInfo.id}&timeStatus=register&souceCode=${bean.SOURCE_CODE}">${bean.REGISTERCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="OPENACCOUNTCOUNT" title="开户用户数" width="8%">
                                            <c:if test="${bean.OPENACCOUNTCOUNT == null }">0</c:if>
                                            <c:if test="${bean.OPENACCOUNTCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${orgInfo.id}&timeStatus=openAccount&openType=true&souceCode=${bean.SOURCE_CODE}">${bean.OPENACCOUNTCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="BANKCARDCOUNT" title="绑卡用户数" width="8%">
                                            <c:if test="${bean.BANKCARDCOUNT == null }">0</c:if>
                                            <c:if test="${bean.BANKCARDCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${orgInfo.id}&timeStatus=bankCard&bankCard=true&souceCode=${bean.SOURCE_CODE}">${bean.BANKCARDCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="TENDERCOUNT" title="出借用户数" width="8%">
                                            <c:if test="${bean.TENDERCOUNT == null || bean.TENDERCOUNT == 0}">0</c:if>
                                            <c:if test="${bean.TENDERCOUNT != null && bean.TENDERCOUNT != 0}">
                                                <a href="${pageContext.request.contextPath}/business/cooperateorg/media/childChannelNumberdetail?orgCode=${orgInfo.orgCode}&souceCode=${bean.SOURCE_CODE}&back=2">${bean.TENDERCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="TENDERSUM" title="出借金额合计(元)" width="8%">
                                            ${fnx:formateThousands(bean.TENDERSUM,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PAYMENTSUM" title="佣金(元)" width="8%">
                                            ${fnx:formateThousands(bean.PAYMENTSUM,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="DO" title="操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/cooperateorg/media/childChannelNumberdetail?souceCode=${bean.SOURCE_CODE}&orgCode=${orgInfo.orgCode}&back=2">查看明细</a>
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
                    <button onclick="goBack();" type="button" class="btn btn-primary">
                        <i class="icon-undo2"></i>返回
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    function goBack() {
        window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/media/list";
    }

    $().ready(function () {
        $(".userDetail").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        $('#statisticsTime').daterangepicker();
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/media/list/detail/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>