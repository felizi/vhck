package vhck.neighbors.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("user")
public class UserResource {
	@GET
	public String getMsg() {
		return "Hello World !! - Jersey 2";
	}
}
