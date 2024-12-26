package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Product;

import java.io.IOException;

import dao.ProductDAO;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id")); 
        ProductDAO productDao = new ProductDAO();

        try {
            Product product = productDao.getProduct(productId);
            request.setAttribute("productId", product.getId());
            request.setAttribute("productName", product.getNom());
            request.setAttribute("productDescription", product.getDescription());
            request.setAttribute("productPrice", product.getPrix());
            request.setAttribute("productStock", product.getStock());
            request.setAttribute("productImage", product.getImage());
            request.getRequestDispatcher("/eshopAdmin/updateProduct.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
	}

	

