<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>清单结算</title>
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
                    <h4>清单结算－清单结算查看</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xqyzy/ysbd/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保单基本信息
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${xqyzy.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理公司：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.dlgs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">投保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbr}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrzjhm}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrzzyh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbryhzh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrtxdz}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">被保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbr}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrzjhm}</p>
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrzzyh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbryhzh}</p>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrtxdz}</p>
                                    </div>
                                    <label class="col-md-2 control-label">投保人关系：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbrgx}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.syr}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人姓名：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.syrxm}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.syrzj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.syrlxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.syrzjhm}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益比例：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.sybl}</p>
                                    </div>
                                    <label class="col-md-2 control-label">受益顺序：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.sysx}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是被保人的：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bbrgx}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bdh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bxgs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">险种名称：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.xzmc}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">险种：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.xzdm}</p>
                                    </div>
                                    <label class="col-md-2 control-label">保险期间：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bxqj}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴费方式：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.jffs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">缴费年期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.jfnq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.tbdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">保险金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bxje}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">规模保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.sjbf}</p>
                                    </div>
                                    <label class="col-md-2 control-label">标准保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.sjxj}</p>
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
                                            <p class="form-control-static">${xqyzy.dlgs}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">部门(机构)：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.dept}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.ywy}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">代理人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.ywybh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">结算人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.jsr}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">结算人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.jsrbh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">实际销售人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.sjxsr}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">实际销售人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.sjxsrbh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保费(合计)：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.bfhj}</p>
                                    </div>
                                    <label class="col-md-2 control-label">佣金金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xqyzy.yjje}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <p class="form-control-static">${xqyzy.remark}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">承保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.cbrq}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">生效日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.sxrq}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">回执签署日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.hzqsrq}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">回执录入日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.hzlrrq}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">回访成功日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.hfcgrq}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">寄出日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.jcrq}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">收到日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.sdrq}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">邮寄备注：</label>
                                    <div class="col-md-8">
                                        <p class="form-control-static">${xqyzy.yjbz}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">清单结算：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.qdjszt}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">结算日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xqyzy.jsrq}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">结算备注：</label>
                                    <div class="col-md-8">
                                        <p class="form-control-static">${xqyzy.jsbz}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
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
        $("input[name='sdrq']").datepicker({format: 'yyyy-mm-dd'});
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/xqyzy/bdhz/query";
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
                sdrq: {
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
