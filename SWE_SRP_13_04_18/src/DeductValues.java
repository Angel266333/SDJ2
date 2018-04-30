
public class DeductValues implements Calculator {

	private double valueOne;
	private double valueTwo;

	public DeductValues(double valueOne, double valueTwo) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;

	}

	@Override
	public double calculateTotalValue() {
		double result = this.valueOne - this.valueTwo;
		return result;
	}
}