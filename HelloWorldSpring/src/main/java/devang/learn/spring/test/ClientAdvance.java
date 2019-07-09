package devang.learn.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import devang.learn.spring.beans.Test;

// using advance (J2EE) IOC container
public class ClientAdvance {

	public static void main(String[] args) {
		
		// while loading the xml file Test class object will be created unlike BeanFactory (CORE container)
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml"); // here the object of Test class will be created
		// meaning at the time of loading xml file object will be created
		// so ApplicationContext is a "EAGER" container
		// EAGER loading is better approach instead of lazy loading
		// Because in LAZY loading it will create object on demand so it may create delay in application
		// so ApplicationContext is a recommended container because it has many features
		
		
		// NOTE when scope="singleton" then only ApplicationContext will create object at the time of loading xml file
		// otherwise (scope="prototype") it will not create object at the time of loading xml file
		// so it will behave as LAZY container, it will do lazy instantiotions  
		Object o = ap.getBean("t");
		Test t = (Test)o;
		t.hello();
		
	
		
	}

}
