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
	<%! int count = 1;  %>
	<% if(++count > 5){
		/*session을 만료 시킴
		 새로운 JSESSIONID를 부여함으로 이전 session에 접근 불가하게 함
		session.invalidate();
		*/
	}
	%>
</body>
</html>