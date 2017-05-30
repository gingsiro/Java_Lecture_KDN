<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kdn.model.domain.Goods"%>

<jsp:useBean id="cart" class="java.util.HashMap" scope="session" />
<jsp:useBean id="goods" class="com.kdn.model.domain.Goods" />
<jsp:setProperty property="*" name="goods" />

<%
	Goods find = (Goods) cart.get(goods.getProname());
	if (find == null) { //동일한 상품이 카트(장바구니)에 없는 경우 이므로 
		cart.put(goods.getProname(), goods);
	} else { //동일한 상품이 카트(장바구니)에 있으므로 수량만 변경
		find.setQuantity(find.getQuantity() + goods.getQuantity());
	}
	System.out.println(cart);
	response.sendRedirect("book.html");
%>
