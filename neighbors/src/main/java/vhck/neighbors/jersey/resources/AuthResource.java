package vhck.neighbors.jersey.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vhck.neighbors.bo.AuthBO;
import vhck.neighbors.dto.LoginPasswordDTO;
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
			authBO.authenticate(loginPass.getLogin(), loginPass.getPassword());
		} catch (PasswordInvalidException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Password Invalid").type(MediaType.TEXT_PLAIN).build();
		} catch (UserNotFoundException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("User not Found").type(MediaType.TEXT_PLAIN).build();
		}

		return Response.ok().build();
	}
}
