<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>推送信息录入管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/redactor.jsp" %>
</head>

<body onload="javascript:openTypeChange(document.getElementById('openType'))">
<div id="wrapper">

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 page-header">
                    <h4>推送消息管理－新增消息</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal" id="searchForm" method="post"
                          action="${pageContext.request.contextPath}/appPushManage/add" enctype="multipart/form-data">
                        <div class="panel panel-default">
                            <input id="id" name="id" maxlength="36" type="hidden" class="form-control"
                                   value="${appPushManage.id}"/>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息名称</label>
                                    <div class="col-md-3">
                                        <input id="messageName" name="messageName" maxlength="36" type="text"
                                               value="${appPushManage.messageName}" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息类型</label>
                                    <div class="col-md-3">
                                        <itech:code type="select" code="appPushManageType" property="type"
                                                    value="${appPushManage.type}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>消息内容</label>
                                    <div class="col-md-6">
                                        <textarea id="content" name="content" class="form-control" rows="8"
                                                  maxlength="500">${appPushManage.content}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>跳转类型</label>
                                    <div class="col-md-3">
                                        <itech:code type="select" code="app.openType" property="openType"
                                                    value="${appPushManage.openType}"
                                                    bind="onchange=>openTypeChange(this)"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label id="urlLabel" class="col-md-3 control-label">URL</label>
                                    <div class="col-md-6">
                                        <input id="url" name="url" type="text" value="${appPushManage.url}"
                                               class="form-control" placeholder="跳转类型如果是产品详情请填写产品ID,如果是活动专题页请填写相应的URL"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>自动推送</label>
                                    <div class="col-md-9">
                                        <itech:code type="radio" code="app.isAutoPush" property="isAutoPush"
                                                    value="${appPushManage.isAutoPush}"
                                                    defaultValue="${appPushManage.isAutoPush == null ? 'false' : appPushManage.isAutoPush }"/>
                                    </div>
                                </div>
                                <div class="form-group" id="isAutoPush_div">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>推送时间</label>
                                    <div class="col-md-3">
                                        <input id="pushTime" name="pushTime" maxlength="36" type="text"
                                               class="form-control" readonly="readonly"
                                               value="${appPushManage.pushTime}"/>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><i
                                            class="icons-mark-required"></i>终端类型</label>
                                    <div class="col-md-9">
                                        <itech:code type="radio" code="app.pushAppType" property="apptype"
                                                    value="${appPushManage.apptype}" defaultValue="androidOrios"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="saveButton" type="button" class="btn btn-primary">
                                            <i class="icon-disk"></i>保存
                                        </button>
                                        <button onclick="goBack();" type="button" class="btn btn-primary">
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
    function goBack() {
        window.location.href = "${pageContext.request.contextPath}/appPushManage/query";
    }

    var searchFormValidate = null;
    $(function () {
        $("#isAutoPush_div").hide();
        var isAutoPush = $('input[name=isAutoPush][checked]').val();
        if (isAutoPush == "false") {
            $("#isAutoPush_div").hide();
        } else {
            $("#isAutoPush_div").show();
        }


        $("input[name='isAutoPush']").bind("change", function () {
            var isTrue = eval($("input[name='isAutoPush']:checked").val());
            if (isTrue) {
                var pushTime = $("#pushTime").val();
                $("#pushTime").val(pushTime);
                $("#isAutoPush_div").show();
            } else {
                $("#isAutoPush_div").hide();
            }
        });
        searchFormValidate = $("#searchForm").validate({
            rules: {
                messageName: {
                    required: true
                },
                type: {
                    required: true
                },
                content: {
                    required: true
                },
                openType: {
                    required: true
                },
                isAutoPush: {
                    required: true
                },
                pushTime: {
                    required: true
                },
                apptype: {
                    required: true
                }
            }
        });
        $("#pushTime").datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            useSeconds: true
        });

        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#searchForm").submit();
            }
        });
    });

    //验证是否是url
    function IsURL() {
        var strRegex = '^((https|http|ftp|rtsp|mms)?://)'
            + '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@
            + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
            + '|' // 允许IP和DOMAIN（域名）
            + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
            + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
            + '[a-z]{2,6})' // first level domain- .com or .museum
            + '(:[0-9]{1,4})?';// 端口- :80

        var re = new RegExp(strRegex);
        var url = $("#url").val();
        //alert(url);
        if (re.test(url)) {
            //alert("成功");
            return true;
        } else {
            bootbox.alert("您输入的URL不正确");
            $("#url").val("");
            //document.getElementById("url").focus();
            return false;
        }
    }

    //跳转类型change，改变url的校验规则
    function openTypeChange(obj) {
        var openType = obj.value;
        //清除校验
        $("#url").rules("remove");
        $("#urlLabel").html("URL");
        //根据参数添加校验
        if (openType == "2") {
            $("#url").rules("add", {
                required: true
            });
            $("#urlLabel").html("<i class=\"icons-mark-required\"></i>URL");
        } else if (openType == "3") {
            $("#url").rules("add", {
                required: true,
                isUrl: true
            });
            $("#urlLabel").html("<i class=\"icons-mark-required\"></i>URL");
        }
    }
</script>
</html>
