package happyme.model;
import happyme.model.HappymeEmotionType.EmotionType;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;



@Entity
@Table(name = "location")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public  class HappymeEmotionLocation {

	public HappymeEmotionLocation(GeocodingResult geo) {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
