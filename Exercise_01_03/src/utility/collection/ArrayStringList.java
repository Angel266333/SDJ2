package utility.collection;

public class ArrayStringList implements StringListADT {

	private int DEFAULT_CAPACITY = 100;
	private String[] list;
	private int size;

	public ArrayStringList(int initialCapacity) {
		list = new String[initialCapacity];
		size = 0;

	}

	public ArrayStringList() {
		list = new String[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public void add(int index, String element) {
		if (size + 1 < list.length) {
			for (int i = (size - 1); i >= index; i--) {
				list[i + 1] = list[i];
			}
			list[index] = element;
		} else {
			throw new IllegalStateException("List is full");
		}
	}

	@Override
	public void add(String element) {
		try {
			list[size] = element;
			size++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalStateException("list is full");
		}
	}

	@Override
	public void set(int index, String element) {
		list[index] = element;
	}

	@Override
	public String get(int index) {
		return list[index];
	}

	@Override
	public String remove(int index) {
		try {
			String result = list[index];
			for (int i = index; i < (size - 1); i++) {
				list[i] = list[i + 1];
			}
			size--;
			return result;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalStateException("there is no such index");
		}
	}

	@Override
	public String remove(String element) {
		return remove(indexOf(element));
	}

	@Override
	public int indexOf(String element) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(String element) {
		if (indexOf(element) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isFull() {
		if (size < list.length) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int size() {
		return size;
	}
}