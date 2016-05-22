package vhck.neighbors.jersey.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.AuthBO;
import vhck.neighbors.dto.LoginPasswordDTO;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.PasswordInvalidException;
import vhck.neighbors.exception.UserNotFoundException;
import vhck.neighbors.jersey.translator.UserTranslator;

@Path("auth")
public class AuthResource {

	@Inject
	private UserTranslator userTranslator;
	@Inject
	private AuthBO authBO;

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response autenticate(String contentRequest) {
		LoginPasswordDTO loginPass = userTranslator.convertJsonAuth(contentRequest);

		try {
			UserEntity user = authBO.authenticate(loginPass.getLogin(), loginPass.getPassword());

			return Response.status(Response.Status.OK).entity(new Gson().toJson(user.toMap())).build();
		} catch (PasswordInvalidException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Password invalid").type(MediaType.TEXT_PLAIN).build();
		} catch (UserNotFoundException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("User not found").type(MediaType.TEXT_PLAIN).build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Illegal argument").type(MediaType.TEXT_PLAIN).build();
		} catch (NullPointerException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Null pointer").type(MediaType.TEXT_PLAIN).build();
		}

	}
}
