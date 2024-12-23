package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.User;

import java.io.IOException;

import org.json.JSONArray;


@WebServlet("/getOrdersByUserServlet")
public class getOrdersByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		int id=0;
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		
		if(user!=null) {
			id=user.getId();
		}
		try {
			
			String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/orders/user/"+id);
			System.out.println(jsonResponse);
			// Transformer le string avec objet Json
			JSONArray jsonArray = new JSONArray(jsonResponse);
			System.out.println(jsonArray);
			// stocker les données dans la requete
			request.setAttribute("ordersUser", jsonArray);
			
			// forward à la jsp
			request.getRequestDispatcher("/eshopPublic/myOrders.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}
	}

	

