package utility.collection;

public class Node<T> {

	private Node next;
	private T value;

	public Node(T value) {
		this.value = value;
	}
	
	public boolean hasNext() {
		if(next == null)
			return false;
		return true;
	}
	
	public Node next() {
		return next;
	}
	
	public T getValue() {
		return value;
	}

	public void setNext(Node node) {
		next = node;
	}

}
