<%@page import="com.kai.bean.Classify"%>
<%@page import="com.kai.bean.Book"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>${sessionScope.classify.classifyName }</caption>
		<tr>
			<th>ID</th>
			<th>名称</th>
			<th>作者</th>
			<th>编号</th>
			<th>出版社</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${sessionScope.books }" var="b" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${b.bookName}</td>
				<td>${b.bookAuthor}</td>
				<td>${b.id}</td>
				<td>${b.bookIsbn}</td>
				<td><a href="deleteBook?id=${b.id }">删除</a> <a
					href="updatebook?id=${b.id }&classifyId=${b.classifyId }">更新</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr broader='1'/>
	<form action="bookServlet" method="get">
		<select name="classifyId">
			<c:forEach items="${sessionScope.classifys }" var="classifys">
				<option value="${classifys.classifyId }">${classifys.classifyName }</option>
			</c:forEach>
			</section>
			<input type="submit">
	</form>
	
	<a href="addbook.jsp">点击添加图书</a>
	<br>
	<a href="classifybook">点击查看图书分类</a>
</body>
</html>