package happyme;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
 
public class HappyService extends Service<HappyConfiguration> {
 
    public static void main(String[] args) throws Exception {
        new HappyService().run(new String[] { "server" });
    }
 
    @Override
    public void initialize(Bootstrap<HappyConfiguration> bootstrap) {
        bootstrap.setName("happyme");
    }
 
    @Override
    public void run(HappyConfiguration configuration, Environment environment) throws Exception {
    		
    	environment.addResource(new IndexResource());
    }
 
}