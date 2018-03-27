package utility.collection;

public class StackNode<T> {

	private T value;
	private StackNode next;
	
	public StackNode(T value, StackNode next) {
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public StackNode next() {
		return next;
	}
	
}
