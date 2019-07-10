package coreJAVA;

public class CoreJava {
	int i=0;
	static int j=0;
	
	public static void main(String[] args) {
	
		CoreJava c1 = new CoreJava();
		CoreJava c2 = new CoreJava();
		
		c1.i= 2;
		c2.i=3;
		System.out.println("c1.i="+c1.i);		
		System.out.println("c2.i="+c2.i);
		System.out.println("c1.i="+c1.i);
		
		c1.j=4;
		System.out.println("c1.j="+c1.j);
		c2.j=5;
		System.out.println("c2.j="+c2.j);
		System.out.println("c1.j="+c1.j);
	}

}
