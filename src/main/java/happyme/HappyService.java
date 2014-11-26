package happyme;

import net.vz.mongodb.jackson.JacksonDBCollection;

import com.mongodb.DB;
import com.mongodb.Mongo;
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
    	// un commentaire	
    	Mongo mongo = new Mongo(configuration.mongohost, configuration.mongoport);
        HappyMongoManaged mongoManaged = new HappyMongoManaged(mongo);
        environment.manage(mongoManaged);
 
        environment.addHealthCheck(new HappyMongoHealthCheck(mongo));
 
        environment.addResource(new IndexResource());
        DB db = mongo.getDB(configuration.mongodb);
        JacksonDBCollection<HappymeEmotion, String> emotions = JacksonDBCollection.wrap(db.getCollection("emotions"), HappymeEmotion.class, String.class);
 
        environment.addResource(new IndexResource());
 
        environment.addResource(new HappyRessourceEmotion(emotions));
    
   
    }
 
}