package vhck.neighbors.jersey.resources;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.OccurrenceBO;
import vhck.neighbors.bo.UserBO;
import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.entity.ChannelEntity;
import vhck.neighbors.entity.OccurrenceEntity;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.jersey.translator.OccurrenceTranslator;

@Path("occurrence")
public class OccurrenceResource {

	@Inject
	private UserBO userBO;
	@Inject
	private OccurrenceBO occurrenceBO;
	@Inject
	private OccurrenceTranslator occurrenceTranslator;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarUsuario(String contentRequest) {
		UserEntity user = userBO.findById(1L);
		OccurrenceEntity occurrenceEntity = occurrenceTranslator.convertJson(contentRequest, user);
		try {
			occurrenceBO.include(occurrenceEntity);
		} catch (Exception e) {
			return null;
		}

		return Response.created(URI.create("/occurrence/" + occurrenceEntity.getId())).build();
	}
/*	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			List<OccurrenceEntity> occurrences = occurrenceBO.findAll();
			
			BuildEntity buildEntity = buildBO.findById(new Long(idBuild));
			List<ChannelEntity> channels = channelBO.findAll();
			
			return Response.status(Response.Status.OK).entity(new Gson().toJson(
					channelTraslator.convertListChannelEntityToListMaps(channels))).build();
			
			
			return Response.status(Response.Status.OK).entity(new Gson().toJson(user.toMap())).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}
	}*/
}
