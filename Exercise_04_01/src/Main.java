
public class Main {

	public static void main(String[] args) {
		Counter counter = new Counter(50, 5);
		CounterIncrementer inc1 = new CounterIncrementer(counter, 50);
		CounterIncrementer inc2 = new CounterIncrementer(counter, 50);
		CounterIncrementer inc3 = new CounterIncrementer(counter, 50);

		CounterDecrementer dec1 = new CounterDecrementer(counter, 50);
		CounterDecrementer dec2 = new CounterDecrementer(counter, 50);
		CounterDecrementer dec3 = new CounterDecrementer(counter, 50);
		
		Thread tInc1 = new Thread(inc1);
		Thread tInc2 = new Thread(inc2);
		Thread tInc3 = new Thread(inc3);
		

		Thread tdec1 = new Thread(dec1);
		Thread tdec2 = new Thread(dec2);
		Thread tdec3 = new Thread(dec3);
		
		tInc1.start();
		tInc2.start();
		tInc3.start();
		
		tdec1.start();
		tdec2.start();
		tdec3.start();
		
	}
}