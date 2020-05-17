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
                    <h4>保全作业－保全申请录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/bqzy/bqsq/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>保全申请录入
                                </h3>
                            </div>
                            <input id="id" name="id" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.id}"/>
                            <input id="xqyId" name="xqyId" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.xqyId}"/>
                            <input id="dlgs" name="dlgs" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.dlgs}"/>
                            <input id="dept" name="dept" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.dept}"/>
                            <input id="cbrq" name="cbrq" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.cbrq}"/>
                            <input id="sxrq" name="sxrq" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.sxrq}"/>
                            <input id="cbbz" name="cbbz" type="hidden" class="form-control" maxlength="50"
                                   value="${bqzy.cbbz}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <c:if test="${bqzy.id==null }">
                                        <label class="col-md-2 control-label">申请保单号：<i
                                                class="icons-mark-required"></i></label>
                                        <div class="col-md-3">
                                            <div class="input-group">
                                                <input id="bdh" name="bdh" type="text" class="form-control"
                                                       maxlength="120"
                                                       value="${bdh}"/>
                                                <span class="input-group-addon"> <a id="selectXqy"
                                                                                    onclick="bdcx($('#bdh').val());"
                                                                                    style="cursor: pointer;">查询</a>
												</span>
                                            </div>
                                        </div>
                                    </c:if>
                                    <label class="col-md-2 control-label">投保日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="tbrq" name="tbrq" type="text" class="form-control"
                                                       readonly="readonly" value="${bqzy.tbrq }"/>
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
                                               value="${bqzy.tbr}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrzj" code="xsrygl.zj" type="select"
                                                    value="${bqzy.tbrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrlxdh" name="tbrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.tbrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrzjhm" name="tbrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.tbrzjhm}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrzzyh" code="xsrygl.yhmc" type="select"
                                                    value="${bqzy.tbrzzyh }"/>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbryhzh" name="tbryhzh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.tbryhzh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbrtxdz" name="tbrtxdz" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.tbrtxdz}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">被保人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbr" name="bbr" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.bbr}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrzj" code="xsrygl.zj" type="select"
                                                    value="${bqzy.bbrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrlxdh" name="bbrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.bbrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrzjhm" name="bbrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.bbrzjhm}"/>
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="col-md-2 control-label">转账银行：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrzzyh" code="xsrygl.yhmc" type="select"
                                                    value="${bqzy.bbrzzyh }"/>
                                    </div>
                                    <label class="col-md-2 control-label">银行账号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbryhzh" name="bbryhzh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.bbryhzh}"/>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">通信地址：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bbrtxdz" name="bbrtxdz" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.bbrtxdz}"/>
                                    </div>
                                    <label class="col-md-2 control-label">投保人关系：</label>
                                    <div class="col-md-3">
                                        <itech:code property="tbrgx" code="xsrygl.tbrgx" type="select"
                                                    value="${bqzy.tbrgx }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人：</label>
                                    <div class="col-md-3">
                                        <itech:code property="syr" code="ysbd.syr" type="select" value="${bqzy.syr }"/>
                                    </div>
                                    <div class="col-md-3">
                                        <input id="ttbr" name="ttbr" type="checkbox" onclick="javascript:copyTbr();"/>同投保人
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益人姓名：</label>
                                    <div class="col-md-3">
                                        <input id="syrxm" name="syrxm" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.syrxm}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件：</label>
                                    <div class="col-md-3">
                                        <itech:code property="syrzj" code="xsrygl.zj" type="select"
                                                    value="${bqzy.syrzj }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <input id="syrlxdh" name="syrlxdh" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.syrlxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">证件号码：</label>
                                    <div class="col-md-3">
                                        <input id="syrzjhm" name="syrzjhm" type="text" class="form-control"
                                               maxlength="120"
                                               value="${bqzy.syrzjhm}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">受益比例：</label>
                                    <div class="col-md-3">
                                        <input id="sybl" name="sybl" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.sybl}"/>
                                    </div>
                                    <label class="col-md-2 control-label">受益顺序：</label>
                                    <div class="col-md-3">
                                        <itech:code property="sysx" code="xsrygl.sysx" type="select"
                                                    value="${bqzy.sysx }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是被保人的：</label>
                                    <div class="col-md-3">
                                        <itech:code property="bbrgx" code="xsrygl.tbrgx" type="select"
                                                    value="${bqzy.bbrgx }"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">保险公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxgs" name="bxgs" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.bxgs}"/>
                                    </div>
                                    <label class="col-md-2 control-label">险种名称：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="xzmc" name="xzmc" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.xzmc}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">险种：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="xzdm" name="xzdm" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.xzdm}"/>
                                    </div>
                                    <label class="col-md-2 control-label">保险期间：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxqj" name="bxqj" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.bxqj}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴费方式：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="jffs" name="jffs" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.jffs}"/>
                                    </div>
                                    <label class="col-md-2 control-label">缴费年期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="jfnq" name="jfnq" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.jfnq}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保单号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="tbdh" name="tbdh" type="text" class="form-control" maxlength="120"
                                               readonly="readonly" value="${bqzy.tbdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">保险金额：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="bxje" name="bxje" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.bxje}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">规模保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="sjbf" name="sjbf" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.sjbf}"/>
                                    </div>
                                    <label class="col-md-2 control-label">标准保费：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="sjxj" name="sjxj" type="text" class="form-control" maxlength="120"
                                               value="${bqzy.sjxj}"/>
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
                                    <label class="col-md-2 control-label">代理人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="ywy" name="ywy" maxlength="200" type="text" class="form-control"
                                                   readonly="readonly" value="${bqzy.ywy }"/>
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
                                               value="${bqzy.ywybh}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">申请人：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="sqr" name="sqr" maxlength="200" type="text" class="form-control"
                                                   readonly="readonly" value="${bqzy.sqr }"/>
                                            <span class="input-group-addon"> <a id="selectSqr" onclick="selectSqr();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">申请日期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="sqrq" name="sqrq" type="text" class="form-control"
                                                       readonly="readonly" value="${bqzy.sqrq }"/>
                                                <span class="input-group-addon"> <span
                                                        class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
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
        $("input[name='tbrq']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='sqrq']").datepicker({format: 'yyyy-mm-dd'});
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/bqzy/ysbd/query";
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
                sqr: {
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
        $("#dlgs").val(selectYwy.ssgs);
        $("#dept").val(selectYwy.dept);
    }

    $("#selectSqr").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

    function selectSqr() {
        $("#selectSqr").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectSqr");
    }

    function selectSqrCallback(selectSqr) {
        $("#sqr").val(selectSqr.name);
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

    function bdcx(bdh) {
        if (bdh == null || bdh == '') {
            bootbox.alert("请输入保单号再查询!");
            $("#bdh").focus();
            return false;
        }
        $("#selectXqy").attr("href", "${pageContext.request.contextPath }/business/bqzy/bdcx?bdh=" + bdh);
    }
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
