package com.xuhui.helloMaven;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Path;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpringApp {

	private void checkPath() {
		Path path = FileSystems.getDefault().getPath("src/main/java/com/xuhui/helloMaven/applicationContext.xml").toAbsolutePath();
		System.out.println("current path: " + path.toString());
		ClassLoader loader = HelloSpringApp.class.getClassLoader();
		System.out.println(loader.getResource("applicationContext.xml"));
//		String filename = "test01.xml";
//		URL url = getClass().getResource(filename);
//		System.out.println(url.getPath());

	}
	public static void main(String[] args) {
		HelloSpringApp app = new HelloSpringApp();
		app.checkPath();
		// load the spring configuration file
		FileSystemXmlApplicationContext context =
				new FileSystemXmlApplicationContext("src/applicationContext.xml");

//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");

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
