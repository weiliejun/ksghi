<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>附加险录入</title>
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
                    <h4>附加险－附加险录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xqyzy/fjxInfo/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>附加险信息
                                </h3>
                            </div>

                            <div class="panel-body">

                                <div class="form-group">
                                    <label class="col-md-2 control-label"> 附加险： </label>
                                    <div class="col-md-8">
                                        <div class="table-responsive">
                                            <table class="table table-hover table-bordered">
                                                <thead>
                                                <tr id="a">
                                                    <th><input type="radio" name="checkbox" disabled/></th>
                                                    <th>保险公司</th>
                                                    <%--<th>主附险</th>--%>
                                                    <th>险种</th>
                                                    <th>险种名称</th>
                                                    <th>缴费方式</th>
                                                    <th>缴费年期</th>
                                                    <th>保险期间</th>
                                                    <th>保险金额</th>
                                                    <th>规模保费</th>
                                                    <th>标准保费</th>
                                                </tr>
                                                </thead>
                                                <tbody id="trlist">
                                                <c:forEach var="fjxItem" items="${fjxInfo }">
                                                    <tr id="tr">
                                                        <input id="id" name="id" type="hidden" class="form-control"
                                                               maxlength="50"
                                                               value="${fjxItem.id}"/>
                                                        <input id="xqyId" name="xqyId" type="hidden"
                                                               class="form-control" maxlength="50"
                                                               value="${fjxItem.xqyId}"/>
                                                        <td><input type="radio" name="checkbox"/></td>
                                                        <td><input id="bxgs" name="bxgs" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.bxgs}"/></td>
                                                            <%--<td><input id="zfx" name="zfx" type="text" class="form-control"
                                                                       maxlength="120" readonly="readonly"
                                                                       value="${fjxItem.zfx}"/></td>--%>
                                                        <td><input id="xzdm" name="xzdm" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.xzdm}"/></td>
                                                        <td><input id="xzmc" name="xzmc" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.xzmc}"/></td>
                                                        <%--<td><input id="jffs" name="jffs" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.jffs}"/></td>--%>
                                                        <td class="col-md-2"><itech:code property="jffs" code="ysbd.jffs" type="select"
                                                                        value="${fjxItem.jffs }" /></td>
                                                        <%--<td><input id="jfnq" name="jfnq" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.jfnq}"/></td>--%>
                                                        <td class="col-md-2"><itech:code property="jfnq" code="ysbd.jfnq" type="select"
                                                                    value="${fjxItem.jfnq }" /></td>
                                                        <td><input id="bxqj" name="bxqj" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.bxqj}"/></td>
                                                        <td><input id="bxje" name="bxje" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.bxje}"/></td>
                                                        <td><input id="sjbf" name="sjbf" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.sjbf}"/></td>
                                                        <td><input id="sjxj" name="sjxj" type="text"
                                                                   class="form-control" maxlength="120"
                                                                   value="${fjxItem.sjxj}"/></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <input id="addrow" type="button" value="增加一行"/>
                                            <input id="removerow" type="button" value="删除一行"/>
                                        </div>
                                    </div>
                                </div>


                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-2 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
                                        </button>
                                        <button onclick="javascript:goBack();" type="button"
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
        window.location.href = "${pageContext.request.contextPath}/business/xqyzy/query";
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
                sjxj: {
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

<script type="text/javascript">
    $(function () {
        $("#addrow").click(addrow);//绑定添加事件
        $("#removerow").click(removerow);//绑定删除事件。
    });

    var trlisthtml = $(".table>tbody>tr:last").html();//获取默认的一行tr，用作复制
    function addrow() {//增加
        $(".table>tbody:last").append('<tr>' + trlisthtml + '</tr>');//向tbody最后添加一行tr.
        $(".table>tbody>tr:last").find(":input[name=\"id\"]").val(' ');   //将尾行元素克隆来的保存的值清空
    }

    function removerow() {//移除
        $('input[name="checkbox"]:checked').each(function () {
            var id = $(this).parent().parent().find('input[name="id"]').val().trim();
            var xqyId = $(this).parent().parent().find('input[name="xqyId"]').val().trim();
            if (id != "" && id != null && id != undefined) {
                deleteData(id, xqyId);
            }
            $(this).parent().parent().remove();//移除当前行 checkbox的父级是td，td的父级是tr，然后删除tr。就ok了。用each，选择多行遍历删除
        });
    }

    function deleteData(id, xqyId) {
        bootbox.confirm("您确定要删除该记录吗？", function (confirmed) {
            if (confirmed) {
                location.href = '${pageContext.request.contextPath}/business/xqyzy/fjxInfo/delete?id=' + id + '&xqyId=' + xqyId;
                return false;
            }
        });
    }
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
