<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城会员注册页面</title>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <%--    <div>--%>
    <%--        <span>欢迎<span class="um_span">韩总</span>光临书城</span>--%>
    <%--        <a href="../order/order.jsp">我的订单</a>--%>
    <%--        <a href="../../index.jsp">注销</a>&nbsp;&nbsp;--%>
    <%--        <a href="../../index.jsp">返回</a>--%>
    <%--    </div>--%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>