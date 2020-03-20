package com.bayrktlihn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Instructor;
import com.bayrktlihn.entity.Student;
import com.bayrktlihn.entity.User;

public class CreateUserStudentInstructorDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			User tempStudent = new Student("alihan", "bayraktar", "alihan.bayraktar@bil.omu.edu.tr", "Hibernate");
			User tempInstructor = new Instructor("sadi evren", "seker", "sadi.evren.seker@bil.omu.edu.tr", 20000);

			session.beginTransaction();

			
			System.out.println("Saving the students and instructor...");
			session.save(tempInstructor);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
