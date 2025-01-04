package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONObject;


@WebServlet("/GetProductDetailServlet")
public class GetProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("idProduct");
		System.out.println(id);
		
		try {
			String jsonResponse=HttpClientHelper.fetch("http://localhost:8081/e-shop/api/products/"+id);
			System.out.println("Detail recupéré: "+jsonResponse);
			JSONObject jsonObject=new JSONObject(jsonResponse);
			request.setAttribute("productDetails", jsonObject);
			request.getRequestDispatcher("/eshopPublic/detailProduct.jsp").forward(request, response);
		}catch(Exception e) {
		response.getWriter().write("Erreur : "+e.getMessage());	
		}
	}
	



}
