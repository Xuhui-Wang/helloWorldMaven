package com.xuhui.helloMaven;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

//import org.springframework.context.ApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) throws IOException {
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same
		boolean result = (theCoach == alphaCoach);

		System.out.println("\nPoint to the same object? " + result);
		System.out.println("\nMemory location for 'theCoach'" + theCoach);
		System.out.println("\nMemory location for 'alphaCoach'" + alphaCoach);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call fortune service method
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
		
	}

}
