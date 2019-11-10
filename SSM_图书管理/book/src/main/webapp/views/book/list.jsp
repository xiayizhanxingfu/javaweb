<%--
  Created by IntelliJ IDEA.
  User: 下一张幸福
  Date: 08/11/2019
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table>
            <caption>图书列表</caption>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>author</th>
                <th>isbn</th>
                <th>classify</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${bookList}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.bookName}</td>
                    <td>${item.bookAuthor}</td>
                    <td>${item.bookIsbn}</td>
                    <td>${item.classifyId}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/book/delete?id=${item.id}">删除</a>
                        <a href="<%=request.getContextPath()%>/book/update?id=${item.id}">更新</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="<%=request.getContextPath()%>/book/add">添加</a><br>
        <a href="<%=request.getContextPath()%>/classify/list">分类</a><br>
        <a href="<%=request.getContextPath()%>/login.jsp">返回登录</a>
    </body>
</html>
