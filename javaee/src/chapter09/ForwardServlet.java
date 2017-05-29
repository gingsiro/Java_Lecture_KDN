package chapter09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRedirect
 */
@WebServlet("/forward.do")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("msg", "Hello~~");
		/*
		 * response.sendRedirect(url);
		 *  - 동일 Context내에 지정한 url로 이동 됨
		 *  - 클라이언트의 요청 정보가 유지 됨
		 *  - request에 저장한 정보가 유지 됨
		 *  - 주소창의 url이 변하지 않음
		 */
		RequestDispatcher send = request.getRequestDispatcher("Forward.jsp");
		send.forward(request, response);
	}

}
