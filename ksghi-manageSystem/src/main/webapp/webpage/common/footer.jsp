<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="java.text.SimpleDateFormat" %>

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
<div id="scroll-top" title="返回顶部">
    <i class="glyphicon glyphicon-chevron-up"></i>
</div>

<style type="text/css">
    #scroll-top {
        position: fixed;
        bottom: 105px;
        right: 100px;
        opacity: 1;
        cursor: pointer;
        z-index: 100;
        width: 55px;
        height: 50px;
        text-align: center;
        padding-top: 8px;
        background-color: #f3f3f3;
        border: 1px solid #ccc;
        font-size: 24px;
        border-radius: 4px;
    }

    #scroll-top i {
        color: #999;
    }

    #scroll-top i:hover, #scroll-top i:link, #scroll-top i:visited {
        color: #245dc1;
    }
</style>