package utility.collection;

public class ArrayStringQueue implements StringQueueADT {

	private static final int DEAFAULT_CAPACITY = 100;
	private String[] queue;
	private int count;
	private int front;

	public ArrayStringQueue(int initialCapacity) {
		queue = new String[initialCapacity];
		count = 0;
		front = 0;
	}

	public ArrayStringQueue() {
		queue = new String[DEAFAULT_CAPACITY];
		count = 0;
		front = 0;
	}

	@Override
	public void enqueue(String element) {
		if (count < queue.length) {
			queue[front + count] = element;
			count++;
		} else {
			expandCapacity();
		}
	}

	@Override
	public String dequeue() {
		if (queue[front] != null) {
			String result = queue[front];
			queue[front] = null;
			count--;
			front++;
			return result;
		} else {
			throw new IllegalStateException("Queue is empty");
		}
	}

	@Override
	public String first() {
		if (queue[front] != null) {
			return queue[front];
		} else {
			throw new IllegalStateException("Queue is empty");
		}
	}

	@Override
	public int indexOf(String element) {
		for (int i = front; i < (front + count); i++) {
			if (queue[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (queue[front] == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return count;
	}

	public String toString() {
		String result = "{";

		for (int i = front; i < (front + count); i++) {
			result += queue[i] + ", ";
		}
		return result + "}";
	}

	private void expandCapacity() {
		String[] newCapacity = new String[queue.length * 2];

		for (int i = front; i < (front + count); i++) {
			newCapacity[i] = queue[i];
			queue = newCapacity;
		}
	}
}