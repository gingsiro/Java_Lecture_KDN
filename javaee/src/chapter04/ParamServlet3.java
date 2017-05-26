package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/paramtest3.do")
public class ParamServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ParamServlet3() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>			  ");
		out.println("<html>						  ");
		out.println("<head>                       ");
		out.println("<meta charset='UTF-8'>       ");
		out.println("<title>입력 정보 확인</title>");
		out.println("</head>                      ");
		out.println("<body>                       ");
		out.println("	<p> 					  ");
		out.println(" 		<br/>아이디 : " + id);
		out.println(" 		<br/>비밀번호 : " + pw);
		out.println("	</p>					  ");
		out.println("</body>                      ");
		out.println("</html>                      ");
	}
}
