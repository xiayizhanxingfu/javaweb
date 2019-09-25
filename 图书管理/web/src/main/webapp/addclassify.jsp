<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addclassify" method="post">
		<table>
			<tr>
				<td>分类ID:</td>
				<td><input name="classify_id"></td>
			</tr>
			<tr>
				<td>分类名称</td>
				<td><input name="classify_name"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>