package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Car;

public class Client {

	public static void main(String[] args) {

//		String files[] = new String[] { "resources/car.xml", "resources/engine.xml" };
//		ApplicationContext ap = new ClassPathXmlApplicationContext(files);
//		Car c = (Car) ap.getBean("c");
//		c.printCarData();
		
		// in case if we don't want to use reference
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/car-engine.xml");
		Car c = (Car) ap.getBean("c");
		c.printCarData();

	}

}
