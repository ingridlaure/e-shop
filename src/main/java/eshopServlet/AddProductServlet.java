package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import metier.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDAO;

/**
 * Servlet implementation class AddProductServlet
 */
@MultipartConfig
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dans le dopost de l'ajout d'un produit");

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		// gestion du fichier image
		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();
		System.out.println("nom du fichier selectionner " + imageFileName);
		String uploadPath = "C:/Users/32466/eclipse-workspace/e-shop/src/main/webapp/images/" + imageFileName;
		System.out.println("fichier televerser " + uploadPath);
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// on cree l'objet Produit
		Product product = new Product(name, description, prix, stock, imageFileName);
		try {

			JSONObject productJson = new JSONObject(product);
			HttpClientHelper.send("http://localhost:8081/e-shop/api/products/create", productJson.toString());
			
			ProductDAO productDAO=new ProductDAO();
			JSONArray productArray = new JSONArray(productDAO.getProducts());
			getServletContext().setAttribute("products", productArray);
			response.sendRedirect(request.getContextPath() + "/eshopAdmin/productsManager.jsp");

		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}

	}

}
