package eshopServlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Cart;
import java.io.IOException;



@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int itemId = Integer.parseInt(request.getParameter("itemId"));

      
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
          
            cart.removeItem(itemId);
            session.setAttribute("cart", cart); 
        }

        response.sendRedirect(request.getContextPath() + "/eshopPublic/myCart.jsp");
		
	}

}
