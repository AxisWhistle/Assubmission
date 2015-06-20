package com.axis.assubmission.factory.dao;

import org.hibernate.Session;

import com.axis.assubmission.dao.AccountDao;
import com.axis.assubmission.dao.HibernateUtil;
import com.axis.assubmission.dao.StudentDao;
import com.axis.assubmission.dao.StudentHibernateDao;

public class DaoHibernateFactory implements DaoFactory {
	private Session session;

	private static DaoHibernateFactory daoHibernateFactory = new DaoHibernateFactory();

	public static DaoHibernateFactory getInstance() {
		return daoHibernateFactory;
	}

	private DaoHibernateFactory() {
		session = HibernateUtil.getSessionFactoryInstance().openSession();
	}

	@Override
	public StudentDao getStudentDao() {
		StudentHibernateDao shd = new StudentHibernateDao();
		shd.setSession(session);
		return shd;
	}

	@Override
	public AccountDao getAccountDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
