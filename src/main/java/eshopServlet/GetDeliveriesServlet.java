package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONArray;


@WebServlet("/GetDeliveriesServlet")
public class GetDeliveriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		 String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/deliveries");
		 //on récup§re toutes les livraisons
			System.out.println(jsonResponse);
			// Transformer le string avec objet Json
			JSONArray jsonArray = new JSONArray(jsonResponse);
			System.out.println(" json array des livraisons"+jsonArray);
			getServletContext().setAttribute("deliveries", jsonArray);
			request.getRequestDispatcher("/eshopAdmin/deliveriesManager.jsp").forward(request, response);
		}catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	
	}

	

}
