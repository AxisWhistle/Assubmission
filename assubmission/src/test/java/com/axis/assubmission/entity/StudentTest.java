package com.axis.assubmission.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.axis.assubmission.dao.HibernateUtil;

public class StudentTest {

	private static Session session;

	@BeforeClass
	public static void beforeClass() {
		SessionFactory sessionFactory = HibernateUtil
				.getSessionFactoryInstance();
		session = sessionFactory.openSession();
	}

	@Test
	public void testAddStudentAccount() {
		// Account account = new Account("axis", "axis-123", Account.SEX_MALE);
		// Student student = new Student();
		// student.setAccount(account);
		// session.getTransaction().begin();
		// session.save(student);
		// session.flush();
		// session.getTransaction().commit();
		// System.out.println(student.getId());
	}

}
