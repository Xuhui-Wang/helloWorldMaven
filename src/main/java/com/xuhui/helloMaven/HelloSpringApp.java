package com.xuhui.helloMaven;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	private void checkPath() {
		Path path = FileSystems.getDefault().getPath("src/main/applicationContext.xml").toAbsolutePath();
		System.out.println("current path: " + path.toString());
	}

	public static void main(String[] args) throws IOException {
		HelloSpringApp app = new HelloSpringApp();
		app.checkPath();
        File myFile = new File("classpath:applicationContext.xml");
        System.out.println("Attempting to read from file in: "+myFile.getCanonicalPath());

        // load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");

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
