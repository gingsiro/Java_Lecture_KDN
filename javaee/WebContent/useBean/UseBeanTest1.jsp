<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.kdn.model.domain.Member" scope="session" />
	<jsp:setProperty property="*" name="member"/>
	
	<%= member %>
	<a href="UseBeanTest2.jsp">UseBeanTest2.jsp</a>
</body>
</html>