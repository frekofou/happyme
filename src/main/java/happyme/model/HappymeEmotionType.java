package happyme.model;

public class HappymeEmotionType {

	public enum EmotionType {
		// possible emotions
		ANGRY(5), LOVE(15), HAPPY(10), SAD(7);
		// this how the algo take the differences between the different emotions
		private int weight;

		private EmotionType(int w) {
			weight = w;
		}

		public int getWeight() {
			return weight;
		}

	}
}
