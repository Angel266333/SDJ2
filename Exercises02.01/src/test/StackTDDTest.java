package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utility.collection.StackTDD;

class StackTDDTest {
	
	private StackTDD<Integer> stack;
	
	@BeforeEach
	public void setUpStack() {
		stack = new StackTDD<Integer>();
	}

	@Test
	public void stackPushTest() {
		stack.push(5);
		assertEquals(1, stack.size());
		stack.push(10);
		assertEquals(2, stack.size());
	}
	
	@Test
	public void pop() {
		stack.push(5);
		assertEquals(1, stack.size());
		assertEquals(new Integer(5), stack.pop());
		assertEquals(0, stack.size());
		assertThrows(IllegalStateException.class, stack::pop);
	}

}
