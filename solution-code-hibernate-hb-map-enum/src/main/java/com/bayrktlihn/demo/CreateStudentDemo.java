package com.bayrktlihn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Status;
import com.bayrktlihn.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student tempStudent1 = new Student("alihan", "bayraktar", "alihan.bayraktar@bayrktlihn.com", Status.ACTIVE);
			Student tempStudent2 = new Student("deniz", "bayraktar", "deniz.bayraktar@bayrktlihn.com", Status.INACTIVE);

			session.beginTransaction();

			System.out.println("Saving the students...");

			session.save(tempStudent1);
			session.save(tempStudent2);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
