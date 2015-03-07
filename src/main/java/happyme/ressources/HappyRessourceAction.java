package happyme.ressources;

import happyme.model.HappymeEmotion;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import com.yammer.metrics.annotation.Timed;

@Path("/emotions")
public class HappyRessourceAction {

	private JacksonDBCollection<HappymeEmotion, String> macollection;

	public HappyRessourceAction(
			JacksonDBCollection<HappymeEmotion, String> emotions) {
		this.macollection = emotions;
	}

	@POST
	@Timed
	public Response publishNewEmotion(@Valid HappymeEmotion emotion) {

		macollection.insert(emotion);
		return Response.noContent().build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	public Response update(@PathParam("id") String id, HappymeEmotion entity) {

		DBCursor<HappymeEmotion> dbCursor = macollection.find();
		List<HappymeEmotion> emotions = new ArrayList<>();
		while (dbCursor.hasNext()) {
			HappymeEmotion emotion = dbCursor.next();
			emotions.add(emotion);
		}

		// loop past all items in the list and return the one
		for (HappymeEmotion emotion : emotions) {
			if (emotion.getId().equals(id)) {
				macollection.update(emotion, entity);
			}
		}
		return Response.noContent().build();
	}

	@GET
	@Path("{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public HappymeEmotion findByID(@PathParam("id") String id) {
		DBCursor<HappymeEmotion> dbCursor = macollection.find();
		List<HappymeEmotion> emotions = new ArrayList<>();
		while (dbCursor.hasNext()) {
			HappymeEmotion emotion = dbCursor.next();
			emotions.add(emotion);
		}

		// loop past all items in the list and return the one
		for (HappymeEmotion emotion : emotions) {
			if (emotion.getId().equals(id)) {
				return emotion;
			}
		}
		return null;

	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public List<HappymeEmotion> index() {
		DBCursor<HappymeEmotion> dbCursor = macollection.find();
		List<HappymeEmotion> emotions = new ArrayList<>();
		while (dbCursor.hasNext()) {
			HappymeEmotion emotion = dbCursor.next();
			emotions.add(emotion);
		}
		return emotions;
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {

		DBCursor<HappymeEmotion> dbCursor = macollection.find();
		List<HappymeEmotion> emotions = new ArrayList<>();
		while (dbCursor.hasNext()) {
			HappymeEmotion emotion = dbCursor.next();
			emotions.add(emotion);
		}

		// loop past all items in the list and replace the changed one
		for (HappymeEmotion emotion : emotions) {
			if (emotion.getId().equals(id)) {
				macollection.remove(emotion);
			}
		}

		return Response.noContent().build();
	}

}