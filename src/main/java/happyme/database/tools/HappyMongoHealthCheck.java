package happyme.database.tools;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

public class HappyMongoHealthCheck extends HealthCheck{
	
	 private Mongo mongo;
	 
	    public HappyMongoHealthCheck(Mongo mongo) {
	        super("MongoDBHealthCheck");
	        this.mongo = mongo;
	    }
	 
	    @Override
	    protected Result  check() throws Exception {
	        mongo.getDatabaseNames();
	        return Result.healthy();
	    }

}
