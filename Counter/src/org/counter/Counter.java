package org.counter;

public class Counter {
	int count;
	public Counter() {count=0;}
	public int inc() {return ++count;}
	public int dec() {return --count;}
	
	public int inc(int n) {return ++n;}
	
	public int div(int n) throws Exception {
		if (n==0) throw new Exception("Divisione per 0");
		return count/=n;
	}
}
