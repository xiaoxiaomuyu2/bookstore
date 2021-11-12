<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItemClass").click(function () {
                let bookName = $(this).parent().parent().find("td:first").text();
                return confirm("你确定要删除【" + bookName + "】吗?");
            })

            $("#clearCart").click(function () {
                return confirm("你确定要删除清空购物车吗?");
            })

            $(".updateCount").change(function () {
                let bookName = $(this).parent().parent().find("td:first").text();
                let count = $(this).val();
                let id = $(this).attr("bookId")
                // alert(bookName);
                if (confirm("你确定要删除修改【" + bookName + "】的数量吗?")) {
                    location.href = "<%=basePath%>cartServlet?action=updateCount&count="
                        + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                }
            })
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <%--如果购物车空的情况--%>
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空！快跟小伙伴们去浏览商品吧！！！</a>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <%--如果购物车非空的情况--%>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                        <%--                    <td>${entry.value.count}</td>--%>
                    <td><input type="text" class="updateCount" value="${entry.value.count}" bookId="${entry.value.id}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItemClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>