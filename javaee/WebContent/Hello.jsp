<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int count = 0; %> <%-- 속성으로 선언 --%>
<% int local = 0; //로컬 변수 %>
	count = <%= ++count %>
	local = <%= ++local %>
</body>
</html>