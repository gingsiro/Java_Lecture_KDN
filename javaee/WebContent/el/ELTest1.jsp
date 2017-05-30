<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.kdn.model.domain.Member" />
<jsp:setProperty name="member" property="name" value="kdn" />
<% String[] names={"한전","남궁현","신연석", "이재원", "강추영", "한구민"};
   pageContext.setAttribute("names",names);	
   pageContext.setAttribute("name","id");
   member.setId("kkk");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원이름 : ${ pageScope.member.name },
			   ${ pageScope['member'].name },
			   ${ member.name },
			   ${ member[name] }<br/>
	이름들 : ${ pageScope.names['0'] }, ${ pageScope.names[0] }<br/> 
			 ${ names[1] }, ${ names[1] }<br/>
			 ${ names[2] }, ${ names[2] }<br/>
			 ${ names[3] }, ${ names[3] }<br/>
			 ${ names[4] }, ${ names[4] }<br/>
			 ${ names[5] }, ${ names[5] }<br/>
</body>
</html>