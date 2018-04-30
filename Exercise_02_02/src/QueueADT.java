
public interface QueueADT<T> {

	public void enqueue(T element);
	
	public T dequeue();
	
	public T first();
	
	public int indexOf(T element);
	
	public boolean isFull();
	
	public int size();
	
}
