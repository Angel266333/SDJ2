package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.BoundedArrayQueue;

class BoundedArrayQueueTest {

	private BoundedArrayQueue<Integer> queue;
	private final static int CAPACITY = 100;

	@BeforeEach
	public void setUpQueue() {
		queue = new BoundedArrayQueue<Integer>(CAPACITY);
	}

	@Test
	public void queueEnqueueTest() {
		queue.enqueue(5);
		assertEquals(1, queue.size());
		for (int i = 0; i < CAPACITY - 1; i++)
			queue.enqueue(7);

		assertThrows(IllegalStateException.class, () -> queue.enqueue(5));
	}

	@Test
	public void queueDequeueTest() {
		queue.enqueue(7);
		assertEquals(1, queue.size());
		assertEquals(new Integer(7), queue.dequeue());
		assertThrows(IllegalStateException.class, () -> queue.dequeue());
		assertEquals(0, queue.size());
	}

	@Test
	public void queueFirstTest() {
		assertThrows(IllegalStateException.class, () -> queue.first());
		queue.enqueue(7);
		assertEquals(1, queue.size());
		assertEquals(new Integer(7), queue.first());
		assertEquals(1, queue.size());
	}

	@Test
	public void queueIndexOfTest() {
		assertEquals(-1, queue.indexOf(null));
		queue.enqueue(4);
		assertEquals(0, queue.indexOf(4));

	}

	@Test
	public void queueIsEmptyTest() {
		assertEquals(true, queue.isEmpty());
		queue.enqueue(7);
		assertEquals(false, queue.isEmpty());
	}

	@Test
	public void queueIsFullTest() {
		assertEquals(false, queue.isFull());
		for (int i = 0; i < CAPACITY; i++)
			queue.enqueue(7);
		assertEquals(true, queue.isFull());
	}

	@Test
	public void queueSizeTest() {
		assertEquals(0, queue.size());
		queue.enqueue(7);
		assertEquals(1, queue.size());
		
	}

}
