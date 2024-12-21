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

import java.io.IOException;

/**
 * Servlet Filter implementation class CheckOutFilter
 */
@WebFilter("/eshopPublic/recapOrder.jsp")
public class CheckOutFilter extends HttpFilter implements Filter {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

    
        if (session == null || session.getAttribute("user") == null) {
            
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/eshopPublic/login.jsp");
            session.setAttribute("errorMessageCheck", "Veuillez d'abord vous connecter !");
            return;
        }
        
		chain.doFilter(request, response);
	}

	

}
