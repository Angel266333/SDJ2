
public class AddValues implements Calculator {

	private double valueOne;
	private double valueTwo;

	public AddValues(double valueOne, double valueTwo) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;

	}

	@Override
	public double calculateTotalValue() {
		double result = this.valueOne + this.valueTwo;
		return result;
	}
}
