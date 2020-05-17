<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>销售员申请入职信息录入</title>
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
                    <h4>销售人员信息管理－销售员申请入职信息录入</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xsrygl/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>销售员申请入职信息录入
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50" value="${xsrygl.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">所属公司：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="ssgs" code="xsrygl.ssgs" type="select"
                                                    value="${xsrygl.ssgs }"/>
                                    </div>
                                    <label class="col-md-2 control-label">基本法：</label>
                                    <div class="col-md-3">
                                        <itech:code property="jbf" code="xsrygl.jbf" type="select"
                                                    value="${xsrygl.jbf }"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">员工姓名：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="name" name="name" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.name}"/>
                                    </div>
                                    <label class="col-md-2 control-label">机构(部门)：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="dept" code="xsrygl.dept" type="select"
                                                    value="${xsrygl.dept }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">旧员工工号：</label>
                                    <div class="col-md-3">
                                        <input id="codeOld" name="codeOld" type="text" class="form-control"
                                               maxlength="120"
                                               value="${xsrygl.codeOld}"/>
                                    </div>
                                    <label class="col-md-2 control-label">员工工号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="code" name="code" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.code}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">员工状态：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="status" code="xsrygl.status" type="select"
                                                    value="${xsrygl.status}"/>
                                    </div>
                                    <c:choose>
                                        <c:when test="${xsrygl.status == '正式员工'}">
                                            <label class="col-md-2 control-label">转正时间：<i
                                                    class="icons-mark-required"></i></label>
                                            <div class="col-md-3">
                                                <div class="input-group">
                                                    <div class="input-group date">
                                                        <input id="zzsj" name="zzsj" type="text" class="form-control"
                                                               readonly="readonly" value="${xsrygl.zzsj }"/>
                                                        <span class="input-group-addon"> <span
                                                                class="glyphicon glyphicon-calendar"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:when test="${xsrygl.status == '离职'}">
                                            <label class="col-md-2 control-label">离职时间：<i
                                                    class="icons-mark-required"></i></label>
                                            <div class="col-md-3">
                                                <div class="input-group">
                                                    <div class="input-group date">
                                                        <input id="lzsj" name="lzsj" type="text" class="form-control"
                                                               readonly="readonly" value="${xsrygl.lzsj }"/>
                                                        <span class="input-group-addon"> <span
                                                                class="glyphicon glyphicon-calendar"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="col-md-2 control-label">入司时间：<i
                                                    class="icons-mark-required"></i></label>
                                            <div class="col-md-3">
                                                <div class="input-group">
                                                    <div class="input-group date">
                                                        <input id="rssj" name="rssj" type="text" class="form-control"
                                                               readonly="readonly" value="${xsrygl.rssj }"/>
                                                        <span class="input-group-addon"> <span
                                                                class="glyphicon glyphicon-calendar"></span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">推荐人：</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="tjr" name="tjr" maxlength="200" type="text" class="form-control"
                                                   readonly="readonly" value="${xsrygl.tjr }"/>
                                            <span class="input-group-addon"> <a id="selectTjr" onclick="selectTjr();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">直接上级：</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <input id="zjsj" name="zjsj" maxlength="200" type="text"
                                                   class="form-control" readonly="readonly" value="${xsrygl.zjsj }"/>
                                            <span class="input-group-addon"> <a id="selectZjsj" onclick="selectZjsj();"
                                                                                style="cursor: pointer;">选择</a>
												</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">推荐人工号：</label>
                                    <div class="col-md-3">
                                        <input id="tjrgh" name="tjrgh" maxlength="200" type="text" class="form-control"
                                               readonly="readonly" value="${xsrygl.tjrgh }"/>
                                    </div>
                                    <label class="col-md-2 control-label">上级工号：</label>
                                    <div class="col-md-3">
                                        <input id="zjsjgh" name="zjsjgh" maxlength="200" type="text"
                                               class="form-control" readonly="readonly" value="${xsrygl.zjsjgh }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">本人手机：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="mobile" name="mobile" type="text" class="form-control" maxlength="20"
                                               value="${xsrygl.mobile}"/>
                                    </div>
                                    <label class="col-md-2 control-label">身份证号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="idNo" name="idNo" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.idNo}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">银行名称：</label>
                                    <div class="col-md-3">
                                        <itech:code property="yhmc" code="xsrygl.yhmc" type="select"
                                                    value="${xsrygl.yhmc }"/>
                                    </div>
                                    <label class="col-md-2 control-label">银行卡号：</label>
                                    <div class="col-md-3">
                                        <input id="yhkh" name="yhkh" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.yhkh}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">执业证：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <input id="zyz" name="zyz" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.zyz}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">执业起期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="zyqq" name="zyqq" type="text" class="form-control"
                                                       readonly="readonly" value="${xsrygl.zyqq }"/>
                                                <span class="input-group-addon"> <span
                                                        class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">执业止期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <div class="input-group date">
                                                <input id="zyzq" name="zyzq" type="text" class="form-control"
                                                       readonly="readonly" value="${xsrygl.zyzq }"/>
                                                <span class="input-group-addon"> <span
                                                        class="glyphicon glyphicon-calendar"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">职级：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="rank" code="xsrygl.rank" type="select"
                                                    value="${xsrygl.rank}"/>
                                    </div>
                                    <label class="col-md-2 control-label">政治面貌：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="zzmm" code="xsrygl.zzmm" type="select"
                                                    value="${xsrygl.zzmm}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">性别：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="xb" code="xsrygl.xb" type="select" value="${xsrygl.xb }"/>
                                    </div>
                                    <label class="col-md-2 control-label">民族：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="mz" code="xsrygl.mz" type="select" value="${xsrygl.mz }"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">个人学历：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <itech:code property="xl" code="xsrygl.xl" type="select" value="${xsrygl.xl}"/>
                                    </div>
                                    <label class="col-md-2 control-label">入司年龄：</label>
                                    <div class="col-md-3">
                                        <input id="rsnl" name="rsnl" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.rsnl}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <input id="lxdh" name="lxdh" type="text" class="form-control" maxlength="20"
                                               value="${xsrygl.lxdh}"/>
                                    </div>
                                    <label class="col-md-2 control-label">联系地址：</label>
                                    <div class="col-md-3">
                                        <input id="lxdz" name="lxdz" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.lxdz}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">电子邮箱：</label>
                                    <div class="col-md-3">
                                        <input id="email" name="email" type="text" class="form-control" maxlength="120"
                                               value="${xsrygl.email}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <textarea class="form-control" rows="3" name="remark"
                                                  maxlength="1100">${xsrygl.remark}</textarea>
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
        $("input[name='rssj']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='zyqq']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='zyzq']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='zzsj']").datepicker({format: 'yyyy-mm-dd'});
        $("input[name='lzsj']").datepicker({format: 'yyyy-mm-dd'});
    });

    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/business/xsrygl/query";
    }

    $("#selectTjr").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});
    $("#selectZjsj").colorbox({iframe: true, width: "100%", height: "100%", scrolling: true});

    function selectTjr() {
        $("#selectTjr").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectTjr");
        //合作机构选择弹框
        $("#selectZjsj").attr("href", "${pageContext.request.contextPath}/business/xsrygl/query?cxmk=selectZjsj");
    }

    $(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                ssgs: {
                    required: true
                },
                name: {
                    required: true
                },
                code: {
                    required: true
                },
                dept: {
                    required: true
                },
                status: {
                    required: true
                },
                rssj: {
                    required: true
                },
                mobile: {
                    required: true
                },
                idNo: {
                    required: true
                },
                zyz: {
                    required: true
                },
                zyqq: {
                    required: true
                },
                zyzq: {
                    required: true
                },
                rank: {
                    required: true
                },
                zzmm: {
                    required: true
                },
                xb: {
                    required: true
                },
                mz: {
                    required: true
                },
                xl: {
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

    function selectTjrCallback(selectTjr) {
        $("#tjr").val(selectTjr.name);
        $("#tjrgh").val(selectTjr.code);
    }

    function selectZjsjCallback(selectZjsj) {
        $("#zjsj").val(selectZjsj.name);
        $("#zjsjgh").val(selectZjsj.code);
    }
</script>
<itech:promptInfo type="alert"></itech:promptInfo>
</html>
