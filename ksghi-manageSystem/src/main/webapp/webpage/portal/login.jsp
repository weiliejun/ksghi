<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>北京国恒保险代理管理系统v1.0</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ui/themes/base/img/logo/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/google-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ui/themes/base/css/login.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/js/bootstrap.min.js"></script>
    <%@ include file="/webpage/common/plugins/form.jsp" %>
    <%@ include file="/webpage/common/plugins/notify.jsp" %>
    <!--[if lte IE 6]>
    <link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie6.css" rel="stylesheet"
          type="text/css">
    <![endif]-->
    <!--[if lt IE 9 ]>
    <link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie78.css" rel="stylesheet"
          type="text/css">
    <![endif]-->
    <!--[if IE 9 ]>
    <link href="${pageContext.request.contextPath}/assets/ui/core/css/bootstrap-ie9.css" rel="stylesheet"
          type="text/css">
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/assets/ui/core/js/html5shiv-3.7.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/ui/core/js/respond-1.3.0.min.js"></script>
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <span class="navbar-brand">北京国恒保险代理管理系统v1.0</span>
            </div>
            <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <p class="welcome-txt">您好！欢迎访问本系统，IP: ${clientIp}</p>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div id="left-panel">
                    <img src="${pageContext.request.contextPath}/assets/ui/themes/base/img/login/login-bg.png"/>
                </div>
            </div>
            <div class="col-md-4">
                <div id="login-panel" class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">请登录</h2>
                    </div>
                    <div class="panel-body">
                        <form id="searchForm" method="post" role="form">
                            <fieldset>
                                <div class='notifications'></div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="icon-user"></i></span> <input
                                            type="text" name="code" id="code" class="form-control" placeholder="账号"
                                            value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="icon-key"></i></span> <input
                                            type="password" name="password" id="password" class="form-control"
                                            placeholder="密码" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="icon-barcode"></i></span> <input
                                            type="text" id="verifyCode" name="verifyCode" class="form-control"
                                            placeholder="效验码" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label> <img id="verifyCodeImage" src=""
                                                 style="width: 120px; height: 30px; vertical-align: middle;">&nbsp;&nbsp;<a
                                            href="javascript:loadVerifyCodeImage();"
                                            style="vertical-align: bottom;">换一张</a>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <input type="button" id="submitBtn" class="btn btn-lg btn-primary btn-block"
                                           value="登 录">
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-center">
                    Copyright ©<%
                    java.util.Date currentTime = new java.util.Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                    out.println(formatter.format(currentTime));
                %>
                    KINGSTAR FORTUNE CORPORATION, inc. <a href="https://www.ksghi.com/" target="_blank">北京国恒保险代理有限公司版权所有。保留所有权利。</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $("#code").focus();

        loadVerifyCodeImage();

        var searchFormValidate = $("#searchForm").validate({
            rules: {
                code: {
                    required: true,
                    maxlength: 50
                },
                password: {
                    required: true,
                    maxlength: 50
                },
                verifyCode: {
                    required: true
                }
            }
        });
        $("#submitBtn").click(function () {
            if (searchFormValidate.form()) {
                $("#submitBtn").addClass("disabled");
                $("#password").val(hex_md5($("#password").val()));
                jQuery.ajax({
                    type: "POST",
                    url: '${pageContext.request.contextPath}/portal/onlogin',
                    data: $("#searchForm").serialize(),
                    success: function (data) {
                        if (data.flag == "true") {
                            location.href = "${pageContext.request.contextPath}/index";
                        } else if (data.flag == "false") {
                            $('.notifications').notify({
                                message: {text: data.message},
                                type: 'danger'
                            }).show();
                            $("#password").val("");
                            loadVerifyCodeImage();
                        }
                    },
                    error: function (e) {
                        $('.notifications').notify({
                            message: {text: '抱歉，程序访问出现错误！请联系管理员。'},
                            type: 'danger'
                        }).show();
                        loadVerifyCodeImage();
                    }
                });
                $("#submitBtn").removeClass("disabled");
            }
        });
    });

    function loadVerifyCodeImage() {
        $("#verifyCodeImage").attr("src", "${pageContext.request.contextPath}/portal/login/verifycode/get?" + Math.random());
    }

    $(function () {
        document.onkeydown = function (e) {
            var ev = document.all ? window.event : e;
            if (ev.keyCode == 13) {
                $("#submitBtn").trigger("click");
            }
        }
    });
</script>
</html>
