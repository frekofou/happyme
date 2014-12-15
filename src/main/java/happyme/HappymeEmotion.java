package happyme;



import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


@JsonIgnoreProperties(ignoreUnknown = true)
public class HappymeEmotion {

    private String id = UUID.randomUUID().toString();
 
    @NotBlank
    private String title;
 
    @URL
    @NotBlank
    private String url;
 
    private final Date publishedOn = new Date();
 
    public HappymeEmotion() {
    }
 
    public HappymeEmotion(String title, String url, String id) {
        super();
        this.title = title;
        this.url = url;
        this.id = id;
    }
 
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
 
    public String getUrl() {
        return url;
    }
 
    public Date getPublishedOn() {
        return publishedOn;
    }
}