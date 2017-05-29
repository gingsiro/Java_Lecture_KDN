package chapter09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRedirect
 */
@WebServlet("/redirect.do")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("msg", "Hello~~");
		/*
		 * response.sendRedirect(url);
		 *  - 지정한 url로 이동됨.
		 *  - 클라이언트의 요청 정보가 유지 되지 않음
		 *  - request에 저장한 정보가 유지 되지 않음
		 *  - 주소창의 url이 이동한 url로 변함
		 */
		response.sendRedirect("Redirect.jsp");
	}

}
