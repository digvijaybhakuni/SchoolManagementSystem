package sms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sms.form.MstSubjectForm;
import sms.form.ResultUploadFormBean;
import sms.hibernateBean.MstSubjectBean;
import sms.hibernateBean.StudentAdmission;


public interface FrontOfficeService {

	void saveStudent(StudentAdmission studentAdmission);
	
	List<MstSubjectForm> getSubjectList(String className);
	
	void saveResult(ResultUploadFormBean resultUploadFormBean);
}
