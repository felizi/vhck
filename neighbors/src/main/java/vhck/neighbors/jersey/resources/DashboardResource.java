package vhck.neighbors.jersey.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import vhck.neighbors.bo.EventBO;
import vhck.neighbors.bo.OccurrenceBO;
import vhck.neighbors.dto.DashboardDTO;
import vhck.neighbors.entity.EventEntity;
import vhck.neighbors.entity.OccurrenceEntity;

@Path("dashboard")
public class DashboardResource {

	@Inject
	private EventBO eventBO;
	@Inject
	private OccurrenceBO occurrenceBO;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loadDashboard(String contentRequest) {
		try {
			List<EventEntity> events = eventBO.findAll();
			List<OccurrenceEntity> occurrences = occurrenceBO.findAll();

			return Response.ok(new DashboardDTO(events, occurrences)).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
}
