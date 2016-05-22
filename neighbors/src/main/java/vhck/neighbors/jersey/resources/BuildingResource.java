package vhck.neighbors.jersey.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.BuildBO;
import vhck.neighbors.jersey.translator.BuildingTranslator;

@Path("building")
public class BuildingResource {

	@Inject
	private BuildBO buildingBO;
	@Inject
	private BuildingTranslator buildingTranslator;

	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response insert(String
	 * contentRequest) { // buildBO.include(contentRequest); UserEntity
	 * userEntity = buildingTranslator.create(contentRequest); try {
	 * userBO.include(userEntity); } catch (EmailAlreadyRegisteredException e) {
	 * System.out.println("EmailAlreadyRegisteredException"); return null; }
	 * 
	 * return Response.created(URI.create("/user/" +
	 * userEntity.getId())).build(); }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			// BuildingEntity user = buildingBO.findAll();
			List<Map<String, Object>> list = new ArrayList<>();
			for (int i = 1; i <= 5; i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", i);
				map.put("name", "Building " + i);
				list.add(map);
			}
			return Response.status(Response.Status.OK).entity(new Gson().toJson(list)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}

	}
}
