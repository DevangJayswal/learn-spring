package devang.learn.spring.beans;

public class SetterDI {
	private String pName;
	private int age;
	private String email;
	
	SetterDI(String pName, int age, String email){
		this.pName = pName;
		this.age=age;
		this.email=email;
	}
	
	public void setpName(String name) {
		this.pName = name;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	public void setEmail(String email) {
		this.email = email;
	}
	public void printData() {
		System.out.println("pName="+pName);
		System.out.println("age="+age);
		System.out.println("email="+email);
	}

}
