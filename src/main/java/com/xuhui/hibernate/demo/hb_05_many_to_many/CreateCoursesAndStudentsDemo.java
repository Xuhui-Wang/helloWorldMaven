package com.xuhui.hibernate.demo.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
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
            Course course = new Course("Computer Systems");

            // save the course ... leverage the cascade all
            System.out.println("Saving the course: " + course);
            session.save(course);

            // create students
            Student student1 = new Student("John", "Doe", "doe@eecs.mit.edu");
            Student student2 = new Student("Mary", "Trump", "trump@eecs.mit.edu");

            // add the students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println("Saving the students: " + course.getStudents());
            session.save(student1);
            session.save(student2);

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
