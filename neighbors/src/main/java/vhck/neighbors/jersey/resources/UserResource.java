package vhck.neighbors.jersey.resources;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.UserBO;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.EmailAlreadyRegisteredException;
import vhck.neighbors.jersey.translator.UserTranslator;

@Path("user")
public class UserResource {

	@Inject
	private UserTranslator userTranslator;
	@Inject
	private UserBO userBO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(String contentRequest) {
		UserEntity userEntity = userTranslator.createUser(contentRequest);
		try {
			userBO.include(userEntity);
		} catch (EmailAlreadyRegisteredException e) {
			System.out.println("EmailAlreadyRegisteredException");
			return null;
		}

		return Response.created(URI.create("/user/" + userEntity.getId())).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		try {
			UserEntity user = userBO.findById(id);
			return Response.status(Response.Status.OK).entity(new Gson().toJson(user.toMap())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}

	}
}
