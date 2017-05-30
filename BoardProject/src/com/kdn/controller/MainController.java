package com.kdn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdn.model.biz.BoardService;
import com.kdn.model.biz.BoardServiceImpl;
import com.kdn.model.biz.MemberService;
import com.kdn.model.biz.MemberServiceImpl;

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


}
