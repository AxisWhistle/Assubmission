package com.axis.assubmission;

import com.axis.assubmission.dao.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactoryInstance();
	}
}
