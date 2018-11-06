package org.counter;

public class Counter {
	int count;
	public Counter() {count=0;}
	public int inc() {return ++count;}
	public int dec() {return --count;}
	
	public int inc(int n) {return ++n;}
}
