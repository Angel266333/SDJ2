
public class Counter {

	private long value;
	private long max;
	private long min;

	public Counter(long max, long min) {
		this.value = 0;
		this.max = max;
		this.min = min;
	}

	public synchronized void increment() {
		while (value >= max) {
			try {
				System.out.println(value + ": " + Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(value + ": " + Thread.currentThread().getName());
		value++;
		notifyAll();

	}

	public synchronized void decrement() {
		while (value <= min) {
			try {
				System.out.println(value + ": " + Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(value + ": " + Thread.currentThread().getName());
		value--;
		notifyAll();
	}

	public synchronized long getValue() {
		System.out.println(value + ": " + Thread.currentThread().getName());
		return value;
	}
}