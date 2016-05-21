package vhck.neighbors.jersey.resources;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("auth")
public class AuthResource {
	@OPTIONS
	@Path("/login")
	public Response test() {
		return null;
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(String usernamePasswordJson) {
		Map<Object, Object> usernamePasswordMap = new Gson().fromJson(usernamePasswordJson, new TypeToken<HashMap<Object, Object>>() {
		}.getType());
		return Response.status(HttpServletResponse.SC_OK).entity(usernamePasswordMap).build();
	}

	@GET
	@Path("/info/{token}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserByToken(@PathParam("token") Integer token) {
		return Response.ok().entity("ok" + token).build();
	}
}
