package br.edu.opet.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPtters = "/pages/*", servletNames="(Faces Servlet)")
public class LoginFilter extends AbstractFilter implements Filter{

	//Construtor
	public LoginFilter() {}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = getSession();
		Usuario user = (Usuario) session.getAttribute("user");
		if(session.isNew() || user != null) {
			doLogin(request, response, req);
		}else {
			chain.doFilter(request, response);
		}		
	}

	public void destroy() {
	}


	
	

}
