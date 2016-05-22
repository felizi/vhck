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

@Path("event")
public class EventResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			List<Map<String, Object>> list = new ArrayList<>();

			Map<String, Object> map = new HashMap<>();
			map.put("id", "1");
			map.put("title", "Summer soccer match against Bryan Killigan");
			map.put("flames", "42");
			map.put("type", "FOOTBALL");
			map.put("date", "1463883950710");
			map.put("dateUpdate", "3");
			map.put("views", "135");
			map.put("flamed", "true");

			List<Map<String, Object>> comments = new ArrayList<>();
			
			Map<String, Object> user = new HashMap<>();
			user.put("name", "Mike Moll");
			
			Map<String, Object> comment = new HashMap<>();
			comment.put("user", user);
			comment.put("commentAt", "1");
			comment.put("comment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 1");
			comments.add(comment);

			user = new HashMap<>();
			user.put("name", "Daniel Felizi");

			/*comment = new HashMap<>();
			comment.put("user", user);
			comment.put("commentAt", "2");
			comment.put("comment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 2");
			comments.add(comment);*/

			map.put("comments", comments);
			list.add(map);

			map = new HashMap<>();
			map.put("id", "2");
			map.put("title", "Summer BBQ");
			map.put("flames", "25");
			map.put("type", "BARBECUE");
			map.put("date", "1463883950710");
			map.put("dateUpdate", "2");
			map.put("views", "422");
			map.put("flamed", "true");
			
			comments = new ArrayList<>();

			user = new HashMap<>();
			user.put("name", "Augusto Marques");
			
			comment = new HashMap<>();
			comment.put("user", user);
			comment.put("commentAt", "3");
			comment.put("comment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 3");
			comments.add(comment);

			user = new HashMap<>();
			user.put("name", "Helder Traci");

			comment = new HashMap<>();
			comment.put("user", user);
			comment.put("commentAt", "4");
			comment.put("comment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 4");
			comments.add(comment);

			user = new HashMap<>();
			user.put("name", "Samuel Kitazume");

			comment = new HashMap<>();
			comment.put("user", user);
			comment.put("commentAt", "5");
			comment.put("comment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5");
			comments.add(comment);

			map.put("comments", comments);
			list.add(map);

			return Response.status(Response.Status.OK).entity(new Gson().toJson(list)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Erro").type(MediaType.TEXT_PLAIN).build();
		}
	}
}
