package utility.collection;

public class StackTDD<T> {

	private StackNode stack;
	private int size;

	public StackTDD() {
		size = 0;
		stack = null;
	}

	public void push(T element) {
		StackNode<T> node = new StackNode<T>(element, stack);
		stack = node;
		size++;
	}

	public int size() {
		return size;
	}

	public T pop() {
		if (size != 0) {
			T result = (T) stack.getValue();
			stack = stack.next();
			size--;
			return result;
		}
		throw new IllegalStateException("Stack is empty");
	}

}
