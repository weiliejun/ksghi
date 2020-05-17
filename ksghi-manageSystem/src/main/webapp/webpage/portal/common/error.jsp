<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.ByteArrayOutputStream,java.io.PrintStream,java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Page Report Errors :(</title>
    <style>
        html {
            padding: 30px 10px;
            color: #737373;
            background: #f0f0f0;
            -webkit-text-size-adjust: 100%;
            -ms-text-size-adjust: 100%;
        }

        html, input {
            font: 14px/1.5 "Microsoft Yahei", "Tahoma", "SimSun";
            color: #404040;
        }

        body {
            max-width: 530px;
            _width: 530px;
            padding: 30px 30px 50px;
            border: 1px solid #b3b3b3;
            border-radius: 4px;
            margin: 60px auto;
            box-shadow: 0 1px 10px #a7a7a7, inset 0 1px 0 #fff;
            background: #fcfcfc;
        }

        h1 {
            margin: 0 10px;
            font-size: 24px;
            text-align: center;
        }

        h1 span {
            color: #bbb;
        }

        h3 {
            margin: 30px 15px;
        }

        p {
            margin: 5px 0;
        }

        ul {
            padding: 0 0 0 40px;
            margin: 5px 0;
        }

        .container {
            margin: 0 auto;
        }

        a {
            color: #999;
            text-decoration: none;
        }

        a:hover, a:focus {
            color: #2a6496;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>
        Page Reports Errors <span>:(</span>
    </h1>
    <p>Sorry, but the page you were trying to view reports some errors.</p>
    <p>It looks like this was the result of either:</p>
    <ul>
        <li>a mistyped address</li>
        <li>an out-of-date link</li>
    </ul>
    <p>
        <a href="javascript:history.go(-1);">&lt;&lt; 后退到上次访问页面</a>
    </p>
</div>
<div style="display: none;">
    <c:if test="exception!=null">
        <p>
            An exception was thrown:
            <%=exception.getClass()%>:<%=exception.getMessage()%>
        </p>
        <p>
            Request URI:<%=request.getAttribute("javax.servlet.forward.request_uri") %>
        </p>
        <p>Request Attribute:</p>
        <pre>
        <%
            Enumeration<String> e = request.getAttributeNames();
            String key;
            while (e.hasMoreElements()) {
                key = e.nextElement();
                out.println("                " + key + "=" + request.getAttribute(key));
            }
        %>
		</pre>
        <p>Request Parameter:</p>
        <pre>
		<%
            e = request.getParameterNames();
            while (e.hasMoreElements()) {
                key = e.nextElement();
                out.println(key + "=" + request.getParameter(key));
            }
        %>
		</pre>
        <p>With the following stack trace:</p>
        <pre>
			<%
                exception.printStackTrace();
                ByteArrayOutputStream ostr = new ByteArrayOutputStream();
                exception.printStackTrace(new PrintStream(ostr));
                out.print(ostr);
                out.clear();
                out = pageContext.pushBody();
            %>
		</pre>
    </c:if>
</div>
</body>
</html>