package services;

import java.util.List;

import dao.DeliveryDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Delivery;

@Path("/deliveries")
public class DeliveryService {

	private static DeliveryDao deliveryDAO = new DeliveryDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public List<Delivery> getDelivery() {
		return deliveryDAO.getDeliveries();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDelivery(Delivery delivery) {
		deliveryDAO.addLivraison(delivery);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Path("/update/{index}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDeliery(@PathParam("index") int index, String status) {
		deliveryDAO.updateLivraisonStatus(index, status);
		return Response.noContent().build();
	}
}
