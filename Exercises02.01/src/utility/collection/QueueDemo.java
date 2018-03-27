package utility.collection;

public class QueueDemo {

	public static void main(String[] agrs) {
		
		ArrayQueue<Integer> queue = new ArrayQueue<>(5);
		
		queue.enqueue(6);
		queue.enqueue(64);
		queue.enqueue(9);
		queue.enqueue(70);
		queue.enqueue(20);
		
		System.out.println(queue);
		
//		System.out.println(queue.dequeue());
		
		System.out.println(queue);
		
		System.out.println(queue.indexOf(70));
		System.out.println(queue.indexOf(700));
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}
	
}
