<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<td>Directive Include</td>
			<td><%@include file='CookieTest.jsp' %></td>
		</tr>
		<tr>
			<td>Action Tag Include _ url</td>
			<td><jsp:include page='CookieTest.jsp'></jsp:include></td>
		</tr>
		<tr>
			<td>Action Tag Include _ urlPattern</td>
			<td><!--<jsp:include page='member/paramtest3.do'>-->
				<jsp:param value="kdn" name="id"/>
				<jsp:param value="111" name="pw"/>
				</jsp:include></td>
		</tr>
	</table>
</body>
</html>