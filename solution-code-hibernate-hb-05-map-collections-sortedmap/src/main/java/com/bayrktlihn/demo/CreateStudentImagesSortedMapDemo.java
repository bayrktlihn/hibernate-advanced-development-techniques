package com.bayrktlihn.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Student;

public class CreateStudentImagesSortedMapDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student tempStudent = new Student("alihan", "bayraktar", "alihanbayraktar@bayrktlihn.com");
			Map<String, String> theImages = tempStudent.getImages();

			theImages.put("photo1.jpg", "Photo 1");
			theImages.put("photo2.jpg", "Photo 2");
			theImages.put("photo3.jpg", "Photo 3");

			session.beginTransaction();

			System.out.println("Saving the student and images");
			session.persist(tempStudent);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
