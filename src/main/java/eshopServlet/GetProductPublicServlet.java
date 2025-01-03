package eshopServlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONArray;

@WebServlet("/GetProductPublicServlet")
public class GetProductPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			// Appel à l'API Film_URL => recevoir une reponse
			String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/products");
			System.out.println(jsonResponse);
			// Transformer le string avec objet Json
			JSONArray jsonArray = new JSONArray(jsonResponse);
			System.out.println(jsonArray);
			// stocker les données dans la requete
			request.setAttribute("products", jsonArray);
		
			getServletContext().setAttribute("products", jsonArray);
			
			// recupération des commandes
			 jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/orders");
			 
			 //on récup§re toutes les commandes 
				System.out.println(jsonResponse);
				// Transformer le string avec objet Json
				jsonArray = new JSONArray(jsonResponse);
				System.out.println(jsonArray);
				getServletContext().setAttribute("orders", jsonArray);
			// forward à la jsp
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}

}
