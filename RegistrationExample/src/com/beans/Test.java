package com.beans;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		Person p = new Person();
		p.setId(100);
		p.setFirstName("devang");
		p.setCity("gand");
		p.setEmail("dnj");
		p.setLastName("jay");
		p.setPhone("438");
		
		
		PersonDAO pd = new PersonDAO();
		pd.addPerson(p);
		

	}

}
