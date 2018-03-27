package utility.collection;

public class DemoQueue {
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		
		
		queue.push("Mi�ka");
		queue.push("Micha�");
		queue.push("Jakub");
		queue.push("Angel");
		queue.push("Samuel");
		queue.push("Jackson");
		
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.first());
		System.out.println(queue.indexOf("Micha�"));
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
	}

}
