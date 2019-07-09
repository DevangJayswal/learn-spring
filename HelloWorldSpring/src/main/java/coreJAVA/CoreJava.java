package coreJAVA;

public class CoreJava {
	static int i=0;
	int j=0;
	
	public static void main(String[] args) {
	
		CoreJava c1 = new CoreJava();
		CoreJava c2 = new CoreJava();
		
		c1.i= 2;
		System.out.println("c1"+c1.i);
		c2.i=3;
		System.out.println("c2"+c2.i);
		
		
		
		c1.j=4;
		c2.j=5;
	}

}
