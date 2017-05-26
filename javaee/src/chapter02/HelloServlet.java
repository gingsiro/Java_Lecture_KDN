package chapter02;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet("/url") Web Module 3.0부터 지원
 * servlet의 요청 url 설정
 * 하나의 서블릿은 하나의 url 가능
 * 
 * '/는 context를 의미
 *           html/
 * http://IP:port/context/
 * 			      servlet/
 * 
 * => web.xml에 
 *   <servlet>
 *   	<servlet-name>HelloServlet</servlet-name>
 *   	<servlet-class>chapter02.HelloServlet</servlet-class>
 *   </servlet>
 *   <url-mapping>
 *   	<servlet-name>HelloServlet</servlet-name>
 *   	<url-pattern>/Hello.do</url-pattern>
 *   </url-mapping>
 */
@WebServlet("/Hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HelloServlet() {
		super();
	}
	//@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답하기 위한 Encoding 설정을 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		/**
		 * response.setContentType("");
		 * 응답하는 내용(Content)에 대한 mime type 설정
		 * 생략 시 기본적으로 text/html;charset=iso-8859-1로 설정
		 */
//		response.setContentType("application/msword");
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.println("<member><id>kdn</id>");
		
		// Client 에게 응답하기 위해 출력하는 객체
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>          ");
//		out.println("<html>                   ");
//		out.println("<head>                   ");
//		out.println("<meta charset='UTF-8'>   ");
//		out.println("</head>                  ");
//		out.println("<body>                   ");
//		out.println("    <div>                ");
//		out.println("        <h1>Header-0</h1>");
//		out.println("        <h1>Header-1</h1>");
//		// Calendar today = Calendar.getInstance();
//		Date today = new Date();
//		out.println("		 <p> 현재 시간 : " + today.toLocaleString() + "</p>");
//		out.println("    </div>               ");
//		out.println("</body>                  ");
//		out.println("</html>                  ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
