package vhck.neighbors.jersey.resources;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.EmailAlreadyRegisteredException;
import vhck.neighbors.jersey.interpreter.UserInterpreter;

@Path("user")
public class UserResource {
	
	@Inject private UserInterpreter userInterpreter;;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String users() {
		return "Hello World !! - Jersey 2";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarUsuario(String contentRequest) {
		UserEntity user = null;
		try {
			user = userInterpreter.createUser(contentRequest);
		} catch (EmailAlreadyRegisteredException e) {
			System.out.println("EmailAlreadyRegisteredException");
			return null;
		}

		return Response.created(URI.create("/user/" + user.getId())).build();
	}
}
