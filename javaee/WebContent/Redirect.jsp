<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재 페이지는 Redirect.jsp <br/>
	<% String msg = (String) request.getAttribute("msg"); %>
	msg : <%=msg %> <br/>
	name : <%=request.getParameter("name") %>
</body>
</html>