<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城会员注册页面</title>
    <%--    <base href="http://localhost:8080/book/">--%>
    <%--    <link type="text/css" rel="stylesheet" href="static/css/style.css">--%>
    <%--    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
    <%@ include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            $("#sub_btn").click(function () {
                const username = $("#username").val();
                const usernamePattern = /^\w{5,12}$/;
                if (!usernamePattern.test(username)) {
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }
                const password = $("#password").val();
                const passwordPattern = /^\w{5,12}$/;
                if (!passwordPattern.test(password)) {
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }
                const confirmPassword = $("#repwd").val();
                if (confirmPassword !== password) {
                    $("span.errorMsg").text("密码不一致！");
                    return false;
                }
                const email = $("#email").val();
                const emailPattern = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPattern.test(email)) {
                    $("span.errorMsg").text("邮箱不合法！");
                    return false;
                }
                const code = $.trim($("#code").val());
                if (code == null || code === "") {
                    $("span.errorMsg").text("验证码为空");
                    return false;
                }
                return true;
            })

            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            })
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册书城会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
                        <img alt="" id="code_img" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 130px; height: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>