<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>保全作业</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
    <%@ include file="/webpage/common/commoneditor.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>保全作业－保全审核确认</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/bqzy/bqsq/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保单基本信息
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理公司：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.dlgs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">投保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbr}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrzjhm}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrzzyh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbryhzh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrtxdz}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">被保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbr}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrzjhm}</p>
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrzzyh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbryhzh}</p>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrtxdz}</p>
                                    </div>
                                    <label class="col-md-2 control-label">投保人关系：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbrgx}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.syr}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人姓名：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.syrxm}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.syrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.syrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.syrzjhm}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益比例：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sybl}</p>
                                    </div>
                                    <label class="col-md-2 control-label">受益顺序：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sysx}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是被保人的：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bbrgx}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bxgs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">险种名称：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.xzmc}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">险种：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.xzdm}</p>
                                    </div>
                                    <label class="col-md-2 control-label">保险期间：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bxqj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴费方式：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.jffs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">缴费年期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.jfnq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.tbdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">保险金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.bxje}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">规模保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sjbf}</p>
                                    </div>
                                    <label class="col-md-2 control-label">标准保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sjxj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label"> 附加险： </label>
                                    <div class="col-md-8">
                                        <div class="table-responsive">
                                            <table class="table table-hover table-bordered">
                                                <thead>
                                                <tr>
                                                    <th>保险公司</th>
                                                    <th>主附险</th>
                                                    <th>险种</th>
                                                    <th>险种</th>
                                                    <th>缴费方式</th>
                                                    <th>缴费年期</th>
                                                    <th>保险期间</th>
                                                    <th>保险金额</th>
                                                    <th>规模保费</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="fjxItem" items="${fjxInfo }">
                                                    <tr>
                                                        <td>${fjxItem.bxgs }</td>
                                                        <td>${fjxItem.zfx }</td>
                                                        <td>${fjxItem.xzdm }</td>
                                                        <td>${fjxItem.xzmc }</td>
                                                        <td>${fjxItem.jffs }</td>
                                                        <td>${fjxItem.jfnq }</td>
                                                        <td>${fjxItem.bxqj }</td>
                                                        <td>${fjxItem.bxje }</td>
                                                        <td>${fjxItem.sjbf }</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${bqzy.dlgs}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">部门(机构)：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.dept}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${bqzy.ywy}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">代理人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.ywybh}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <p class="form-control-static">${bqzy.cbbz}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">承保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${bqzy.cbrq}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">生效日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${bqzy.sxrq}</p>
                                        </div>
                                    </div>
                                </div>

                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <legend><i class="icon-pencil"></i>保全审核确认</legend>
                                    </h3>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">申请人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sqr}</p>
                                    </div>
                                    <label class="col-md-2 control-label">申请日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${bqzy.sqrq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保全审核：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="bqshzt" code="bqzy.bqshzt" type="radio"
                                                    value="${bqzy.bqshzt }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100">${bqzy.remark}</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
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


<script type="text/javascript">
    $().ready(function () {
        $("input[name='jsrq']").datepicker({format: 'yyyy-mm-dd'});
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/bqzy/bdhz/query";
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                tbrq: {
                    required: true
                },
                tbr: {
                    required: true
                },
                tbrzj: {
                    required: true
                },
                tbrlxdh: {
                    required: true
                },
                tbrzjhm: {
                    required: true
                },
                tbrzzyh: {
                    required: true
                },
                tbryhzh: {
                    required: true
                },
                tbrtxdz: {
                    required: true
                },
                bbr: {
                    required: true
                },
                bbrzj: {
                    required: true
                },
                bbrlxdh: {
                    required: true
                },
                bbrzjhm: {
                    required: true
                },
                bbrzzyh: {
                    required: true
                },
                bbryhzh: {
                    required: true
                },
                bbrtxdz: {
                    required: true
                },
                tbrgx: {
                    required: true
                },
                syr: {
                    required: true
                },
                syrxm: {
                    required: true
                },
                syrzj: {
                    required: true
                },
                syrlxdh: {
                    required: true
                },
                syrzjhm: {
                    required: true
                },
                sybl: {
                    required: true,
                    number: true,
                    isDecimal: [0, 100, 2]
                },
                sysx: {
                    required: true
                },
                bbrgx: {
                    required: true
                },
                bxgs: {
                    required: true
                },
                xzmc: {
                    required: true
                },
                xzdm: {
                    required: true
                },
                bxqj: {
                    required: true
                },
                jffs: {
                    required: true
                },
                jfnq: {
                    required: true
                },
                tbdh: {
                    required: true
                },
                bxje: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                sjbf: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                sjxj: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                ywy: {
                    required: true
                },
                ywybh: {
                    required: true
                },
                yjje: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
                },
                bqshzt: {
                    required: true
                },
                sqrq: {
                    required: true
                }

            }
        });
        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

    function reUpload() {
        $("#showFile").addClass("hide");
        $("#uploadFile").addClass("show");
    }

    $("#selectYwy").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

    function selectYwy() {
        $("#selectYwy").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectYwy");
    }

    function selectYwyCallback(selectYwy) {
        $("#ywy").val(selectYwy.name);
        $("#ywybh").val(selectYwy.code);
    }

    function copyTbr() {
        if ($("#ttbr").is(":checked")) {
            $("#syrxm").val($("#tbr").val());
            $("#syrzj").val($("#tbrzj").val());
            $("#syrlxdh").val($("#tbrlxdh").val());
            $("#syrzjhm").val($("#tbrzjhm").val());
        } else {
            $("#syrxm").val("");
            $("#syrzj").val("");
            $("#syrlxdh").val("");
            $("#syrzjhm").val("");
        }
    }
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
