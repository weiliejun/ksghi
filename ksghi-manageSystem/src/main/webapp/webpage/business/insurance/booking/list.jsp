<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>保险产品预约记录</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>产品管理</li>
                <li>保险产品信息管理</li>
                <li class="active">保险产品预约记录</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>
                        预约记录列表
                        <small></small>
                    </h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form id="searchForm" class="form-inline" name="searchForm"
                          action="${pageContext.request.contextPath}/business/insurance/order/list" role="form">
                        <div class="panel panel-search">
                            <div class="panel-body">
                                <!-- 总开始 -->
                                <div style="overflow: hidden; float: left;">
                                    <div class="form-group" style="overflow: hidden; float: left;">
                                        <label class="select-label">保险公司</label>
                                        <itech:code type="select" code="insurance.companyName" property="companyName"
                                                    value="${companyName}"/>
                                    </div>
                                    <div class="form-group" style="overflow: hidden; float: left;">
                                        <label class="select-label">上架状态</label>
                                        <itech:code type="select" code="fund.shelfState" property="upperAndLowerFrame"
                                                    value="${upperAndLowerFrame}"/>
                                    </div>
                                    <!--开始 -->
                                    <div style="overflow: hidden; float: left;">
                                        <div style="float: left; overflow: hidden;">
                                            <label class="" style="float: left; padding-top: 16px; padding-right: 6px;">预约时间</label>
                                            <div id="startTimeDiv" style="float: left;">
                                                <input id="startDate" style="width: 110px; margin-top: 8px;"
                                                       name="startDate" size="30" type="text" class="form-control"
                                                       readonly="readonly" value="${startDate}"/>
                                            </div>
                                        </div>
                                        <div style="float: left; overflow: hidden;">
                                            <label class=""
                                                   style="float: left; padding-top: 16px; padding-right: 16px; padding-left: 20px;">至</label>
                                            <div id="endTimeDiv" style="float: left;">
                                                <input id="endDate"
                                                       style="width: 110px; margin-top: 8px; margin-right: 20px;"
                                                       name="endDate" size="30" type="text" class="form-control"
                                                       readonly="readonly" value="${endDate}"/>
                                            </div>
                                        </div>

                                    </div>
                                    <!--结束 -->
                                    <!-- 开始 -->
                                    <div style="overflow: hidden; float: left;">
                                        <div class="form-group" style="float: left; overflow: hidden;">
                                            <label class="select-label">保险产品名称</label> <input type="text"
                                                                                              id="insuranceName"
                                                                                              name="insuranceName"
                                                                                              value="${insuranceName}"/>
                                        </div>
                                        <div class="form-group" style="float: left; overflow: hidden;">
                                            <label for="name">客户姓名</label> <input type="text" id="customerName"
                                                                                  name="customerName"
                                                                                  value="${customerName}"/>
                                        </div>
                                        <div class="form-group" style="float: left; overflow: hidden;">
                                            <label for="fundStatus">客户手机号</label> <input type="text" id="customerPhone"
                                                                                         name="customerPhone"
                                                                                         maxlength="11"
                                                                                         value="${customerPhone}"/>
                                        </div>
                                    </div>
                                    <!--结束 -->
                                </div>
                                <!-- 总结束 -->
                                <%-- <div class="form-group">
                                    <label class="select-label">保险公司</label>
                                    <itech:code type="select" code="insurance.companyName" property="companyName" value="${companyName}" />
                                </div>
                                <div class="form-group">
                                    <label class="select-label">上架状态</label>
                                    <itech:code type="select" code="fund.shelfState" property="upperAndLowerFrame" value="${upperAndLowerFrame}" />
                                </div>
                                <div class="form-group" style="padding-left: 0px;">
                                    <label class="control-label">预约时间</label>
                                    <div class="input-group-div">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="icon-calendar"></i></span> <input id="dateRange" name="dateRange" size="30" type="text" class="form-control" readonly="readonly" value="${dateRange}" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="select-label">保险产品名称</label> <input type="text" id="insuranceName" name="insuranceName" value="${insuranceName}" />
                                </div>
                                <div class="form-group">
                                    <label for="name">客户姓名</label> <input type="text" id="customerName" name="customerName" value="${customerName}" />
                                </div>
                                <div class="form-group">
                                    <label for="fundStatus">客户手机号</label> <input type="text" id="customerPhone" name="customerPhone" maxlength="11" value="${customerPhone}" />
                                </div>
