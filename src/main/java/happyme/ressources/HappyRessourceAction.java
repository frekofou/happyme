package happyme.ressources;
import happyme.model.HappymeEmotion;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Path("/emotions/")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HappyRessourceAction {
 
    private JacksonDBCollection<HappymeEmotion, String> macollection;
 
    public HappyRessourceAction(JacksonDBCollection<HappymeEmotion, String> emotions) {
        this.macollection = emotions;
    }

    @POST
    @Timed
    public Response publishNewEmotion(@Valid HappymeEmotion emotion) {
        macollection.insert(emotion);
        return Response.noContent().build();
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
    public HappymeEmotion delete(@PathParam("id") final String id) {
    	DBCursor<HappymeEmotion> dbCursor = macollection.find();
        List<HappymeEmotion> emotions = new ArrayList<>();
        while (dbCursor.hasNext()) {
            HappymeEmotion emotion = dbCursor.next();
            emotions.add(emotion);
        }
        
        HappymeEmotion emotionErased = null;
     // loop past all items in the list and replace the changed one
        for (HappymeEmotion emotion: emotions) {
            if(emotion.getId().contains(id)){
            	//nothing
            	emotionErased = emotion;
                
            }else{
            	
            }
        }
        
        return emotionErased;
    }
   
}