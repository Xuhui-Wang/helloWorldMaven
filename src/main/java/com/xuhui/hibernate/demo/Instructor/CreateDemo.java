package com.xuhui.hibernate.demo.Instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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

            // create an object
            Instructor instructor = new Instructor("Donald", "Trump", "trump@whitehouse.gov");

            InstructorDetail instructorDetail = new InstructorDetail("https://youtu.be/aaOB-ErYq6Y",
                    "code in Java");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // save the instructor (also save detail object)
            session.save(instructor);
            System.out.println("Saved the instructor: " + instructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
