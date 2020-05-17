<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>媒体业绩统计管理</title>
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
                        媒体业绩统计列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-border">
                    <form id="searchForm" class="form-inline" name="roleForm"
                          action="${pageContext.request.contextPath}/business/cooperateorg/media/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">媒体名称</span> <input class="form-control"
                                                                                           type="text" name="mediaName"
                                                                                           value="${mediaName}">
                                    </div>
                                </div>

                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">统计开始日期：</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">统计结束日期：</span>

                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
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
								<span>共<strong class="stat_strong">${totalMap.TOTAL }</strong>条记录，出借金额合计：<strong
                                        class="stat_strong">${fnx:formateThousands(totalMap.TENDERTOTAL,true)}</strong>元，佣金：<strong
                                        class="stat_strong">${fnx:formateThousands(totalMap.PAYMENTTOTAL,true)}</strong>元。
								</span>
                        </div>

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="ORG_NAME" title="媒体名称" width="10%"/>
                                        <table:htmlColumn property="REGISTCOUNT" title="注册用户数" width="9%">
                                            <c:if test="${bean. REGISTCOUNT== null }">0</c:if>
                                            <c:if test="${bean.REGISTCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${bean.ORGID}&timeStatus=register">${bean.REGISTCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="OPENACCOUNTCOUNT" title="开户用户数" width="8%">
                                            <c:if test="${bean.OPENACCOUNTCOUNT == null }">0</c:if>
                                            <c:if test="${bean.OPENACCOUNTCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${bean.ORGID}&timeStatus=openAccount&openType=true">${bean.OPENACCOUNTCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="BANKCARDCOUNT" title="绑卡用户数" width="8%">
                                            <c:if test="${bean.BANKCARDCOUNT == null }">0</c:if>
                                            <c:if test="${bean.BANKCARDCOUNT != null }">
                                                <a class="userDetail"
                                                   href="${pageContext.request.contextPath}/business/cooperateorg/media/userlist?orgId=${bean.ORGID}&timeStatus=bankCard&bankCard=true">${bean.BANKCARDCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="TENDERCOUNT" title="出借用户数" width="8%">
                                            <c:if test="${bean.TENDERCOUNT == null || bean.TENDERCOUNT == 0}">0</c:if>
                                            <c:if test="${bean.TENDERCOUNT != null && bean.TENDERCOUNT != 0}">
                                                <a href="${pageContext.request.contextPath}/business/cooperateorg/media/childChannelNumberdetail?orgCode=${bean.ORGCODE}&back=1">${bean.TENDERCOUNT }</a>
                                            </c:if>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="SUMTENDER" title="出借金额合计(元)" width="8%">
                                            ${fnx:formateThousands(bean.SUMTENDER,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="PAYMENTSUM" title="佣金(元)" width="8%">
                                            ${fnx:formateThousands(bean.PAYMENTSUM,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="REPAYEDSUM" title="已付金额(元)" width="8%">
                                            ${fnx:formateThousands(bean.REPAYEDSUM,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="NEW_USER_NAME" title="待付金额(元)" width="8%">
                                            ${fnx:formateThousands(bean.PAYMENTSUM-bean.REPAYEDSUM,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="DO" title="操作" width="10%" sortable="false">
                                            <a href="${pageContext.request.contextPath}/business/cooperateorg/media/list/detail?mediaId=${bean.ORGID}">查看明细</a>
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
            </div>
        </div>
    </div>
    <div class="col-sm-offset-6 col-sm-12"></div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    $().ready(function () {
        $(".userDetail").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        //$('#statisticsTime').daterangepicker();
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
        $("#exportBtn").bind("click", function () {
            window.location.href = "${pageContext.request.contextPath }/business/cooperateorg/media/list/exportExcel?" + $('#searchForm').serialize();
        });
    });
</script>
</html>
