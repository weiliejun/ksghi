<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>投保保单录入</title>
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
                    <h4>投保保单－投保保单录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xqyzy/ysbd/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>投保保单信息
                                </h3>
                            </div>
                            <input id="cxmk" name="cxmk" type="hidden" class="form-control" value="ysbd"/>
                            <input id="id" name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${xqyzy.id}"/>
                            <input id="dlgs" name="dlgs" type="hidden" class="form-control" maxlength="50"
                                   value="${xqyzy.dlgs}"/>
                            <input id="dept" name="dept" type="hidden" class="form-control" maxlength="50"
                                   value="${xqyzy.dept}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="tbrq" name="tbrq" type="text" class="form-control"
                                                       readonly="readonly" value="${xqyzy.tbrq }"/>
                                                <span class="input-group-addon"> <span
                                                        class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbr" name="tbr" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.tbr}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrzj" code="xsrygl.zj" type="select"
                                                    value="${xqyzy.tbrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrlxdh" name="tbrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.tbrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrzjhm" name="tbrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.tbrzjhm}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrzzyh" code="xsrygl.yhmc" type="select"
                                                    value="${xqyzy.tbrzzyh }"/>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbryhzh" name="tbryhzh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.tbryhzh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrtxdz" name="tbrtxdz" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.tbrtxdz}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">被保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbr" name="bbr" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.bbr}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrzj" code="xsrygl.zj" type="select"
                                                    value="${xqyzy.bbrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrlxdh" name="bbrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.bbrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrzjhm" name="bbrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.bbrzjhm}"/>
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrzzyh" code="xsrygl.yhmc" type="select"
                                                    value="${xqyzy.bbrzzyh }"/>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbryhzh" name="bbryhzh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.bbryhzh}"/>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrtxdz" name="bbrtxdz" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.bbrtxdz}"/>
                                    </div>
                                    <label class="col-md-2 control-label">投保人关系：</label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrgx" code="xsrygl.tbrgx" type="select"
                                                    value="${xqyzy.tbrgx }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人：</label>
                                    <div class="col-md-3">
                                        <itech:code property="syr" code="ysbd.syr" type="select" value="${xqyzy.syr }"/>
                                    </div>
                                    <div class="col-md-3">
                                        <input id="ttbr" name="ttbr" type="checkbox" onclick="javascript:copyTbr();"/>同投保人
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人姓名：</label>
                                    <div class="col-md-3">
                                        <input id="syrxm" name="syrxm" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.syrxm}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：</label>
                                    <div class="col-md-3">
                                        <itech:code property="syrzj" code="xsrygl.zj" type="select"
                                                    value="${xqyzy.syrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <input id="syrlxdh" name="syrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.syrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：</label>
                                    <div class="col-md-3">
                                        <input id="syrzjhm" name="syrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xqyzy.syrzjhm}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益比例：</label>
                                    <div class="col-md-3">
                                        <input id="sybl" name="sybl" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.sybl}"/>
                                    </div>
                                    <label class="col-md-2 control-label">受益顺序：</label>
                                    <div class="col-md-3">
                                        <itech:code property="sysx" code="xsrygl.sysx" type="select"
                                                    value="${xqyzy.sysx }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是被保人的：</label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrgx" code="xsrygl.tbrgx" type="select"
                                                    value="${xqyzy.bbrgx }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbdh" name="tbdh" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.tbdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bdh" name="bdh" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.bdh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxgs" name="bxgs" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.bxgs}"/>
                                    </div>
                                    <label class="col-md-2 control-label">险种名称：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="xzmc" name="xzmc" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.xzmc}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">险种：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="xzdm" name="xzdm" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.xzdm}"/>
                                    </div>
                                    <label class="col-md-2 control-label">保险期间：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxqj" name="bxqj" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.bxqj}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴费方式：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <%--<input id="jffs" name="jffs" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.jffs}"/>--%>
                                        <itech:code property="jffs" code="ysbd.jffs" type="select"
                                                    value="${fjxItem.jffs }"/>
                                    </div>
                                    <label class="col-md-2 control-label">缴费年期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="jfnq" code="ysbd.jfnq" type="select"
                                                    value="${xqyzy.jfnq }"/>
                                        <%--<input id="jfnq" name="jfnq" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.jfnq}"/>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">规模保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="sjbf" name="sjbf" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.sjbf}"/>
                                    </div>
                                    <label class="col-md-2 control-label">标准保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="sjxj" name="sjxj" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.sjxj}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxje" name="bxje" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.bxje}"/>
                                    </div>
                                    <label class="col-md-2 control-label">佣金金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="yjje" name="yjje" type="text" class="form-control" maxlength="120"
                                               value="${xqyzy.yjje}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">代理人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="ywy" name="ywy" maxlength="200" type="text" class="form-control"
                                                   readonly="readonly" value="${xqyzy.ywy }"/>
                                            <span class="input-group-addon"> <a id="selectYwy" onclick="selectYwy();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">代理人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="ywybh" name="ywybh" type="text" class="form-control" maxlength="120"
                                               readonly="readonly"
                                               value="${xqyzy.ywybh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">结算人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="jsr" name="jsr" maxlength="200" type="text" class="form-control"
                                                   readonly="readonly" value="${xqyzy.jsr }"/>
                                            <span class="input-group-addon"> <a id="selectJsr" onclick="selectJsr();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">结算人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="jsrbh" name="jsrbh" type="text" class="form-control" maxlength="120"
                                               readonly="readonly"
                                               value="${xqyzy.jsrbh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">实际销售人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="sjxsr" name="sjxsr" maxlength="200" type="text"
                                                   class="form-control"
                                                   readonly="readonly" value="${xqyzy.sjxsr }"/>
                                            <span class="input-group-addon"> <a id="selectSjxsr"
                                                                                onclick="selectSjxsr();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">实际销售人工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="sjxsrbh" name="sjxsrbh" type="text" class="form-control"
                                               maxlength="120"
                                               readonly="readonly"
                                               value="${xqyzy.sjxsrbh}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100">${xqyzy.remark}</textarea>
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
        $("input[name='tbrq']").datepicker({format: 'yyyy-mm-dd'});
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/xqyzy/ysbd/query";
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
                bdh: {
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
                jsr: {
                    required: true
                },
                jsrbh: {
                    required: true
                },
                sjxsr: {
                    required: true
                },
                sjxsrbh: {
                    required: true
                },
                yjje: {
                    required: true,
                    number: true,
                    isDecimal: [0, 999999999, 2]
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
        $("#dlgs").val(selectYwy.ssgs);
        $("#dept").val(selectYwy.dept);
    }

    $("#selectJsr").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

    function selectJsr() {
        $("#selectJsr").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectJsr");
    }

    function selectJsrCallback(selectJsr) {
        $("#jsr").val(selectJsr.name);
        $("#jsrbh").val(selectJsr.code);
    }

    $("#selectSjxsr").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

    function selectSjxsr() {
        $("#selectSjxsr").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectSjxsr");
    }

    function selectSjxsrCallback(selectSjxsr) {
        $("#sjxsr").val(selectSjxsr.name);
        $("#sjxsrbh").val(selectSjxsr.code);
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