--%>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="icon-search"></i>查询
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="myClearForm('searchForm')">
                                        <i class="icon-loop2"></i>清空
                                    </button>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;统计：共${total} 个预约， 今日新增 ${today}
                                    个，昨日预约 ${yesterday}
                                    个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
                                <button type="button" id="selectAll" class="btn btn-primary">
                                    <i class="icon-search"></i>全选
                                </button>
                                <button type="button" id="setSelected" class="btn btn-primary">
                                    <i class="icon-search"></i>批量设置预约状态
                                </button>
                                <button type="button" id="exportBtn" class="btn btn-primary">
                                    <i class="icon-search"></i><i class="icon-file-excel"></i>导出Excel
                                </button>
                            </div>
                        </div>
                        `
                        <div class="clearfix">
                            <table:tableModel id="grid" limit="${limit}" items="${results}" var="bean"
                                              stateAttr="restore">
                                <table:htmlTable width="100%">
                                    <table:htmlRow sortable="true" filterable="false">
                                        <table:htmlColumn property="全选"
                                                          title="<input type='checkbox' id='flag' onclick=\" setAllCheckboxState()\""
                                                          width="2%">
                                            <input type="checkbox" name="items" value="${bean.ID}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CODE" title="预约编号" width="6%"/>
                                        <table:htmlColumn property="CREATE_TIME" title="预约时间" width="6%"/>
                                        <table:htmlColumn property="NIKE_NAME" title="用户昵称" width="4%"/>
                                        <table:htmlColumn property="CUSTOMER_NAME" title="客户姓名" width="4%"/>
                                        <table:htmlColumn property="MOBILE" title="注册手机号" width="6%"/>
                                        <table:htmlColumn property="ID_NO" title="身份证号" width="5%"/>
                                        <table:htmlColumn property="PRODUCT_NAME" title="保险产品名称" width="6%"/>
                                        <table:htmlColumn property="COMPANY_NAME" title="保险公司" width="8%">
                                            <itech:code type="text" code="insurance.companyName" property="status"
                                                        value="${bean.COMPANY_NAME}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="CATEGORY" title="保险类型" width="6%"/>
                                        <table:htmlColumn property="INSURANCE_COVERAGE" title="投保范围" width="6%"/>
                                        <table:htmlColumn property="TIME_LIMIT" title="保险期间" width="5%"/>
                                        <table:htmlColumn property="PAY_TYPE" title="交费方式" width="5%"/>
                                        <table:htmlColumn property="CURRENCY_TYPE" title="投保币种" width="6%"/>
                                        <table:htmlColumn property="STATUS" title="预约状态" width="6%">
                                            <itech:code type="text" code="insurance.status" property="status"
                                                        value="${bean.STATUS}"/>
                                        </table:htmlColumn>
                                        <table:htmlColumn property="USER_NAME" title="推荐人姓名" width="6%"/>
                                        <table:htmlColumn property="STATUS_REMARK" title="预约状态说明" width="8%"/>
                                        <table:htmlColumn title="数据操作" width="8%" sortable="false">
                                            <a href="javascript:editStatus('${bean.ID }')" title="编辑预约状态">编辑预约状态</a>
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

<script type="text/javascript">
    $().ready(function () {
        $(".view-details").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
        //$('#dateRange').daterangepicker();
        $("#startTimeDiv").datetimepicker({
            format: "YYYY-MM-DD",
            //时分秒 如果为true 就可以选择时分秒
            useSeconds: false
        });

        $("#endTimeDiv").datetimepicker({
            format: "YYYY-MM-DD",
            //时分秒 如果为true 就可以选择时分秒
            useSeconds: false
        });
    });

    $("#exportBtn").bind("click", function () {
        var companyName = $('#companyName').val();
        var insuranceName = $('#insuranceName').val();
        var upperAndLowerFrame = $('#upperAndLowerFrame').val();
        var dateRange = $('#dateRange').val();
        var customerName = $('#customerName').val();
        var customerPhone = $('#customerPhone').val();
        window.location.href = "${pageContext.request.contextPath }/business/insurance/order/exportexcel?companyName=" + companyName + "&insuranceName=" + insuranceName + "&upperAndLowerFrame=" + upperAndLowerFrame + "&customerName=" + customerName + "&customerPhone=" + customerPhone + "&dateRange=" + dateRange;
    });

    function editStatus(id) {
        window.location.href = "${pageContext.request.contextPath}/business/insurance/order/editStatus/" + id;
    }

    function setAllCheckboxState() {
        var flag = document.getElementById("flag").checked;
        var elements = document.getElementsByName("items");
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].type != 'checkbox') {
                continue;
            } else {
                elements[i].checked = flag;
            }
        }
    }

    $("#selectAll").click(function () {
        var flag = document.getElementById("flag").checked;
        var elements = document.getElementsByName("items");
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].type != 'checkbox') {
                continue;
            } else {
                elements[i].checked = true;
            }
        }
    });

    $("#setSelected").bind("click", function () {
        var elements = document.getElementsByName("items");
        var ids = "";
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].checked) {
                if (ids.length == 0) {
                    ids = elements[i].value;
                } else {
                    ids = ids + ',' + elements[i].value;
                }
            }
        }
        if (ids == '') {
            alert("请选择相关记录！");
        } else {
            window.location = "${pageContext.request.contextPath }/business/insurance/order/editsel/" + ids;
        }
    });
</script>
</html>