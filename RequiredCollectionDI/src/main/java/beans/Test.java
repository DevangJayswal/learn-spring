package beans;

import java.util.*;

public class Test {
	private Vector fruits;
	private TreeSet cricketers;
	// country capitals
	private Hashtable cc;
	

	public void setFruits(Vector fruits) {
		this.fruits = fruits;
	}
	public void setCricketers(TreeSet cricketers) {
		this.cricketers = cricketers;
	}
	public void setCc(Hashtable cc) {
		this.cc = cc;
	}
	public void printData() {
		System.out.println("Fruits.......");
		for(Object fruit: fruits ) {
			System.out.println(fruit);			
		}
		System.out.println("cricketers..........");
		for(Object cricketer: cricketers) {
			System.out.println(cricketer);
		}
		System.out.println("countries and capitals......");
		Set keys=cc.keySet();
		for(Object key:keys) {
			System.out.println("Country:" + key + "|Capital:" + cc.get(key));
		}
	}
}
