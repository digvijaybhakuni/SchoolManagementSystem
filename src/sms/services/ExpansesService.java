package sms.services;

import sms.form.FeeFormBean;
import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StudentFeeBean;

public interface ExpansesService {

	
	void saveExpanses(ExpansesHibernateBean objExpBean);
	
	void feeSubmit(StudentFeeBean feeBean);
}
