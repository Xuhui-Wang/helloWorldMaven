package com.xuhui.helloMaven;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("src/applicationContext.xml").toAbsolutePath();
		System.out.println("current path: " + path.toString());
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("src/applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
		
	}

}
