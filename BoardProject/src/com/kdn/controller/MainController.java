package com.kdn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kdn.model.biz.BoardService;
import com.kdn.model.biz.BoardServiceImpl;
import com.kdn.model.biz.MemberService;
import com.kdn.model.biz.MemberServiceImpl;
import com.kdn.model.domain.PageBean;

/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	private BoardService boardService = new BoardServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp"; //기본 페이지로 index.jsp를 사용한다.
		String content = null; //오류가 나면 에러페이지로 가겠다.
		
		try {
			/* request.getServletPath()
			 * 클라이언트가 요청한 경로 중 context이후의 servlet경로만 추출 
			 */
			String action = request.getServletPath();
			System.out.println("action>>>>>>>>>>>>>>>>>>>>>>>>>"+action);
			
			if(action != null){
				if(action.endsWith("loginform.do")){
					content = "member/login.jsp";
				}else if(action.endsWith("insertMemberForm.do")){
					content = "member/insertMember.jsp";
				}else if(action.endsWith("login.do")){
					login(request, response);
				}else if(action.endsWith("listBoard.do")){
					content = listBoard(request, response);
				}
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			content= "ErrorHandler.jsp";
		}
		if(content != null){
			request.setAttribute("content", content);
		}
		RequestDispatcher send = request.getRequestDispatcher(url);
		send.forward(request, response);
	}
	
	private String listBoard(HttpServletRequest request, HttpServletResponse response){
		//요청정보 추출
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		String pageNo = request.getParameter("pageNo");
		
		PageBean bean = new PageBean(key, word, null, pageNo);
		boardService.searchAll(bean);
		request.setAttribute("list", boardService.searchAll(bean));
		request.setAttribute("bean", bean);
		
		return "board/listBoard.jsp";
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (id != null && memberService.login(id, pw)) {
			memberService.login(id, pw);
			//Exception이 발생안했으므로 true가 리턴된 경우
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
		}
	}

}
