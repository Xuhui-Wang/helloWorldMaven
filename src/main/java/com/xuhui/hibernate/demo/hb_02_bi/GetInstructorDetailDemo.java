package com.xuhui.hibernate.demo.hb_02_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 2999;
            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("Instructor detail: " + instructorDetail);

            // print the associated instructor
            System.out.println("Instructor: " + instructorDetail.getInstructor());

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
