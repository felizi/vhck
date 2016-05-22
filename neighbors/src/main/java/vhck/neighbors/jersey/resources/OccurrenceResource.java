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

@Path("occurrence")
public class OccurrenceResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			map.put("id", "1");
			map.put("title", "Blue towel at the swimming pool");
			map.put("flames", "30");
			map.put("type", "LOST_AND_FOUND");
			map.put("date", "1463883950710");
			map.put("dateUpdate", "1463883950710");
			map.put("views", "132");
			map.put("flamed", "false");
			map.put("comments", "Apsodapsdo pasod pasod pao poadp oa");
			list.add(map);

			map = new HashMap<>();
			map.put("id", "2");
			map.put("title", "Elevator");
			map.put("flames", "10");
			map.put("type", "MAINTENANCE");
			map.put("date", "1463883950710");
			map.put("dateUpdate", "1463883950710");
			map.put("views", "22");
			map.put("flamed", "false");
			map.put("comments", "Blalbalbla lbalblab");
			list.add(map);

			return Response.status(Response.Status.OK).entity(new Gson().toJson(list)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}

	}
	/*
	 * @Inject private UserBO userBO;
	 * 
	 * @Inject private OccurrenceBO occurrenceBO;
	 * 
	 * @Inject private OccurrenceTranslator occurrenceTranslator;
	 */
	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response
	 * cadastrarUsuario(String contentRequest) { UserEntity user =
	 * userBO.findById(1L); OccurrenceEntity occurrenceEntity =
	 * occurrenceTranslator.convertJson(contentRequest, user); try {
	 * occurrenceBO.include(occurrenceEntity); } catch (Exception e) { return
	 * null; }
	 * 
	 * return Response.created(URI.create("/occurrence/" +
	 * occurrenceEntity.getId())).build(); }
	 */
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response findAll() { try {
	 * List<OccurrenceEntity> occurrences = occurrenceBO.findAll();
	 * 
	 * BuildEntity buildEntity = buildBO.findById(new Long(idBuild));
	 * List<ChannelEntity> channels = channelBO.findAll();
	 * 
	 * return Response.status(Response.Status.OK).entity(new Gson().toJson(
	 * channelTraslator.convertListChannelEntityToListMaps(channels))).build();
	 * 
	 * 
	 * return Response.status(Response.Status.OK).entity(new
	 * Gson().toJson(user.toMap())).build(); } catch (Exception e) { return
	 * Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(
	 * MediaType.TEXT_PLAIN).build(); } }
	 */
}
