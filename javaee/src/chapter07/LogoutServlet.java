package chapter07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
		 * 인증 만료 시키는 방법
		 * 1. session에서 인증 정보만 제거
		 *   => session에 인증정보 외에 다른 정보가 저장된 경우
		 * 2. session을 만료
		 *   => session에 인증정보만 저장된 경우
		 */
		// 1.
		//session.removeAttribute('id');
		// 2.
		session.invalidate();
		
		RequestDispatcher send = null;
		send = request.getRequestDispatcher("/index.jsp");
		send.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
