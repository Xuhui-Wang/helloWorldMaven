package com.xuhui.helloMaven;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

//import org.springframework.context.ApplicationContext;

public class BeanLifeCycleDemoApp {
	public static void main(String[] args) throws IOException {
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call fortune service method
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
		
	}

}
