package vhck.neighbors.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("info")
public class InfoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response info() {
		return Response.status(Response.Status.OK).entity(new Gson().toJson("1.0")).build();
	}
}
