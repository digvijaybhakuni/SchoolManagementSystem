package sms.dao;

import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StudentFeeBean;

public interface ExpansesDao {

	void saveExpanses(ExpansesHibernateBean objExpBean);
	
	void feeSubmit(StudentFeeBean feeBean);
	
}
