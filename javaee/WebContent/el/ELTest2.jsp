<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이  름 : ${ param.name }<br/>
	주  소 : ${ param.address }<br/>
	이메일 : ${ param.email }<br/>
	취  미 : ${ paramValues.hobby[0] }, ${ paramValues.hobby[1] }
		   , ${ paramValues.hobby[2]/2 }<br/>
	
	header : ${ header.accept }<br/>
			 ${ header['user-agent'] }<br/>
	쿠  키 : ${ cookie['JSESSIONID'].value }
</body>
</html>