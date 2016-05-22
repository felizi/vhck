package vhck.neighbors.jersey.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("reputation")
public class ReputationResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById() {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			map.put("type", "LOST_AND_FOUND");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("interactions", 230);
			attributes.put("pokes", 15);
			attributes.put("pontuation", 345);
			map.put("attributes", attributes);
			list.add(map);

			map = new HashMap<>();
			map.put("type", "BARBECUE");
			attributes = new HashMap<>();
			attributes.put("interactions", 180);
			attributes.put("pokes", 22);
			attributes.put("pontuation", 330);
			map.put("attributes", attributes);
			list.add(map);

			return Response.status(Response.Status.OK).entity(new Gson().toJson(list)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}

	}
}
