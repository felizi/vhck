package vhck.neighbors.jersey.resources;

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
	@Produces(MediaType.APPLICATION_JSON)
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
	
//	@Path("{idUsuario}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String buscarPorId(@PathParam("idUsuario") Long id) {
//		UserEntity usuario = userBO.findById(id);
//		String userJson = new Gson().toJson(usuario, UserEntity.class);
//		return userJson;
//	}
}
