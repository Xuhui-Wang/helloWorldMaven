package com.xuhui.demoAnnotations;

import com.xuhui.helloMaven.HelloSpringApp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AnnotationDemoApp {
    public static void main(String[] args) throws IOException {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanAnnotation-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();

    }
}
