package services;

import dao.OrderDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Order;


@Path("/orders")
public class OrderService {

	private static OrderDao orderDAO = new OrderDao();
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Order order) {
		orderDAO.addOrder(order);
		return Response.status(Response.Status.CREATED).build();
	}
}
