<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>机构项目佣金录入</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/address.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>业务角色管理</li>
                <li>推广出借端合作机构管理</li>
                <li>机构项目佣金录入</li>
            </ul>
        </div>
    </div>
    <!-- page content start -->
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>机构项目佣金录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/save"
                          enctype="multipart/form-data" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>机构项目佣金录入
                                </h3>
                            </div>
                            <input type="hidden" name="id" value="${orgCommissionRatio.id }"> <input type="hidden"
                                                                                                     name="orgId"
                                                                                                     value="${orgId }">
                            <div class="panel-body">
                                <div class="form-group ">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>选择项目</label>
                                    <div class="col-md-2">
                                        <itech:code type="select" property="productCategory"
                                                    code="product.productCategory"
                                                    value="${orgCommissionRatio.productCategory }"></itech:code>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i class="icons-mark-required"></i>员工推荐出借所得佣金比例</label>
                                    <div class="col-md-9">
                                        <div class="input-group">
                                            <div class="table-responsive">
                                                <table class="table table-hover table-bordered ">
                                                    <thead style="background-color: #ccc; text-align: center;">
                                                    <tr>
                                                        <th>自投佣金比例(%/年）</th>
                                                        <th>1级佣金比例(%/年）</th>
                                                        <th>2级佣金比例(%/年）</th>
                                                        <th>3级佣金比例(%/年）</th>
                                                        <th>4级佣金比例(%/年）</th>
                                                        <th>5级佣金比例(%/年）</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td><input id="myselfRate" name="myselfRate" type="text"
                                                                   class="form-control"
                                                                   value="${orgCommissionRatio.myselfRate}"/></td>
                                                        <td><input id="oneLevelRate" name="oneLevelRate" type="text"
                                                                   class="form-control"
                                                                   value="${orgCommissionRatio.oneLevelRate}"/></td>
                                                        <td><input id="secondLevelRate" name="secondLevelRate"
                                                                   type="text" class="form-control"
                                                                   value="${orgCommissionRatio.secondLevelRate}"/></td>
                                                        <td><input id="threeLevelRate" name="threeLevelRate" type="text"
                                                                   class="form-control"
                                                                   value="${orgCommissionRatio.threeLevelRate}"/></td>
                                                        <td><input id="fourLevelRate" name="fourLevelRate" type="text"
                                                                   class="form-control"
                                                                   value="${orgCommissionRatio.fourLevelRate}"/></td>
                                                        <td><input id="fiveLevelRate" name="fiveLevelRate" type="text"
                                                                   class="form-control"
                                                                   value="${orgCommissionRatio.fiveLevelRate}"/></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">跳点所得佣金比例</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="table-responsive">
                                                <table class="table table-hover table-bordered ">
                                                    <thead style="text-align: center;">
                                                    <tr>
                                                        <th>跳点区间(月)</th>
                                                        <th>比例(%/年）</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            <div class="input-group">
                                                                <label class="control-label col-md-4"
                                                                       style="float: left;"><i
                                                                        class="icons-mark-required"></i>>=</label>
                                                                <div class="col-md-8">
                                                                    <input id="brokerageMoney" name="brokerageMoney"
                                                                           type="text" class="form-control"
                                                                           value="${ orgCommissionRatio.brokerageMoney}"/>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td><label class="control-label col-md-3"> <i
                                                                class="icons-mark-required"></i></label>
                                                            <div class="col-md-9">
                                                                <input id="brokerageRate" name="brokerageRate"
                                                                       type="text" class="form-control" maxlength="60"
                                                                       placeholder="0"
                                                                       value="${ orgCommissionRatio.brokerageRate}"/>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <div class="input-group">
                                                                <label class="control-label col-md-4">>=</label>
                                                                <div class="col-md-8">
                                                                    <input id="jumpPoint1" name="jumpPoint1" type="text"
                                                                           class="form-control"
                                                                           value="${orgCommissionRatio.jumpPoint1}"/>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td><label class="control-label col-md-3"> </label>
                                                            <div class="col-md-9">
                                                                <input id="jumpPoint1Rate" name="jumpPoint1Rate"
                                                                       type="text" class="form-control" placeholder="0"
                                                                       value="${orgCommissionRatio.jumpPoint1Rate}"/>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <div class="input-group">
                                                                <label class="control-label col-md-4">>=</label>
                                                                <div class="col-md-8">
                                                                    <input id="jumpPoint2" name="jumpPoint2" type="text"
                                                                           class="form-control"
                                                                           value="${orgCommissionRatio.jumpPoint2}"/>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td><label class="control-label col-md-3"> </label>
                                                            <div class="col-md-9">
                                                                <input id="jumpPoint2Rate" name="jumpPoint2Rate"
                                                                       type="text" class="form-control" placeholder="0"
                                                                       value="${orgCommissionRatio.jumpPoint2Rate}"/>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <div class="input-group">
                                                                <label class="control-label col-md-4">>=</label>
                                                                <div class="col-md-8">
                                                                    <input id="jumpPoint3" name="jumpPoint3" type="text"
                                                                           class="form-control"
                                                                           value="${orgCommissionRatio.jumpPoint3}"/>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td><label class="control-label col-md-3"> </label>
                                                            <div class="col-md-9">
                                                                <input id="jumpPoint3Rate" name="jumpPoint3Rate"
                                                                       type="text" class="form-control" placeholder="0"
                                                                       value="${orgCommissionRatio.jumpPoint3Rate}"/>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>提交
                                        </button>
                                        <button onclick="javascript:history.go(-1);" type="button"
                                                class="btn btn-primary">
                                            <i class="icon-undo2"></i>取消
                                        </button>
                                    </div>
                                </div>
                            </div>
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
<style>
    .red {
        #d94a48

    }
</style>
<script type="text/javascript">

    $(function () {
        $.validator.addMethod("productCategoryIsExist", function (value, element, param) {
            var flag = false;
            $.ajax({
                async: false,
                url: "${pageContext.request.contextPath}/business/cooperateorg/manage/orgCommission/isExist",     //后台处理程序
                type: "post",
                data: {
                    productCategory: value,
                    orgId: param
                },
                success: function (data) {
                    if (data) {
                        flag = true;
                    }
                }
            });
            return this.optional(element) || flag;
        }, "该类型的项目已设置佣金比例");
        $('#productCategory').bind("change", function () {
            checkProductCategory('noInit');
        });
        checkProductCategory('init');

        $.validator.addMethod("moreThan", function (value, element, param) {
            var lastVal = $(param).val();
            if (value != '')
                return this.optional(element) || (Number(value) > Number(lastVal));
            else return true;
        }, "输入值应大于上一输入值");

        var searchFormValidate = $("#searchForm").validate({
            rules: {
                orgId: {required: true},
                productCategory: {
                    required: true
                },
                brokerageMoney: {required: true, number: true, isDecimal: [0, 999999999, 2]},
                brokerageRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                myselfRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                oneLevelRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                secondLevelRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                threeLevelRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                fourLevelRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                fiveLevelRate: {required: true, number: true, isDecimal: [0, 999, 2]},
                jumpPoint1: {
                    number: true,
                    isDecimal: [0, 99999999, 2],
                    moreThan: '#brokerageMoney',
                },
                jumpPoint2: {
                    number: true,
                    isDecimal: [0, 99999999, 2],
                    moreThan: '#jumpPoint1'
                },
                jumpPoint3: {
                    number: true,
                    isDecimal: [0, 999999999, 2],
                    moreThan: '#jumpPoint2'
                },
                jumpPoint1Rate: {
                    number: true,
                    isDecimal: [0, 9999, 2]
                },
                jumpPoint2Rate: {
                    number: true,
                    isDecimal: [0, 9999, 2]
                },
                jumpPoint3Rate: {
                    number: true,
                    isDecimal: [0, 9999, 2]
                },

            }
        });

        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });

    });

    function checkProductCategory(isInit) {
        var productCategory = '${orgCommissionRatio.productCategory }';
        if ($('#productCategory').val() != '' && $('#productCategory').val() != null) {
            var orgId = '${orgId}';
            if ($('#productCategory').val() != productCategory) {
                $("#productCategory").rules("add", {productCategoryIsExist: orgId});
            } else {
                if (isInit != 'init')
                    $("#productCategory").rules("remove", "productCategoryIsExist");
            }

        }
    }
</script>
</html>
