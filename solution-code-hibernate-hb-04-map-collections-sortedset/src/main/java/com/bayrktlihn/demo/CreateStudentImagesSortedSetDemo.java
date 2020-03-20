package com.bayrktlihn.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Student;

public class CreateStudentImagesSortedSetDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student tempStudent = new Student("alihan", "bayraktar", "alihanbayraktar@bayrktlihn.com");
			Set<String> theImages = tempStudent.getImages();

			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo5.jpg");
			theImages.add("photo5.jpg");

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
