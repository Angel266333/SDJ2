import java.util.ArrayList;

public class CalculatorLogicHandler {

	private ArrayList<Calculator> calculations = new ArrayList<Calculator>();

	public void addCalculation(Calculator calc) {
		calculations.add(calc);
	}
	
	public double getTotal() {
		double getTotal = 0;

		for (Calculator calc : calculations) {
			getTotal += calc.calculateTotalValue();
		}
		return getTotal;
	}

}
