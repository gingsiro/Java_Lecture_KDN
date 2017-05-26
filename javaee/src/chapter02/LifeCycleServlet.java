package chapter02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle.do")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int count;
    public LifeCycleServlet() {
        super();
    }
    public void init() throws ServletException{
    	System.out.println("init() called.... ");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() called....");
		System.out.println(++count);
	}

	public void destroy(){
		System.out.println("destroy() called....");
		try{Thread.sleep(5000);}catch(Exception e){}
	}
}
