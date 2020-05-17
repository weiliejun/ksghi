<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Page Forbidden :(</title>
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
        403 Page Forbidden <span>:(</span>
    </h1>
    <p>Sorry, but the page you were trying to view was forbidden.</p>
    <p>It looks like this was the result of either:</p>
    <ul>
        <li>you are not an administrator</li>
        <li>you do not have sufficient privileges</li>
        <li>a mistyped address</li>
    </ul>
    <p>
        <a href="javascript:history.go(-1);">&lt;&lt; 后退到上次访问页面</a>
    </p>
</div>
</body>
</html>