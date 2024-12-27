package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDAO;


@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("id"));

		try {
			HttpClientHelper.sendDelete("http://localhost:8081/e-shop/api/products/delete/" + productId);

			ProductDAO productDAO=new ProductDAO();
			JSONArray productArray = new JSONArray(productDAO.getProducts());
			getServletContext().setAttribute("products", productArray);

			response.sendRedirect(request.getContextPath() + "/eshopAdmin/productsManager.jsp");

		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}

}
