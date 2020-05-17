<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>财产险保单管理</title>
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
                    <h4>财产险保单管理</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/ccxbd/query"
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
                                        <span class="input-group-addon">被保人</span> <input name="bbr" type="text"
                                                                                          class="form-control"
                                                                                          value="${bbr }"/>
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
                                        <%--<span class="input-group-addon" class="select-label">保险公司</span>--%>
                                        <%--<itech:code property="cbgs" code="ccxbd.cbgs" type="select" value="${borrowerType }" />--%>
                                        <span class="input-group-addon">保险公司</span> <input name="cbgs" type="text"
                                                                                           class="form-control"
                                                                                           value="${cbgs }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon" class="select-label">是否结算</span>
                                        <itech:code property="sfjs" code="ccxbd.sf" type="select" value="${sfjs}"/>
                                    </div>
                                </div>
                                <!--开始 -->
                                <div class="form-group col-md-3 col-xs-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">投保开始日期</span>

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
                                        <span class="input-group-addon">投保结束日期</span>

                                        <div class="input-group date">
                                            <input id="endDate" name="endDate" size="30" type="text"
                                                   class="form-control data2 loanDatepicker" readonly="readonly"
                                                   value="${endDate}"/>
                                            <span class="input-group-addon"> <span
                                                    class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
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
                                    <button type="button" onclick="importCcxbd()" class="btn btn-primary">
                                        <i class="glyphicon glyphicon-import"></i>批量导入
                                    </button>
                                    <%--<button type="button" id="tempbutton" class="btn btn-primary">
                                        <i class="icon-search"></i>下载模板
                                    </button>--%>
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
                                        <table:htmlColumn property="tbr" title="投保人" width="5%" sortable="true"/>
                                        <table:htmlColumn property="bbr" title="被保人" width="5%"/>
                                        <table:htmlColumn property="tbrq" title="投保日期" width="5%"/>
                                        <table:htmlColumn property="bdh" title="投保单号" width="5%"/>
                                        <table:htmlColumn property="xzmc" title="险种名称" width="5%"/>
                                        <table:htmlColumn property="cbgs" title="保险公司" width="5%"/>
                                        <table:htmlColumn property="cbjg" title="承保机构" width="5%"/>
                                        <table:htmlColumn property="tdgr" title="团队/个人" width="5%"/>
                                        <table:htmlColumn property="sfgb" title="是否共保" width="5%"/>
                                        <table:htmlColumn property="hsbf" title="含税保费" width="5%"/>
                                        <table:htmlColumn property="sxfbl" title="手续费比例" width="5%"/>
                                        <table:htmlColumn property="sxfje" title="手续费金额" width="5%"/>
                                        <table:htmlColumn property="ywy" title="代理人" width="5%"/>
                                        <table:htmlColumn property="sfjs" title="是否结算" width="5%"/>
                                        <table:htmlColumn title="操作" width="10%" sortable="false">
                                            <a href='${pageContext.request.contextPath}/business/ccxbd/toAdd?id=${bean.id}'>编辑</a>
                                            <a href="javascript:deleteData('${bean.id}')" title="删除">删除</a>
                                        </table:htmlColumn>
                                    </table:htmlRow>
                                </table:htmlTable>
                            </table:tableModel>
                        </div>
                    </form>
                    <div class="col-sm-offset-6 col-sm-12"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-10 col-md-12">
                    <a href="${pageContext.request.contextPath}/business/ccxbd/toAdd" class="btn btn-primary"><i
                            class="icon-plus"></i>新增</a>
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
                location.href = '${pageContext.request.contextPath}/business/ccxbd/delete?id=' + id;
                return false;
            }
        });
    }

    function used(id) {
        bootbox.confirm('确定启用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/ccxbd/updateStatusById?status=used&id=' + id;
                return false;
            }
        });
    }

    function stop(id) {
        bootbox.confirm('确定停用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/ccxbd/updateStatusById?status=stop&&id=' + id;
                return false;
            }
        });
    }

    function importCcxbd() {
        var url = "${pageContext.request.contextPath}/business/ccxbd/importCcxbd";
        $.colorbox({iframe: true, width: "100%", height: "100%", scrolling: true, href: url});
    }

    function importCcxbdBatch() {
        var url = "${pageContext.request.contextPath}/business/ccxbd/importCcxbdBatch";
        $.colorbox({iframe: true, width: "100%", height: "100%", scrolling: true, href: url});
    }

    $("#exportBtn").bind("click", function () {
        window.location.href = "${pageContext.request.contextPath }/business/ccxbd/exportExcel?" + $('#searchForm').serialize();
    });
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
