import utility.collection.ArrayQueue;

public class ThreadMain {

	public static void main(String[] args) {

		ArrayQueue<String> arrayQueue1 = new ArrayQueue<String>();

		Runnable r1 = new Adding(arrayQueue1, "1", 1000);

		Thread t1 = new Thread(r1);

		t1.start();

	}
}
