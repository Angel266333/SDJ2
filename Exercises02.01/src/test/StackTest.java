package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayStack;

class StackTest {

	ArrayStack<Integer> stack;

	@BeforeEach
	public void setUpStack() {
		stack = new ArrayStack<Integer>();
	}

	@Test
	public void stackPushTest() {
		stack.push(5);
		assertEquals(1, stack.size());

		try {
			for (int i = 0; i < 99; i++)
				stack.push(7);
			assertEquals(100, stack.size());
		} catch (Exception e) {
			fail("Shouldn't throw exception, duplicates are allowed");
		}

		try {
			stack.push(42);
			assertEquals(101, stack.size());
			stack.push(null);
		} catch (IllegalStateException e1) {
			fail("Shouldn't throw exception, stack can not be full");
		} catch (IllegalArgumentException e2) {
			fail("Shouldn't throw exception, null value is allowed");
		}
	}
	
	@Test
	public void stackPopTest() {
		stack.push(20);
		assertEquals(new Integer(20), stack.pop());
		assertEquals(0, stack.size());
		assertThrows(IllegalStateException.class, stack::pop);
	}
	
	@Test
	public void stackPeekTest() {
		assertThrows(IllegalStateException.class, stack::peek);
		stack.push(5);
		assertEquals(new Integer(5), stack.peek());
		assertEquals(1, stack.size());
	}

	@Test
	public void stackIndexOfTest() {
		stack.push(5);
		assertEquals(0, stack.indexOf(5));
		assertEquals(-1, stack.indexOf(10));
	}
	
	@Test
	public void stackIsEmptyTest() {
		assertEquals(true, stack.isEmpty());
		stack.push(7);
		assertEquals(false, stack.isEmpty());
	} 
	
	@Test
	public void stackIsFullTest() {
		assertEquals(false, stack.isFull());
		for(int i = 0; i<1000; i++)
			stack.push(69);
		assertEquals(false, stack.isFull());
		
	}
	
	@Test
	public void stackSizeTest() {
		assertEquals(0, stack.size());
		for(int i=0; i<10; i++)
			stack.push(5);
		assertEquals(10, stack.size());
	}
	
	@Test
	public void stackToStringTest() {
		assertEquals("{}", stack.toString());
		for(int i =0; i<3; i++)
			stack.push(i);
		assertEquals("{0, 1, 2}", stack.toString());
	}
	
	@AfterEach
	public void clearStack() {
		stack = null;
	}
}
