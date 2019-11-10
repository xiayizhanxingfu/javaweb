<%--
  Created by IntelliJ IDEA.
  User: 下一张幸福
  Date: 10/11/2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/classify/updateClassify" method="post">
            <label>
                classifyId:<input name="classifyId" value="<%=request.getAttribute("id")%>" readonly unselectable="on">
            </label><br>
            <label>
                classifyName:<input name="classifyName">
            </label><br>
            <input type="submit">
        </form>
    </body>
</html>
