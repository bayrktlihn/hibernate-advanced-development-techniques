package com.bayrktlihn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bayrktlihn.entity.Address;
import com.bayrktlihn.entity.Student;

public class CreateStudentAddressDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			Student tempStudent = new Student("alihan", "bayraktar", "alihan.bayraktar@bayrktlihn.com");
			
			Address billingAddress = new Address("Some Billing Street", "Some Billing City", "61000");
			
			session.beginTransaction();

			System.out.println("Saving the student and billing  address...");
			tempStudent.setBillingAddress(billingAddress);
			
			session.save(tempStudent);
			
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
