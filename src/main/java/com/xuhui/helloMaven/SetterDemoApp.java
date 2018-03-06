package com.xuhui.helloMaven;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

//import org.springframework.context.ApplicationContext;

public class SetterDemoApp {
	public static void main(String[] args) {
		// load the spring configuration file
		FileSystemXmlApplicationContext context =
				new FileSystemXmlApplicationContext("src/applicationContext.xml");

//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call fortune service method
		System.out.println(theCoach.getDailyFortune());

		// call the new methods to return literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		// close the context
		context.close();
		
	}

}
