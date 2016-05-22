package vhck.neighbors.jersey.resources;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response cadastrarUsuario(String contentRequest) {
		UserEntity userEntity = userTranslator.createUser(contentRequest);
		try {
			userBO.include(userEntity);
		} catch (EmailAlreadyRegisteredException e) {
			System.out.println("EmailAlreadyRegisteredException");
			return null;
		}

		return Response.created(URI.create("/user/" + userEntity.getId())).build();
	}
}
