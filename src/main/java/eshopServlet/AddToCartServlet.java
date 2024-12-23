package eshopServlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Cart;
import metier.CartItem;
import metier.Product;


import java.io.IOException;


@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		double productPrice=Double.parseDouble(request.getParameter("productPrice"));
		int quantity=Integer.parseInt(request.getParameter("productQuantity"));
		String productImage=request.getParameter("productImage");
		Product product=new Product(productId,productName,productPrice,productImage);
		CartItem newCartItem=new CartItem(product,quantity,productPrice);
		
		HttpSession session=request.getSession();
	
		Cart cart= (Cart) session.getAttribute("cart");
		if (cart ==null) {
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addItem(newCartItem);
		response.sendRedirect(request.getContextPath() + "/eshopPublic/myCart.jsp");
		
		
	}

}
