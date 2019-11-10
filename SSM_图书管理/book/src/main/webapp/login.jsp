<%--
  Created by IntelliJ IDEA.
  User: 下一张幸福
  Date: 08/11/2019
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/user/login" method="post">
            <label>
                username:<input name="username">
            </label><br>
            <label>
                password:<input name="password">
            </label><br>
            <input type="submit">
        </form>
    </body>
</html>
