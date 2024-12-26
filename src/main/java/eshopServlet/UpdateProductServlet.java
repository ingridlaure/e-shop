package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Product;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérer les paramètres du formulaire
		System.out.println("valeur de int:" + request.getParameter("id"));
		int productId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		// Conserver l'image existante (aucune gestion de fichier ici)
		String existingImage = request.getParameter("existingImage");

		// Créer un objet Product avec les nouvelles valeurs
		Product product = new Product(productId, name, description, price, stock, existingImage);

		// Envoyer l'objet au serveur distant via l'API REST
		try {
			JSONObject productJson = new JSONObject(product);
			HttpClientHelper.put("http://localhost:8081/e-shop/api/products/update/"+productId, productJson.toString());
			JSONArray productArray = (JSONArray) getServletContext().getAttribute("products");
			if (productArray != null) {
				for (int i = 0; i < productArray.length(); i++) {
					JSONObject currentProduct = productArray.getJSONObject(i);
					if (currentProduct.getInt("id") == productId) {
						// Mettre à jour les détails du produit dans le tableau
						currentProduct.put("name", name);
						currentProduct.put("description", description);
						currentProduct.put("price", price);
						currentProduct.put("stock", stock);
						currentProduct.put("image", existingImage);
						break;
					}
				}
				getServletContext().setAttribute("products", productArray);
			}
			response.sendRedirect(request.getContextPath() + "/eshopAdmin/productsManager.jsp");
		} catch (Exception e) {
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}
}
