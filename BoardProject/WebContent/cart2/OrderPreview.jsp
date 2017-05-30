<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.kdn.model.domain.*"%>
<jsp:useBean id="cart" class="java.util.HashMap" scope="session" />
<%
	int totalPrice = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" board="0">
		<tr>
			<td>상품이름</td>
			<td>단가</td>
			<td>개수</td>
			<td>금액</td>
		</tr>
		<%
			if (cart == null || cart.size() == 0) {
		%>
		<tr>
			<td colspan="4" align="center">장바구니에 담기 상품이 없습니다.</td>
		</tr>
		<%
			} else {
				Collection<Goods> list = cart.values();
				for (Goods g : list) {
					int price = g.getTotalprice();
					totalPrice += price;
		%>
		<tr>
			<td><%=g.getProname()%></td>
			<td><%=g.getProprice()%></td>
			<td><%=g.getQuantity()%></td>
			<td><%=price%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="3" align="right">주문한 총금액</td>
			<td><%=totalPrice%></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="book.html">책</a>
</body>
</html>




