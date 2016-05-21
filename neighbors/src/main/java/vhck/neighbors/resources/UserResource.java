package vhck.neighbors.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.entity.group.EventEntity;
import vhck.neighbors.entity.message.MessageEntity;

public class UserResource {
	@GET
	@Path("users")
	@Produces("application/xml")
	public String users() {
		MessageEntity msg = new MessageEntity();
		msg.setSender(new EventEntity());
		msg.setRecipient(new UserEntity());
		return "Hello World !! - Jersey 2";
	}
	
	/*@GET
	@Path("user")
	@Produces("application/xml")
	public String login() {
		return "Hello World !! - Jersey 2";
	}*/
}
