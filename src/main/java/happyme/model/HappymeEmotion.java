package happyme.model;



import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import net.vz.mongodb.jackson.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.maps.GeocodingApiRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HappymeEmotion {
	@ObjectId
	private String _id;
	// the emotion title, it can be a tought, a felling, something the user
	// wanna share
	private String title;
	// the emotion location
	@Nullable
	private GeocodingApiRequest address;
	private Object location;

	// the emotion type
	private HappymeEmotionType feeling;

	// publication date for the emotion the format is Java DATE
	@NotNull
	private final Date publishedOn = new Date();

	public HappymeEmotion() {
	}

	public HappymeEmotion(String title, java.util.Date publishedOn,
			Object location, HappymeEmotionType feeling) {
		super();
	}

	

	public String getTitle() {
		return title;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public Object getLocation() {
		return location;
	}

	public HappymeEmotionType getFeeling() {
		return feeling;
	}

	public void setFeeling(HappymeEmotionType feeling) {
		this.feeling = feeling;
	}

	public GeocodingApiRequest getAddress() {
		return address;
	}

	public void setAddress(GeocodingApiRequest address) {
		this.address = address;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}