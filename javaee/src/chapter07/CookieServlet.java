package chapter07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookietest.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = request.getParameter("cookiename");
		String cookieValue = request.getParameter("cookievalue");
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		/*
		 * setMaxAge(sec)
		 * 		int sec 
		 * 			양수 : 지정한 시간만큼 Memory에 유지
		 * 				   지정한 시간 전에 브라우저가 종료되면 File형태로 저장
		 * 			0	 : 발급한 Cookie 삭제
		 * 			음수 : Memory에만 저장
		 * 				   브라우저 종료되면 발급한 Cookie 삭제
		 */
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		response.sendRedirect("CookieTest.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
