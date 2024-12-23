package services;

import dao.CartDao;
import dao.UserDao;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Cart;

import metier.User;

@Path("/carts")
public class CartService {

	private static CartDao cartDAO = new CartDao();
	private static UserDao userDAO=new UserDao();

	@GET
	@Path("/user/{index}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("index") int index) {
		User user = userDAO.getUser(index);
		Cart cart = cartDAO.getCart(user);
		if (cart != null) {
			return Response.ok(cart).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
