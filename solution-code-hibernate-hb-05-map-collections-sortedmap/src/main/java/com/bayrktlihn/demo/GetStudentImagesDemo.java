package com.bayrktlihn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Student;

public class GetStudentImagesDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Student student = session.get(Student.class, 1);
			System.out.println("Student details: " + student);

			System.out.println("The associated images: " + student.getImages());

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
