<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kdn.model.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String[] price = {"1000", "2000", "3000", "4000", "5000"};
	String str = "Hello, World, Java";
	Member member = new Member("홍길동", "1", "1", "1", "1");
	
	pageContext.setAttribute("price", price);
	pageContext.setAttribute("str", str);
	pageContext.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="total" value="0" />
	<table align="center">
		<caption>가격 목록</caption>
		<c:forEach var="p" items="${ price }">
			<tr>
				<td>가격</td><td>${ p }</td><td><c:set var="total" value="${ total+p }"/>${ total }</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	
	<c:set target="${ member }" property="id" value="kdn" />
	<table align="center">
		<caption>회원 정보</caption>
		<tr><td>이름</td><td>아이디</td><td>주소</td></tr>
			<tr>
				<td>${ member.name }</td>
				<td>${ member.id }</td>
				<td>${ member.address }</td>
			</tr>
	</table>
</body>
</html>