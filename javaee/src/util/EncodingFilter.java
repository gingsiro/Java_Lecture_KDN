package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.do")
public class EncodingFilter implements Filter {
	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Encoding filter 수행 중...");
		/*
		 * doFilter(request, response)
		 * : 지정된 경로에 연결된 다른 Filter나 Servlet으로 이동하는 기능
		 */
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException { }

}
