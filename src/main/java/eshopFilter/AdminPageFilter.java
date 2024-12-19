package eshopFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.User;

import java.io.IOException;

/**
 * Servlet Filter implementation class AdminPageFilter
 */

@WebFilter("/*")
public class AdminPageFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		String uri = httpRequest.getRequestURI();
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (uri.contains("/eshopAdmin/") && (user == null || !"ADMIN".equals(user.getRole()))) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

}
