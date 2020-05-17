<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>合同模型</title>
    <%@ include file="/webpage/common/public.jsp" %>
</head>
<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <i class="icon-file"></i>合同模型
                            </h3>
                        </div>
                        <div class="panel-body">
                            <img src="${contractAttachmentsPath}"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-offset-3 col-md-3">
                    <button onclick="javascript:history.go(-1);" type="button" class="btn btn-primary">
                        <i class="icon-undo2"></i>返回
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
