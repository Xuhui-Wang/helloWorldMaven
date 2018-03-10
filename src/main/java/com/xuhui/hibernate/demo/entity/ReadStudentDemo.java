package com.xuhui.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
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

            // create the student object
            System.out.println("Creating a new student object");
            Student student = new Student("Donald", "Ryan", "ran@ihs.gov");

            // begin the transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);

            // commit the transaction
            session.getTransaction().commit();

            // my new code - retrieve the object
            System.out.println("Saved student. Generated id: " + student.getId());

            // get a new session
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the student based on Id
            System.out.println("\nGetting student with Id: " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("\nGetting complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
