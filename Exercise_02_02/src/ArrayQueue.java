
public class ArrayQueue<T> implements QueueADT<T> {

	private int DEFAULT_CAPACITY = 100;
	private int front;
	private int count;
	private T[] queue;

	public ArrayQueue() {
		front = 0;
		count = 0;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
	}

	@Override
	public void enqueue(T element) {
		if (queue[(front + count) % queue.length] == null) {
			queue[(front + count) % queue.length] = element;
			count++;
		} else {
			expandCapacity();
			queue[(front + count) % queue.length] = element;
			count++;
		}
	}

	@Override
	public T dequeue() {
		if (queue[front] != null) {
			T result = queue[front];
			queue[front] = null;
			count--;
			front++;
			return result;
		} else {
			throw new IllegalStateException("Queue is empty");
		}
	}

	@Override
	public T first() {
		if (queue[front] != null) {
			return queue[front];
		} else {
			throw new IllegalStateException("Queue is empty");
		}
	}

	@Override
	public int indexOf(T element) {
		for (int i = front, x = 0; x < count; i = (i + 1) % queue.length) {
			if (queue[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isFull() {
		if (queue[front] != null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return count;
	}

	public String toString() {
		String result = "";

		for (int i = front, x = 0; x < count; i = (i + 1) % queue.length, x++) {
			result += queue[i].toString() + ", ";
		}
		return result + "}";
	}

	private void expandCapacity() {
		T[] expanded = (T[]) new Object[queue.length * 2];
		for (int i = front, x = 0; x < count; i = (i + 1) % queue.length, x++) {
			expanded[x] = queue[i];
		}
		queue = expanded;
	}
}