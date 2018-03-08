public class Die {

	private int numDots;

	public void roll() {
		double dots = Math.random();
		numDots = (int)(dots * 6) + 1;

	}

	public int getNumDots() {
		return numDots;
	}

}