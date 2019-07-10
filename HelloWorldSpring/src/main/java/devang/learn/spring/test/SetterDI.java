package devang.learn.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import devang.learn.spring.beans.Test;

// using advance (J2EE) IOC container
public class SetterDI {

	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/SetterDI.xml");
		Object o = ap.getBean("t");
		devang.learn.spring.beans.SetterDI t = (devang.learn.spring.beans.SetterDI)o;
		t.printData();
	}
}
