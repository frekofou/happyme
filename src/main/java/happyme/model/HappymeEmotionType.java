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

	@Column(name = "feeling", nullable = false, updatable = true)
    @Enumerated(EnumType.STRING)
	private EmotionType type;
	public EmotionType getType() {return type;}
	public void setType(EmotionType type) {this.type = type;}

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum EmotionType {
		// possible emotions
		ANGRY(5, "ANGRY"), LOVE(15,"LOVE"), HAPPY(10,"HAPPY"), SAD(7, "SAD");
		// this how the algo take the differences between the different emotions
		private String feel = ""; 
		private int weight;

		private EmotionType(int w, String f) {
			feel = f;
			weight = w;
		}

		
		public String getFeel() {
			return feel;
		}

	}
}
