package chapter07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getParameter("id") : form 양식에서 파라미터 데려올 때
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg = null;
		
		if(id != null && id.equals("kdn")){
			if(pw!=null & pw.equals("111")){
				//인증된 경우 => session에 인증 정보 (id, 권한, 이름...)
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
			}else{
				msg = "비밀번호 오류";
			}
		}else{
			msg = "가입되지 않은 아이디 입니다.";
		}
		
		RequestDispatcher send = null;
		
		if(msg != null){ //인증되지 않은 상황
			send = request.getRequestDispatcher("/member/Login.jsp");
			request.setAttribute("msg", msg);
		}else{
			send = request.getRequestDispatcher("/index.jsp");
		}
		
		send.forward(request, response);
	}
}
