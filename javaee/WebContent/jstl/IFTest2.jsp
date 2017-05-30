<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msg {
	color: red;
	font-size: 20px;
	font-style: bold;
}
</style>
</head>
<body>
	<c:if test="${param.user == 'member'}" >
		<jsp:include page="../member/Login.jsp" />
	</c:if>
	<c:if test="${param.user == 'guest'}" >
		<jsp:include page="../member/memberRegister.html" />
	</c:if>
	<c:if test="${param.user != 'member' && param.user != 'guest'}" >
		member나 guest로 접속하세요.
	</c:if>
	<br/>
	<a href="IFTest1.jsp">다시 하기</a>
</body>
</html>