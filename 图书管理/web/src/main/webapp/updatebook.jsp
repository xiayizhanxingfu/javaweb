<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update book</title>
</head>
<body>
	<form action="updatebook" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><%=session.getAttribute("id") %></td>
			</tr>
			<tr>
				<td>名称:</td>
				<td><input name="name"/></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input name="author"/></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input name="book_isbn"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>