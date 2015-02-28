package sms.dao;

import java.util.List;

import sms.form.AdmissionForm;
import sms.hibernateBean.MstSubjectBean;
import sms.hibernateBean.ResultBean;
import sms.hibernateBean.StudentAdmission;

public interface FrontOfficeDao {

	
	void saveStudent(StudentAdmission studentAdmission);
	
	List<MstSubjectBean> getSubjectList(String className);
	
	void saveResult(ResultBean resultBean);
}
