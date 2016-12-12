package it.unibg.info3b;

public class EstraiModel {
	private int num;
	
	public EstraiModel() {
		num=0;
	}
	
	public int getValue() {
		return num;
	}
	
	public void doEstrai() {
		num = (int)(Math.random()*100);
	}
}
