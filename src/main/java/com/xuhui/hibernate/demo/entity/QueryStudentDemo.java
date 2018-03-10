package com.xuhui.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            // use the session object to save Java object

            // query the students
            System.out.println("Query the students");
            List<Student> studentList = session.createQuery("from Student").list();

            // display the students
            displayStudents(studentList);

            // query students: lastname== 'Trum'
            studentList = session.createQuery("from Student s where s.lastName='Trump'").list();

            // display students
            displayStudents(studentList);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}