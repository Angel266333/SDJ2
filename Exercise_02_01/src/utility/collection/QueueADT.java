package utility.collection;

public interface QueueADT<T> {

	public void enqueue(String element);

	public String dequeue();

	public String first();

	public int indexOf(String element);

	public boolean isEmpty();

	public boolean isFull();

	public int size();

}
