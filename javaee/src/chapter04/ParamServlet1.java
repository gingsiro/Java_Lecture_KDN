package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/memberinsert.do")
public class ParamServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String[] hobby = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>		<!-- html에 대한 Document Type 지정 -->"); 
		out.println("<html>				<!-- html 시작 root 태그 -->               ");
		out.println("<head>                                                        ");
		out.println("<meta charset='UTF-8'>                                        ");
		out.println("<title>입력 정보 확인</title>                                 ");
		out.println("</head>                                                       ");
		out.println("<body>                                                        ");
		out.println("	<p> 													   ");
		out.println(" 		이름 : "+ name);
		out.println(" 		<br/>아이디 : "+ id);
		out.println(" 		<br/>비밀번호 : "+ pw);
		out.println(" 		<br/>주소 : "+ address);
		out.println(" 		<br/>이메일 : "+ email);
		out.println(" 		<br/>취미 : ");
		if(hobby != null){
			for (int i = 0; i < hobby.length; i++) {
				out.println(hobby[i]);
				if(i < hobby.length - 1){
					out.println(", ");
				}
			}
		}
		out.println("	</p>													   ");
		out.println("</body>                                                       ");
		out.println("</html>                                                       ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
