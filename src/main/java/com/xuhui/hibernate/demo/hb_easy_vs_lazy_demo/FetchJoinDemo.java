package com.xuhui.hibernate.demo.hb_easy_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            // option 2: hibernate query with HQL
            // get the instructor from db
            int id = 1;
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "WHERE i.id =:instructorId",
                            Instructor.class);

            // set query parameter
            query.setParameter("instructorId", id);

            // execute query and get parameter
            Instructor instructor = query.getSingleResult();

            System.out.println("Get the instructor: " + instructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Session committed");
            System.out.println("Courses: " + instructor.getCourses());

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
