package happyme;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

public class HappyMongoManaged implements Managed {

	
	private Mongo mongo;
	 
    public HappyMongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }
 
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
