package happyme.database.tools;

import javax.persistence.Entity;
import javax.persistence.Table;

import happyme.server.HappyConfiguration;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class HappyGeocoding {
	
	HappyConfiguration configuration = new HappyConfiguration();
	private GeoApiContext context = configuration.geoApiContext;

	public HappyGeocoding() {
		// TODO Auto-generated constructor stub
		
	}
	
	public GeocodingApiRequest HappyGeocodingByLatLng(final LatLng location){	
		
	
				
		return GeocodingApi.reverseGeocode(context, location);
		
		
	}

}
