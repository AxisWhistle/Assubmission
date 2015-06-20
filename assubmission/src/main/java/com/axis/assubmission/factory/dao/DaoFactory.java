package com.axis.assubmission.factory.dao;

import com.axis.assubmission.dao.AccountDao;
import com.axis.assubmission.dao.StudentDao;

public interface DaoFactory {

	StudentDao getStudentDao();

	AccountDao getAccountDao();
}
