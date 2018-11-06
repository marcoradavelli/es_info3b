package org.counter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	void testCounter() {
		Counter c = new Counter();
		assertEquals(0,c.count);
	}
	
	@Test
	void testInc() {
		Counter c = new Counter();
		assertEquals(2,c.inc());
	}

	@Test
	void testDec() {
		fail("Not yet implemented");
	}
	
	/*@Test(expected=Exception.class)
	void testDivException() {
		Counter c = new Counter();
		c.inc();
		c.inc();
		c.div(0);
	}*/

}
