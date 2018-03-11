package com.xuhui.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();

            // find the student's ID: primary key
            System.out.println("\nGetting the student's ID: " + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("\nGet complete: " + student);

            // delete
            System.out.println("\nDeleting: " + student);
            session.delete(student);

            // delete student id = 2
            session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
