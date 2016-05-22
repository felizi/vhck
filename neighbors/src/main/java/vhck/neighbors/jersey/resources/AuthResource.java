package vhck.neighbors.jersey.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vhck.neighbors.exception.PasswordInvalidException;
import vhck.neighbors.exception.UserNotFoundException;
import vhck.neighbors.jersey.interpreter.UserInterpreter;

@Path("auth")
public class AuthResource {
	
	@Inject private UserInterpreter userInterpreter;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response autenticate(String contentRequest) {
		
		try {
			userInterpreter.authenticate(contentRequest);
		} catch (PasswordInvalidException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Password Invalid").type(MediaType.TEXT_PLAIN).build();
		} catch (UserNotFoundException e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("User not Found").type(MediaType.TEXT_PLAIN).build();
		}
		
		return Response.ok().build();
	}

	@GET
	@Path("/info/{token}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserByToken(@PathParam("token") Integer token) {
		return Response.ok().entity("ok" + token).build();
	}
	
//	@XmlRootElement
//	public class DataAutentication {
//	    @XmlElement public String email;
//	    @XmlElement public String password;
//	}
}
