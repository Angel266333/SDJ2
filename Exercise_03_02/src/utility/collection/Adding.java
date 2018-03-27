package utility.collection;

import QueueADT;

public class Adding implements Runnable {

	private String id;
	private long sleepTime;

	private QueueADT<String> queue;

	public Adding(QueueADT<String> queue, String id, long sleepTime) {

		this.queue = queue;
		this.id = id;
		this.sleepTime = sleepTime;

	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			this.queue.enqueue(id + " " + i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("Process was interrupted!");
			}
		}

	}
	
	
	
}
