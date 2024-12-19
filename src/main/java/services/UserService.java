package services;

import dao.UserDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.User;

@Path("/users")
public class UserService {

	private static UserDao userDAO = new UserDao();

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUset(User user) {
		userDAO.addUser(user);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{index}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("index") int index) {
		User user = userDAO.getUser(index);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
