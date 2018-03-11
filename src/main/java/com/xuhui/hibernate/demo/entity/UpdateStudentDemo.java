package com.xuhui.hibernate.demo.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 3;
            session.beginTransaction();

            // find the student's ID: primary key
            System.out.println("Getting the student's ID: " + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("Get complete: " + student);

            // update
            student.setFirstName("Dobby");

            // commit the transaction
            session.getTransaction().commit();

            // new code - update emails for all students
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'")
                .executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
