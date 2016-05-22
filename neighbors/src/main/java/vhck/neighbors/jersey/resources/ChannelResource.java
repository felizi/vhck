package vhck.neighbors.jersey.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.BuildBO;
import vhck.neighbors.bo.ChannelBO;
import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.entity.ChannelEntity;
import vhck.neighbors.jersey.translator.ChannelTranslator;

@Path("/channel")
public class ChannelResource {

	@Inject private ChannelBO channelBO;
	@Inject private BuildBO buildBO;
	@Inject private ChannelTranslator channelTraslator;
	
	@GET
	@Path("{idBuild}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllChannels(@PathParam("idBuild") String idBuild) {
		BuildEntity buildEntity = buildBO.findById(new Long(idBuild));
		List<ChannelEntity> channels = channelBO.findAll();
		
		return Response.status(Response.Status.OK).entity(new Gson().toJson(
				channelTraslator.convertListChannelEntityToListMaps(channels))).build();
	}
}
