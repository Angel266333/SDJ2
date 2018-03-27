package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayStack;

class StackTest2 {
	
	private ArrayStack<Integer> stack;
	private static final int CAPACITY = 10;
 	
	@BeforeEach
	public void setUpStack() {
		stack = new ArrayStack<Integer>(CAPACITY);
	}

	@Test
	void pushTest() {
		stack.push(5);
		assertEquals(1, stack.size());
		
		
		
		for(int i=0;i<8;i++)
			stack.push(5);
		
		try {
			stack.push(10);
		}catch(Exception e) {
			fail("Shouldn't throw exception");
		}

		try {
			stack.push(null);
		}catch(Exception e) {
			fail("Shouldn't throw exception");
		}
		
		
		
	}

}
