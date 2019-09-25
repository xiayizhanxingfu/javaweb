<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update update classify</title>
</head>
<body>
<form action="updateclassify" method="post">
		<table>
			<tr>
				<td></td>
				<td><%=session.getAttribute("classify_id") %></td>
			</tr>
			<tr>
				<td>名称:</td>
				<td><input name="classify_name"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>