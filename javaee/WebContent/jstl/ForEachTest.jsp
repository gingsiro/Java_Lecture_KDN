<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kdn.model.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String[] price = {"1000", "2000", "3000", "4000", "5000"};
	String str = "Hello, World, Java";
	ArrayList<Member> members = new ArrayList<Member>(5);
	members.add(new Member("홍길동", "1", "1", "1", "1"));
	members.add(new Member("길동홍", "2", "1", "1", "1"));
	members.add(new Member("동홍길", "3", "1", "1", "1"));
	members.add(new Member("홍동길", "4", "1", "1", "1"));
	members.add(new Member("길홍동", "5", "1", "1", "1"));
	
	pageContext.setAttribute("price", price);
	pageContext.setAttribute("str", str);
	pageContext.setAttribute("members", members);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<c:forEach var="p" items="${ price }">
			<tr>
				<td>가격</td><td>${ p }</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<table align="center">
		<caption>전체 회원 목록</caption>
		<tr><td>이름</td><td>아이디</td><td>주소</td></tr>
		<c:forEach var="member" items="${ members }">
			<tr>
				<td>${ member.name }</td>
				<td>${ member.id }</td>
				<td>${ member.address }</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<table align="center">
		<c:forEach var="msg" items="${ str }" varStatus="cnt">
			<tr><td>문자정보${ cnt.count }</td><td>${ msg }</td></tr>
		</c:forEach>
		<br/>
		<c:forTokens var="msg" items="${ str }" varStatus="cnt" delims=",">
			<tr><td>문자정보${ cnt.count }</td><td>${ msg }</td></tr>
		</c:forTokens>
	</table>
</body>
</html>