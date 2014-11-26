package happyme;

import com.yammer.dropwizard.config.Configuration;

import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
 
public class HappyConfiguration extends Configuration{
	
	@JsonProperty
    @NotEmpty
    public String mongohost = "localhost";
 
    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoport = 27017;
 
    @JsonProperty
    @NotEmpty
    public String mongodb = "test";
 
}