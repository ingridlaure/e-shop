package eshopServlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONArray;

@WebServlet("/GetProductsServlet")
public class GetProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			// Appel à l'API  => recevoir une reponse
			String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/products");
			System.out.println(jsonResponse);
			// Transformer le string avec objet Json
			JSONArray jsonArray = new JSONArray(jsonResponse);
			System.out.println(jsonArray);
			// stocker les données dans la requete
			//request.setAttribute("products", jsonArray);
			getServletContext().setAttribute("products", jsonArray);

			// forward à la jsp
			//request.getRequestDispatcher("/eshop/productManager.jsp").forward(request, response);
			
			//récupérer les commandes 
			 jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/orders");
			System.out.println(jsonResponse);
			// Transformer le string avec objet Json
			jsonArray = new JSONArray(jsonResponse);
			System.out.println(jsonArray);
			getServletContext().setAttribute("orders", jsonArray);
			
		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}

}
