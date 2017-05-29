<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSESSIONID : <%= session.getId() %>
	<%
	/*
	* 현재 페이지에 지정한 시간만큼 접속하지 않으면 session을 만료
	*/
	//session.setMaxInactiveInterval(3);
	
	/*
	* web.xml에 서버 타임아웃을 지정
	* 해당 context 전체에 지정한 시간만큼 접속하지 않으면 session을 만료
	*/
	%>
</body>
</html>