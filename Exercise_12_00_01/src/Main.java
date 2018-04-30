import logSystem.LogLine;

public class Main {

	public static void main(String[] args) {

		LogLine lineObject = new LogLine("Organisation of exercises started...");

		{
			try {
				System.out.println(lineObject);
			} catch (NullPointerException e) {
				System.out.println("Exercise was never meant to work :P");
			}
		}

	}
}