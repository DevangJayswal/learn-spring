package devang.learn.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import devang.learn.spring.beans.Test;

// using Core container
public class Client {

	public static void main(String[] args) {
		// find xml
		Resource r = new ClassPathResource("resources/spring.xml");
		
		// load xml into container
		BeanFactory factory = new XmlBeanFactory(r); // it will not create the Test class object here 
		
		//create test class object
		// it will create only one object even if you call multiple time 
		Object o = factory.getBean("t"); // it will create object when this line is executed
		// that is why BeanFactory is called "LAZY" container
		// it will not create the object while loading the xml file
		// on demand only it will create object
		
		Object o1 = factory.getBean("t"); 
		Object o2 = factory.getBean("t");
		
		// Servlet class is not a singleton but tomcat container will make that class object as a singleton
		// means only one single servlet object your container will create
		// in the same way, Test class object also it will create only one single object even if you call it multiple time 
		
		// means it is creating only one single object
		System.out.println(o==o1);
		System.out.println(o1==o2);
		
		// IOC container creating only one singleton object
		
		// in spring.xml scope="singleton" scope="prototype"
		// if it is a web application, along with this we can add three more scope "request", "session" and "context" scope 
		
		Test t = (Test)o;
		t.hello();

	}

}
