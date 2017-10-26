<%@ page import="java.util.*" pageEncoding="UTF-8" contentType="text/html" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>登陆</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--jquery-->
    <script src="../../resources/js/lib/jquery/jquery-3.1.1.min.js"></script>
    <!--bootstrap-->
    <link href="../../resources/js/lib/bootstrap3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/js/lib/bootstrap3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="../../resources/js/lib/bootstrap3.3.7/js/bootstrap.js"></script>
    <!--user css-->
    <jsp:include page="/WEB-INF/page/base/include.jsp"></jsp:include>
    <link href="../../resources/css/login.css" rel="stylesheet">
    <script src="../../resources/js/login.js"></script>
</head>
<body>

<div class="container">
    <div class="form-signin">
        <h2 class="form-signin-heading">用户登录</h2>
        <label for="inputEmail" class="sr-only">邮箱</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" id="remeberPassWord">记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="login">登录</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="register">注册</button>
    </div>
</div>
</body>
</html>
