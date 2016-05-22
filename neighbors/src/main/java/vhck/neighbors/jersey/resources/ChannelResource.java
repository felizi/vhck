package vhck.neighbors.jersey.resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import vhck.neighbors.bo.ChannelBO;

@Path("/channel")
public class ChannelResource {

	@Inject private ChannelBO channelBO;
}
