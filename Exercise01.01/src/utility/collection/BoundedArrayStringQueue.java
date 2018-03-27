package utility.collection;

public class BoundedArrayStringQueue implements StringQueueADT {

	private String[] queue;
	private int count;
	private int front;

	public BoundedArrayStringQueue(int capacity) {
		queue = new String[capacity];
		count = 0;
		front = 0;
	}

	@Override
	public void enqueue(String element) {
		try {
			queue[front + count] = element;
			count++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalStateException("Queue is full");
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
		for (int i = front; i < (front + count); i++)
			if (queue[i].equals(element))
				return i;
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
		
		for(int i=front;i<(front+count);i++) 
			result += queue[i] + ", ";
		
		return result + "}";
	}

}
