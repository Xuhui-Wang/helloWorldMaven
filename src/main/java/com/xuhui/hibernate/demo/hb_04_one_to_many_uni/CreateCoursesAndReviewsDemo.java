package com.xuhui.hibernate.demo.hb_04_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Web Technology");

            // add reviews
            course.addReview(new Review("Great course! love it"));
            course.addReview(new Review("Good job! Come on!"));
            course.addReview(new Review("Fight on! Trojans!"));

            // save the course ... leverage the cascade all
            System.out.println("Saving the course: " + course);
            System.out.println("Reviews: " + course.getReviews());
            session.save(course);

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
