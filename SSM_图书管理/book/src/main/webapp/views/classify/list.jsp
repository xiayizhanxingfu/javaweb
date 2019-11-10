<%--
  Created by IntelliJ IDEA.
  User: 下一张幸福
  Date: 08/11/2019
  Time: 14:28
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
                <th>操作</th>
            </tr>
            <c:forEach items="${classifyList}" var="item">
                <tr>
                    <td>${item.classifyId}</td>
                    <td>${item.classifyName}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/classify/delete?id=${item.classifyId}">删除</a>
                        <a href="<%=request.getContextPath()%>/classify/update?id=${item.classifyId}">更新</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="<%=request.getContextPath()%>/classify/add">添加</a><br>
        <a href="<%=request.getContextPath()%>/book/list">返回查看</a><br>
        <a href="<%=request.getContextPath()%>/login.jsp">返回登录</a>
    </body>
</html>
