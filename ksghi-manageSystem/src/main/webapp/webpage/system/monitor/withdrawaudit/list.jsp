<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>提现审核监控</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>系统监控数据管理</li>
                <li class="active">提现审核监控</li>
            </ul>
        </div>
    </div>
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>提现审核列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form name="roleForm" id="searchForm"
                          action="${pageContext.request.contextPath}/system/monitor/withdrawaudit/list"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">客户姓名</span> <input class="form-control"
                                                                                           type="text" name="corpName"
                                                                                           value="${corpName}">
                                    </div>
                                </div>
                                <!--开始 -->

                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">审核状态</span>
                                        <itech:code property="auditStatus" code="withdraw.auditStatus" type="select"
                                                    value="${auditStatus}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">提现状态</span>
                                        <itech:code property="respStatus" code="withdraw.respStatus" type="select"
                                                    value="${respStatus}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">是否需要审核</span>
                                        <itech:code property="isAuditor" code="product.noviceProduct" type="select"
                                                    value="${isAuditor}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">提现申请开始日期</span>

                                        <div class="num fl">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">提现申请结束日期</span>

                                        <div class="num fl">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-xs-6">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                    <button type="button" id="huifu" class="btn btn-primary" onclick=""
                                            data-loading-text="处理中...">
                                        <i class="icon-loop2"></i>存管银行审核
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="CORP_NAME" title="客户姓名" width="15%">
                                            ${bean['CORP_NAME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="OPEN_BANK_ID" title="提现银行" width="15%">
                                            <itech:code type="text" code="bankAcronym" value="${bean.OPEN_BANK_ID }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="OPEN_ACCT_ID" title="银行卡号" width="10%">
                                            ${bean['OPEN_ACCT_ID'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="TRANS_AMOUNT" title="提现金额" width="10%">
                                            ${fnx:formateThousands(bean.TRANS_AMOUNT,true)}
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CREATE_TIME" title="提现申请时间" width="10%">
                                            ${bean['CREATE_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="AUDIT_TIME" title="审核时间" width="10%">
                                            ${bean['AUDIT_TIME'] }
                                        </table:htmlColumn>
                                        <table:htmlColumn property="AUDIT_STATUS" title="审核状态" width="10%">
                                            <itech:code property="auditStatus" code="withdraw.auditStatus" type="text"
                                                        value="${bean['AUDIT_STATUS'] }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="RESP_STATUS" title="提现状态" width="10%">
                                            <itech:code property="respStatus" code="withdraw.respStatus" type="text"
                                                        value="${bean['RESP_STATUS'] }"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="ISAUDITOR" title="是否需要审核" width="10%">
                                            <itech:code property="isAuditor" code="product.noviceProduct" type="text"
                                                        value="${bean['ISAUDITOR'] }"/>
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
        </div>
    </div>
    <!-- page content end -->
</div>

</body>
<script>
    $(document).ready(function () {
        $("#huifu").click(function () {
            var loading = '<img src="${pageContext.request.contextPath }/assets/ui/themes/base/img/finance/loading.gif">处理中...';
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/business/hebeicorp/withdrawaudit/manage/list/audit",
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
                    //bootbox.alert("处理完成！", function() {
                    window.location.href = "${pageContext.request.contextPath}/system/monitor/withdrawaudit/list";
                    //});
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    bootbox.alert("请求失败，请刷新页面后重试！");
                    return false;
                }
            });

        });
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });


</script>
</html>
