package vhck.neighbors.jersey.resources;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vhck.neighbors.bo.OccurrenceBO;
import vhck.neighbors.bo.UserBO;
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
}
