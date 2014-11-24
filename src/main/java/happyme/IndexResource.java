package happyme;

import java.util.Arrays;
import java.util.List;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.yammer.metrics.annotation.Timed;
 
@Path("/")
public class IndexResource {
 
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<HappymeEmotion> index() {
        return Arrays.asList(new HappymeEmotion("Day 12: OpenCV--Face Detection for Java Developers",
                "https://www.openshift.com/blogs/day-12-opencv-face-detection-for-java-developers"));
    }
}
