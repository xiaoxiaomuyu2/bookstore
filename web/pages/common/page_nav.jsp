<%--
  Created by IntelliJ IDEA.
  User: 92386
  Date: 2021/11/4
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNumber > 1}">
        <a href="${requestScope.page.url}&pageNumber=1&pageSize=${requestScope.page.pageSize}">首页</a>
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber-1}&pageSize=${requestScope.page.pageSize}">
            上一页
        </a>
    </c:if>
    <%--        <a href="#">3</a>--%>
    第【${requestScope.page.pageNumber}】页
    <%--        <a href="#">5</a>--%>
    <c:if test="${requestScope.page.pageNumber < requestScope.page.totalPageCount}">
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.pageNumber+1}&pageSize=${requestScope.page.pageSize}">
            下一页
        </a>
        <a href="${requestScope.page.url}&pageNumber=${requestScope.page.totalPageCount}&pageSize=${requestScope.page.pageSize}">
            末页
        </a>
    </c:if>
    共${requestScope.page.totalPageCount}页，${requestScope.page.totalItemCount}条记录
    到第<input value="" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="searchPageButton"/>
</div>
<script type="text/javascript">
    $(function () {
        $("#searchPageButton").click(function () {
            let pageNumber = $("#pn_input").val();
            if (pageNumber < 1 || (${requestScope.page.totalPageCount}) < pageNumber) {
                alert("输入的页码无效！");
            } else {
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNumber="
                    + pageNumber + "&pageSize=${requestScope.page.pageSize}";
            }
        })
    })
</script>
