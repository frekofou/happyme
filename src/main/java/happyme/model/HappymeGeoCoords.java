package happyme.model;

import javax.persistence.Table;

import com.google.maps.model.GeocodingResult;

@Table(name = "location")
public class HappymeGeoCoords extends GeocodingResult{

	private GeocodingResult results;

	public HappymeGeoCoords(GeocodingResult result) {
		
		this.results = result;
	}
	
	public HappymeGeoCoords() {
		
	
	}





}
