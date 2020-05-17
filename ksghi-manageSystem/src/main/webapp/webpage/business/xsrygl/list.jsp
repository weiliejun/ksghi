<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>销售人员管理</title>
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
                    <h4>入职信息列表</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" action="${pageContext.request.contextPath}/business/xsrygl/query"
                          class="form-inline" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!-- 总开始 -->
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">员工姓名</span> <input name="name" type="text"
                                                                                           class="form-control"
                                                                                           value="${name }"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">推荐人</span> <input name="tjr" type="text"
                                                                                          class="form-control"
                                                                                          value="${tjr }"/>
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
                                        <span class="input-group-addon" class="select-label">状态</span>
                                        <itech:code property="status" code="xsrygl.status" type="select"
                                                    value="${status}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon" class="select-label">职级</span>
                                        <itech:code property="rank" code="xsrygl.rank" type="select" value="${rank}"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-3 col-xs-4">
                                    <div class="input-group">
                                        <span class="input-group-addon" class="select-label">不含内勤</span>
                                        <itech:code property="bhnq" code="ccxbd.sf" type="select" value="${bhnq}"/>
                                    </div>
                                    <%--<input type="hidden" name="bhnq" value="0">--%>
                                    <%--<input id="bhnq" name="bhnq" type="checkbox" class="form-control"  onclick="javascript:document.getElementById('bhnq').value=this.checked;" ${bhnq=='true'?'checked=checked;':'' }/>不含内勤--%>
                                </div>
                                    <input id="cxmk" name="cxmk" type="hidden" class="form-control" value="xsry"/>
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
                                        <table:htmlColumn property="name" title="员工姓名" width="5%" sortable="true"/>
                                        <table:htmlColumn property="code" title="员工工号" width="5%"/>
                                        <table:htmlColumn property="mobile" title="手机号码" width="5%"/>
                                        <table:htmlColumn property="idNo" title="身份证号" width="5%"/>
                                        <table:htmlColumn property="rank" title="职级" width="5%"/>
                                        <table:htmlColumn property="ssgs" title="所属公司" width="5%"/>
                                        <table:htmlColumn property="dept" title="部门（机构）" width="5%"/>
                                        <table:htmlColumn property="status" title="状态" width="5%"/>
                                        <table:htmlColumn property="rssj" title="入司时间" width="5%"/>
                                        <table:htmlColumn title="操作" width="10%" sortable="false">
                                            <a href='${pageContext.request.contextPath}/business/xsrygl/toAdd?id=${bean.id}&status=bz'>编辑</a>
                                            <%--<a href='${pageContext.request.contextPath}/business/xsrygl/toAdd?id=${bean.id}&status=zsyg'>正式</a>--%>
                                            <a href='${pageContext.request.contextPath}/business/xsrygl/toAdd?id=${bean.id}&status=lz'>离职</a>
                                            <a href='${pageContext.request.contextPath}/business/xsrygl/view?id=${bean.id}'>查看</a>
                                            <%--<a href="javascript:deleteData('${bean.id}')" title="删除">删除</a>--%>
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
                    <a href="${pageContext.request.contextPath}/business/xsrygl/toAdd?status=xz"
                       class="btn btn-primary"><i
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
                location.href = '${pageContext.request.contextPath}/business/xsrygl/delete?id=' + id;
                return false;
            }
        });
    }

    function used(id) {
        bootbox.confirm('确定启用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xsrygl/updateStatusById?status=used&id=' + id;
                return false;
            }
        });
    }

    function stop(id) {
        bootbox.confirm('确定停用此LOGO？', function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xsrygl/updateStatusById?status=stop&&id=' + id;
                return false;
            }
        });
    }

    $("#exportBtn").bind("click", function () {
        window.location.href = "${pageContext.request.contextPath }/business/xsrygl/exportExcel?" + $('#searchForm').serialize();
    });
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
