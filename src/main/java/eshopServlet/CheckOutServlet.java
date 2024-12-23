package eshopServlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Cart;
import metier.Order;
import metier.User;

import java.io.IOException;

import org.json.JSONObject;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		
		Order order=new Order(user,cart.getTotalPrice(),cart.getItems(),request.getParameter("deliveryAddress"));
		
		try {

			JSONObject orderJson = new JSONObject(order);
			HttpClientHelper.send("http://localhost:8081/e-shop/api/orders/create", orderJson.toString());
			response.sendRedirect(request.getContextPath() + "/eshopPublic/products.jsp");
			session.removeAttribute("cart");

		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
		
		
	}

}
