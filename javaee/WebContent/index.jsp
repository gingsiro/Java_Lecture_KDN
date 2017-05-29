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
	String id = (String) session.getAttribute("id");
	if(id != null){
		%>
			<%=id%> <a href="logout.do" onClick="return confirm('정말 로그아웃 하시겠습니까?')">로그아웃</a><br/>
		<%
	}else{
		%>
			<a href="loginForm.do">로그인</a><br/>
		<%
	}
%>
</body>
</html>
