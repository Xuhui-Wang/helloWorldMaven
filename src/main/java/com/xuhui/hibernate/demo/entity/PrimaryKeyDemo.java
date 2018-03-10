package com.xuhui.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save Java object
            // create 3 student objects
            System.out.println("Creating 3 student objects");
            Student student1 = new Student("Donald", "Trump", "trump@ihs.gov");
            Student student2 = new Student("Hillary", "Clinton", "bill@ihs.gov");
            Student student3 = new Student("Mark", "Zuckburg", "mark@ihs.gov");

            // begin the transaction
            session.beginTransaction();

            System.out.println("Processing ... ");
            // save the student object
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
