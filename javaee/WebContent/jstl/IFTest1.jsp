<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msg{
	color : red;
	font-size : 20px;
	font-style : bold;
}
</style>
</head>
<body>
	<img src='images/Lighthouse.jpg' width='50'>
	<img src='/javaee/images/animated-overlay.gif' width='50'>
	<%
		String msg = (String) request.getAttribute("msg");
		if(msg != null){
			%>
			<span id='msg'><%=msg %></span>
			<%
		}
	%>
	
	<form action="IFTest2.jsp" method="post">
		<table align="center">
			<tr>
				<td>User Type</td>
				<td><input type="text" name="user" id="user" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
</body>
</html>