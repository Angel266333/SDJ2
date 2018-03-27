package counter;

public class IncrementDecrement {

	public static void main(String[] args) {
		Counter counter = new Counter(20, 10);
		CounterIncrementer inc1 = new CounterIncrementer(counter, 20);
		CounterIncrementer inc2 = new CounterIncrementer(counter, 20);
		CounterDecrementer dec1 = new CounterDecrementer(counter, 20);
		CounterDecrementer dec2 = new CounterDecrementer(counter, 20);
	
		Thread tInc1 = new Thread(inc1);
		Thread tInc2 = new Thread(inc2);
		Thread tDec1 = new Thread(dec1);
		Thread tDec2 = new Thread(dec2);
		
		tInc1.start();
		tInc2.start();
		tDec1.start();
		tDec2.start();
	
	}
	
}
