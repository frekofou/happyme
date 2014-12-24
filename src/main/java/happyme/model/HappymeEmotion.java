package happyme.model;



import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


@JsonIgnoreProperties(ignoreUnknown = true)
public class HappymeEmotion {
	// random identifier for database record
    private String id = UUID.randomUUID().toString();
    // the emotion title, it can be a tought, a felling, something the user wanna share
    private String title;
    // the emotion location
    @NotBlank
    private HappymeEmotionLocation location;
    // the emotion type
    @NotBlank
    private HappymeEmotionType feeling;
 
	// publication date for the emotion the format is Java DATE
    @NotBlank
    private final Date publishedOn = new Date();
 
    public HappymeEmotion() {
    }
 
    public HappymeEmotion(String title, String id, Date publishedOn, HappymeEmotionLocation location, HappymeEmotionType feeling) {
        super();
        this.title = title;
        this.id = id;
        this.location = location;
        this.feeling = feeling;
        
    }
 
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
 
   
    public Date getPublishedOn() {
        return publishedOn;
    }
    public HappymeEmotionLocation getLocation() {
 		return location;
 	}
}