<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//서버에서 발행한 모든 쿠키 추출
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){ %>
				쿠키 이름 : <%=cookie.getName() %> 
				쿠키 값 : <%=cookie.getValue() %> <br/> 
				<%
			}
		}
	%>
	<form action="cookietest.do" method="post">
		<table align="center">
			<tr>
				<td>쿠키 이름</td>
				<td><input type="text" name="cookiename" id="cookiename" /></td>
			</tr>
			<tr>
				<td>쿠키 값</td>
				<td><input type="text" name="cookievalue" id="cookievalue" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="전송" /></td>
			</tr>
		</table>
	</form>
</body>
</html>