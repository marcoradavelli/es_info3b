package org.counter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CounterParametricTest {

	private int  input;
	private int  inputIncrementato;
	public  CounterParametricTest(int  p1,  int  p2){ 
		input  =  p1;  inputIncrementato  =  p2; 
		}
	@Parameters  
	public static Collection  creaParametri(){
		return Arrays.asList(new Object[][]{  {0,  1  },  {2,  3},{5,6} });
	}

	@Test 
	public void testParametrico(){
		Counter c = new Counter();
		int  outputAttuale  =  c.inc(this.input);
		assertEquals(this.inputIncrementato,outputAttuale);
	}
}
