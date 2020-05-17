<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理控制台-修改密码</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <form id="searchForm" method="post"
                  action="${pageContext.request.contextPath}/portal/user/account/password/save" class="form-horizontal">
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            <i class="icon-pencil"></i>密码设置
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="col-xs-2 control-label">旧密码：</label>
                            <div class="col-xs-3">
                                <input class="form-control" id="oldPassword" name="oldPassword" size="30"
                                       type="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">新密码：</label>
                            <div class="col-xs-3">
                                <input class="form-control" id="password" name="password" size="30" type="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">新密码确认：</label>
                            <div class="col-xs-3">
                                <input class="form-control" id="password2" name="password2" size="30" type="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-3">
                                <div class="notifications"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-3">
                                <input id="saveButton" type="button" class="btn btn-primary" value="保 存">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="col-sm-offset-6 col-sm-12"></div>

        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        var searchFormValidate = $("#searchForm").validate({
            rules: {
                oldPassword: {
                    required: true
                },
                password2: {
                    equalTo: "#password",
                    required: true
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 50
                }
            },
            messages: {
                password2: {
                    equalTo: "你两次输入的密码不相同，请核对！"
                }
            },
        });

        $("#saveButton").click(function () {
            if (searchFormValidate.form()) {
                $("#oldPassword").val(hex_md5($("#oldPassword").val()));
                $("#password").val(hex_md5($("#password").val()));
                $("#password2").val(hex_md5($("#password2").val()));
                $.ajax({
                    type: "POST",
                    data: $("#searchForm").serialize(),
                    url: "${pageContext.request.contextPath}/index/password/change/save",
                    dataType: 'json',
                    success: function (data) {
                        if (data.flag == "true") {
                            $('.notifications').notify({
                                message: {text: '新密码设置成功！'},
                                type: 'success'
                            }).show();
                            myClearForm('searchForm');
                        } else if (data.flag == "false") {
                            $('.notifications').notify({
                                message: {text: data.message},
                                type: 'danger'
                            }).show();
                            myClearForm('searchForm');
                        }
                    },
                    error: function (e) {
                        $('.notifications').notify({
                            message: {text: '抱歉，程序访问出现错误！请联系管理员。'},
                            type: 'danger'
                        }).show();
                    }
                });
            }
        });

    });
</script>
</html>
