package happyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "feeling")
public class HappymeEmotionType {

	// @Column(name = "feeling", nullable = true, updatable = true)
	// @Enumerated(EnumType.STRING)
	private EmotionType type;
 
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public enum EmotionType {
		// possible emotions
		ANGRY(5, "ANGRY"), LOVE(15, "LOVE"), HAPPY(10, "HAPPY"), SAD(7, "SAD");
		// this how the algo get the differences between the different emotions
		private String feeling;
		private int weight;

		public String getFeeling() {
			return feeling;
		}

		public void setFeeling(String feeling) {
			this.feeling = feeling;
		}

		

		public int getWeight() {
			return weight;
		}

		private EmotionType(int w, String f) {
			feeling = f;
			weight = w;
		}
		
		

	}
	
	public EmotionType getType() {
		return type;
	}

	public void setType(EmotionType type) {
		this.type = type;
	}
}
