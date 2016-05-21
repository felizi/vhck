package vhck.neighbors.resources;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import vhck.neighbors.bo.UserBO;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.EmailAlreadyRegisteredException;

@Path("user")
public class UserResource {
	
	@Inject private UserBO userBO;
	
	@GET
	@Path("users")
	@Produces("application/xml")
	public String users() {
//		MessageEntity msg = new MessageEntity();
//		msg.setSender(new EventEntity());
//		msg.setRecipient(new UserEntity());
		return "Hello World !! - Jersey 2";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarUsuario(String usuarioJson) {
		UserEntity user = new Gson().fromJson(usuarioJson, UserEntity.class);
		
		try {
			userBO.include(user);
		} catch (EmailAlreadyRegisteredException e) {
			// TRATAR!
		}
		
		
		URI uri = URI.create("/user/" + user.getId());
		return Response.created(uri).build();
	}
	
	
	/*@GET
	@Path("user")
	@Produces("application/xml")
	public String login() {
		return "Hello World !! - Jersey 2";
	}*/
}
