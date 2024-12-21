package eshopServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.CartItem;
import metier.Product;
import metier.User;

import java.io.IOException;

import dao.CartDao;

/**
 * Servlet implementation class AddToDatabaseCartServlet
 */
@WebServlet("/AddToDatabaseCartServlet")
public class AddToDatabaseCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//todo afficher les articles du panier de la base de données dans la page my cart 
		
		CartDao cartDAO = new CartDao();
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		double productPrice=Double.parseDouble(request.getParameter("productPrice"));
		int quantity=Integer.parseInt(request.getParameter("productQuantity"));
		String productImage=request.getParameter("productImage");
		Product product=new Product(productId,productName,productPrice,productImage);
		CartItem newCartItem=new CartItem(product,quantity,productPrice);
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		cartDAO.addItem(newCartItem, user);
	}

	
}
