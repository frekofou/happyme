package happyme;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import com.yammer.metrics.annotation.Timed;

@Path("/")
public class IndexResource {

    private JacksonDBCollection<HappymeEmotion, String> macollection;

    public IndexResource(JacksonDBCollection<HappymeEmotion, String> emotions) {
        this.macollection = emotions;
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
}
