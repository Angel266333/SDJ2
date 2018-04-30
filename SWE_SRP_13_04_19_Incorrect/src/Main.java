import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
		
	int selection = 0;
		
	System.out.println("What would you like to do? ");
	System.out.println("\n1) Add values");
	System.out.println("\n2) Deduct values");
	selection = keyboard.nextInt();
	if (selection == 1) {
		System.out.println("Enter values that you would like to add up: ");
		double valueOne = keyboard.nextInt();
		double valueTwo = keyboard.nextInt();
		AddValues add = new AddValues(valueOne, valueTwo);
		CalculatorLogicHandler logic = new CalculatorLogicHandler();
		logic.addCalculation(add);
		System.out.println("The result is: \n" + logic.getTotal());
	}
		else if (selection == 2) {
		System.out.println("Enter values that you would like to deduct: ");
		double valueOne = keyboard.nextInt();
		double valueTwo = keyboard.nextInt();
		CalculatorLogicHandler logic = new CalculatorLogicHandler();
		DeductValues remove = new DeductValues(valueOne, valueTwo);
		logic.addCalculation(remove);
		System.out.println("The result is: \n" + logic.getTotal());	
		}
		else {
			System.out.println("You dun goofed!");
		}
}
}

