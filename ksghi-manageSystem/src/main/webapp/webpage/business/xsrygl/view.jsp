<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>销售员申请入职信息</title>
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
                    <h4>销售人员信息管理－销售员申请入职信息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/business/xsrygl/save" role="form">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="icon-pencil"></i>销售员申请入职信息
                                </h3>
                            </div>
                            <input name="id" type="hidden" class="form-control" maxlength="50" value="${xsrygl.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-2 control-label">所属公司：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.ssgs}</p>
                                    </div>
                                    <label class="col-md-2 control-label">基本法：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.jbf}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">员工姓名：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.name}</p>
                                    </div>
                                    <label class="col-md-2 control-label">机构(部门)：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.dept}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">旧员工工号：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.codeOld}</p>
                                    </div>
                                    <label class="col-md-2 control-label">员工工号：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.code}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">员工状态：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.status}</p>
                                    </div>
                                    <c:choose>
                                        <c:when test="${xsrygl.status == '正式员工'}">
                                            <label class="col-md-2 control-label">转正时间：<i
                                                    class="icons-mark-required"></i></label>
                                            <div class="col-md-3">
                                                <div class="input-group">
                                                    <div class="input-group date">
                                                        <p class="form-control-static">${xsrygl.zzsj}</p>
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
                                                        <p class="form-control-static">${xsrygl.lzsj}</p>
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
                                                        <p class="form-control-static">${xsrygl.rssj}</p>
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
                                            <p class="form-control-static">${xsrygl.tjr}</p>
                                        </div>
                                    </div>
                                    <label class="col-md-2 control-label">直接上级：</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <p class="form-control-static">${xsrygl.zjsj}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">推荐人工号：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.tjrgh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">上级工号：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.zjsjgh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">本人手机：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.mobile}</p>
                                    </div>
                                    <label class="col-md-2 control-label">身份证号：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.idNo}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">银行名称：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.yhmc}</p>
                                    </div>
                                    <label class="col-md-2 control-label">银行卡号：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.yhkh}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">执业证：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.zyz}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">执业起期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.zyqq}</p>
                                    </div>
                                    <label class="col-md-2 control-label">执业止期：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.zyzq}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">职级：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.rank}</p>
                                    </div>
                                    <label class="col-md-2 control-label">政治面貌：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.zzmm}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">性别：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.xb}</p>
                                    </div>
                                    <label class="col-md-2 control-label">民族：<i class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.mz}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">个人学历：<i
                                            class="icons-mark-required"></i></label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.xl}</p>
                                    </div>
                                    <label class="col-md-2 control-label">入司年龄：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.rsnl}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">联系电话：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.lxdh}</p>
                                    </div>
                                    <label class="col-md-2 control-label">联系地址：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.lxdz}</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">电子邮箱：</label>
                                    <div class="col-md-3">
                                        <p class="form-control-static">${xsrygl.email}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">备注：</label>
                                    <div class="col-md-8">
                                        <p class="form-control-static">${xsrygl.remark}</p>
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
                name: {
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
                yhmc: {
                    required: true
                },
                yhkh: {
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
