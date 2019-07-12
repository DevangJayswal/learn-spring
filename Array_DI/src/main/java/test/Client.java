package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Car;

// example showing premitive and secondary type array dependency injection

public class Client {

	public static void main(String[] args) {

		 
//		String files[] = new String[] { "resources/car.xml", "resources/engine.xml" };
//		ApplicationContext ap = new ClassPathXmlApplicationContext(files);
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
		Car c = (Car)ap.getBean("c");
		c.printCarData();

	}

}
