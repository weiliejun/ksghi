<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>业绩查询分析</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/css/jmesa.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/css/daterangepicker.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jquery.jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/table/jmesa/js/jmesa.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/date.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/ui/core/plugins/date/daterangepicker/js/daterangepicker.js"></script>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>邮寄保单查询</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/xqyzy/query"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!-- 总开始 -->
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">投保人</span> <input name="tbr" type="text"
                                                                                          class="form-control"
                                                                                          value="${tbr }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">保单号</span> <input name="bdh" type="text"
                                                                                          class="form-control"
                                                                                          value="${bdh }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">代理人</span> <input name="ywy" type="text"
                                                                                          class="form-control"
                                                                                          value="${ywy }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon" class="select-label">所属公司</span>
                                        <itech:code property="ssgs" code="xsrygl.ssgs" type="select" value="${ssgs }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon" class="select-label">部门（机构）</span>
                                        <itech:code property="dept" code="xsrygl.dept" type="select" value="${dept }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">保险公司</span> <input name="cbgs" type="text"
                                                                                           class="form-control"
                                                                                           value="${cbgs }"/>
                                    </div>
                                </div>

                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">投保起期</span>

                                        <div class="input-group date">
                                            <input id="startDate" name="startDate" type="text"
                                                   class="fl form-control data2 expireDatepicker" readonly="readonly"
                                                   value="${startDate}"/>
                                            <span class="input-group-addon"> <span
                                                    class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">投保止期</span>

                                        <div class="input-group date">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                            <span class="input-group-addon"> <span
                                                    class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <input id="cxmk" name="cxmk" type="hidden" class="form-control" value="yjbdcx"/>
                                <!--结束 -->
                                <!-- 开始 -->
                                <div class="form-group col-md-4 col-xs-6">
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

                                <!--结束 -->
                                <!-- 总结束 -->
                            </div>
                        </div>

                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="bdh" title="保单号" width="5%"/>
                                        <table:htmlColumn property="tbrq" title="投保日期" width="5%"/>
                                        <table:htmlColumn property="tbr" title="投保人" width="5%"/>
                                        <table:htmlColumn property="tbrsjh" title="手机号码" width="5%"/>
                                        <table:htmlColumn property="bbr" title="被保人" width="5%"/>
                                        <table:htmlColumn property="bbrsjh" title="手机号码" width="5%"/>
                                        <table:htmlColumn property="gx" title="关系" width="5%"/>
                                        <table:htmlColumn property="cbgs" title="保险公司" width="5%"/>
                                        <table:htmlColumn property="xzmc" title="险种名称" width="5%"/>
                                        <table:htmlColumn property="jffs" title="缴费方式" width="5%"/>
                                        <table:htmlColumn property="jfnq" title="缴费年期" width="5%"/>
                                        <table:htmlColumn property="bxqj" title="保险期间" width="5%"/>
                                        <table:htmlColumn property="bxje" title="保险金额" width="5%"/>
                                        <table:htmlColumn property="sjbf" title="规模保费" width="5%"/>
                                        <table:htmlColumn property="ywy" title="代理人" width="5%"/>
                                        <table:htmlColumn property="ywybh" title="代理人工号" width="5%"/>
                                        <table:htmlColumn property="yjzt" title="邮寄状态" width="5%"/>

                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- page content end -->
</div>
</body>

<script type="text/javascript">
    function onInvokeAction(id) {
        $.jmesa.setExportToLimit(id, '');
        $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
    }

    $().ready(function () {
        $("input[name='startDate']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='endDate']").datepicker({format: 'yyyy-mm-dd'});
    });

    function deleteData(id) {
        bootbox.confirm("您确定要删除该记录吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xqyzy/bdcb/delete?id=' + id;
                return false;
            }
        });
    }

    function used(id) {
        bootbox.confirm('确定启用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xqyzy/bdcb/updateStatusById?status=used&id=' + id;
                return false;
            }
        });
    }

    function stop(id) {
        bootbox.confirm('确定停用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xqyzy/bdcb/updateStatusById?status=stop&&id=' + id;
                return false;
            }
        });
    }

    function importCcxbd() {
        var url = "${pageContext.request.contextPath}/business/xqyzy/bdcb/importCcxbd";
        $.colorbox({iframe: true, width: "100%", height: "100%", scrolling: true, href: url});
    }

    function importCcxbdBatch() {
        var url = "${pageContext.request.contextPath}/business/xqyzy/bdcb/importCcxbdBatch";
        $.colorbox({iframe: true, width: "100%", height: "100%", scrolling: true, href: url});
    }

    $("#exportBtn").bind("click", function () {
        window.location.href = "${pageContext.request.contextPath }/business/xqyzy/bdcb/exportExcel?" + $('#searchForm').serialize();
    });
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
