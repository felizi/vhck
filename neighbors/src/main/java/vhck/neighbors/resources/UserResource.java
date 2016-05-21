package vhck.neighbors.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class UserResource {
	@GET
	@Path("users")
	@Produces("application/xml")
	public String users() {
		return "Hello World !! - Jersey 2";
	}
	
	/*@GET
	@Path("user")
	@Produces("application/xml")
	public String login() {
		return "Hello World !! - Jersey 2";
	}*/
}
