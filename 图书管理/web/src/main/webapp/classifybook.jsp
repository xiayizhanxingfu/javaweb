<%@page import="com.kai.bean.Classify"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书分类</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<td>分类ID</td>
			<th>名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${sessionScope.classifybooks }" var="classifybooks" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${classifybooks.classifyId }</td>
				<td>${classifybooks.classifyName }</td>
				<td>
					<a href="deleteclassify?classify_id=${classifybooks.classifyId }">删除</a>
					<a href="updateclassify?classify_id=${classifybooks.classifyId }">更新</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr broader='1'/>
	<a href="addclassify.jsp">添加图书分类</a>
	<br>
	<a href="bookServlet">返回图书列表</a>
</body>
</html>