package utility.collection;

public class Queue<T> {

	private Node first;

	public Queue() {
	}

	public void push(T value) {
		if (first == null) {
			Node node = new Node<T>(value);
			first = node;
		} else {
			Node node = new Node<T>(value);
			getLastNode().setNext(node);
		}
	}

	public T pop() {
		T result = (T) first.getValue();
		first = first.next();

		return result;
	}

	public T first() {
		return (T) first.getValue();
	}

	public int indexOf(T value) {
		int index = 0;
		Node node = first;
		while (node.hasNext()) {
			if (node.getValue().equals(value))
				return index;
			else {
				index++;
				node = node.next();
			}
		}
		if (node.getValue().equals(value))
			return index;

		return -1;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		int size = 0;
		Node node = first;
		while (node.hasNext()) {
			node = node.next();
			size++;
		}
		if (node != null)
			size++;
		return size;

	}

	private Node getLastNode() {
		Node node = first;
		while (node.hasNext())
			node = node.next();
		return node;
	}

	public String toString() {
		String result = "{";

		Node node = first;
		while (node.hasNext()) {
			result += node.getValue().toString() + ", ";
			node = node.next();
		}
		result += node.getValue().toString() + ", ";
		node = node.next();

		return result + "}";
	}

}
