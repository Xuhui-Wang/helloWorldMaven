package com.xuhui.hibernate.demo.hb_easy_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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

            // get the instructor
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Get the instructor: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());

            // commit the transaction
            session.getTransaction().commit();

//            System.out.println("Courses: " + instructor.getCourses());

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
