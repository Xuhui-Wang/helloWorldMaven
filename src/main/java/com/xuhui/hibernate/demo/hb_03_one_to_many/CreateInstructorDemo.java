package com.xuhui.hibernate.demo.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // create an object
            Instructor instructor = new Instructor("Mike", "Donald", "donald@whitehouse.gov");

            InstructorDetail instructorDetail = new InstructorDetail("https://youtu.be/aaOB-ErYq6Y",
                    "code in PHP");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
/*
            // create an object
            instructor = new Instructor("Bill", "Clinton", "clinton@whitehouse.gov");

            instructorDetail = new InstructorDetail("https://youtu.be/aaOB-ErYq6Y",
                    "code in Python");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // save the instructor (also save detail object)
            session.save(instructor);
            */
            System.out.println("Saved the instructor: " + instructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
