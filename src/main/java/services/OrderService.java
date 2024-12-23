package services;

import java.util.List;

import dao.OrderDao;
import dao.UserDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Order;
import metier.User;


@Path("/orders")
public class OrderService {

	private static OrderDao orderDAO = new OrderDao();
	private static UserDao userDAO = new UserDao();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders() {
		List<Order> orders = orderDAO.getOrders();
		if (orders != null) {
			return Response.ok(orders).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("/user/{index}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders(@PathParam("index") int index) {
		User user = userDAO.getUser(index);
		List<Order> orders = orderDAO.getOrdersByUser(user);
		if (orders != null) {
			return Response.ok(orders).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Order order) {
		orderDAO.addOrder(order);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{index}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("index") int index) {
		Order order = orderDAO.getOrderById(index);
		if (order != null) {
			return Response.ok(order).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
