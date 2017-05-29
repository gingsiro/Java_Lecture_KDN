package chapter04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paramtest4.do")
public class ParamServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); //필터 적용하여 필요 없음
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String address = request.getParameter("address");
//		String email = request.getParameter("email");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
		InputStream is = request.getInputStream();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while( (line=br.readLine()) != null ){
				System.out.println(line);
			}
			System.out.println();
		} catch (Exception e) {
		} finally {
			if(is!=null){ try{ is.close(); } catch(Exception e){ } }
			if(br!=null){ try{ br.close(); } catch(Exception e){ } }
		}
	}
}
