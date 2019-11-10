<%--
  Created by IntelliJ IDEA.
  User: 下一张幸福
  Date: 08/11/2019
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/book/addBook" method="post">
            <label>
                bookName:<input name="bookName">
            </label><br>
            <label>
                bookAuthor:<input name="bookAuthor">
            </label><br>
            <label>
                bookIsbn:<input name="bookIsbn">
            </label><br>
            <label>
                classifyId:<input name="classifyId">
            </label><br>
            <input type="submit">
        </form>
    </body>
</html>
