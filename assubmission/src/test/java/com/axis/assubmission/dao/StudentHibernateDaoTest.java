package com.axis.assubmission.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.axis.assubmission.entity.Account;
import com.axis.assubmission.entity.Student;

public class StudentHibernateDaoTest {
	private static StudentHibernateDao studentDao;
	private Student student;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentDao = new StudentHibernateDao();
		studentDao.setSession(HibernateUtil.getSessionFactoryInstance()
				.openSession());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Account account = new Account("axis", "axis-123", Account.SEX_MALE);
		student = new Student();
		student.setAccount(account);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveOrUpdateStudent() {
		studentDao.saveOrUpdate(student);
		System.out.println("save:" + student.getId());
		studentDao.detach(student);
		studentDao.flush();
		studentDao.clear();
		System.out.println("detached:" + student.getId());
	}

}
