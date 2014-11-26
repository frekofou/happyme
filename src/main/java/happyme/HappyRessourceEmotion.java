package happyme;

import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
 
import com.yammer.metrics.annotation.Timed;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Path("/emotions")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HappyRessourceEmotion {
 
    private JacksonDBCollection<HappymeEmotion, String> collection;
 
    public HappyRessourceEmotion(JacksonDBCollection<HappymeEmotion, String> emotions) {
        this.collection = emotions;
    }
 
    @POST
    @Timed
    public Response publishNewBlog(@Valid HappymeEmotion emotion) {
        collection.insert(emotion);
        return Response.noContent().build();
    }
}