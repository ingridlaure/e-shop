package services;

import java.util.List;

import dao.ProductDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Product;

@Path("/products")
public class ProductService {

	private static ProductDAO productDAO = new ProductDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		productDAO.addProduct(product);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{index}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getProduct(@PathParam("index") int index) {
		Product product = productDAO.getProduct(index);
		if (product != null) {
			return Response.ok(product).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/update/{index}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam("index") int index, Product product) {
		productDAO.updateProduct(index, product);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{index}")
	public Response deleteProduct(@PathParam("index") int index) {
		productDAO.deleteProduct(index);
		return Response.noContent().build();
	}

}
