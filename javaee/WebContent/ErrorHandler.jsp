<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<caption>오류 발생</caption>
		<tr><td>오류 메세지</td><td><%=exception.getMessage() %></td></tr>
	</table>
</body>
</html>