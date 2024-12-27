package eshopServlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Delivery;
import metier.Order;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.DeliveryDao;
import dao.OrderDao;

@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dans la doPOst");
		String action = request.getParameter("action");

		try {
			if ("expedier".equals(action)) {
				int commandeId = Integer.parseInt(request.getParameter("commandeId"));
				System.out.println("valeur de id : " + commandeId);
				OrderDao orderDAO = new OrderDao();
				Order order = orderDAO.getOrderById(commandeId);
				Delivery delivery = new Delivery(order);
				JSONObject deliveryJson = new JSONObject(delivery);
				HttpClientHelper.send("http://localhost:8081/e-shop/api/deliveries/create", deliveryJson.toString());
				orderDAO.updateOrderStatus(commandeId, "EXPEDIEE");
				String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/orders");
				System.out.println(jsonResponse);

				JSONArray jsonArray = new JSONArray(jsonResponse);
				System.out.println(jsonArray);
				getServletContext().setAttribute("orders", jsonArray);
				
				
				

			} else if ("livrer".equals(action)) {
				DeliveryDao livraisonDao = new DeliveryDao();
				int commandeId = Integer.parseInt(request.getParameter("commandeId"));
				int livraisonId = Integer.parseInt(request.getParameter("livraisonId"));
				System.out.println("clivraison : " + commandeId);
				OrderDao orderDAO = new OrderDao();

				boolean success = livraisonDao.updateLivraisonStatus(livraisonId, "LIVREE");
				if (success) {
					orderDAO.updateOrderStatus(commandeId, "LIVREE");
					String jsonResponse = HttpClientHelper.fetch("http://localhost:8081/e-shop/api/orders");
					System.out.println(jsonResponse);

					JSONArray jsonArray = new JSONArray(jsonResponse);
					System.out.println(jsonArray);
					getServletContext().setAttribute("orders", jsonArray);

				}
			}
			/*request.getRequestDispatcher("/eshopServlet/GetDeliveriesServlet");*/
		/*response.sendRedirect(request.getContextPath() + "/eshopAdmin/deliveriesManager.jsp");*/
			response.sendRedirect(request.getContextPath() + "/GetDeliveriesServlet");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("Erreur : " + e.getMessage());
		}
	}

}
