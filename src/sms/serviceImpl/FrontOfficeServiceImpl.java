package sms.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sms.dao.FrontOfficeDao;
import sms.form.MstSubjectForm;
import sms.form.ResultUploadFormBean;
import sms.hibernateBean.MstSubjectBean;
import sms.hibernateBean.ResultBean;
import sms.hibernateBean.StudentAdmission;
import sms.services.FrontOfficeService;

@Service("frontOfficeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FrontOfficeServiceImpl implements FrontOfficeService{

	@Autowired
	FrontOfficeDao frontOfficeDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveStudent(StudentAdmission studentAdmission) {
		frontOfficeDao.saveStudent(studentAdmission);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<MstSubjectForm> getSubjectList(String className) {

		List<MstSubjectBean> lstMstSubjectBean=frontOfficeDao.getSubjectList(className);

		List<MstSubjectForm> lstMstSubjectForm=new ArrayList<MstSubjectForm>();

		Iterator<MstSubjectBean> itr=lstMstSubjectBean.iterator();
		while(itr.hasNext()){

			MstSubjectBean mstSubjectBean=(MstSubjectBean)itr.next();
			MstSubjectForm mstSubjectForm=new MstSubjectForm();	
			mstSubjectForm.setId(mstSubjectBean.getId());
			mstSubjectForm.setClassName(mstSubjectBean.getsClass());
			mstSubjectForm.setSubject(mstSubjectBean.getSubject());
			lstMstSubjectForm.add(mstSubjectForm);
		}
		return lstMstSubjectForm;
	}

	public void saveResult(ResultUploadFormBean resultUploadFormBean) {
		try{
			if(resultUploadFormBean!=null){
				for(int i=0;i<resultUploadFormBean.getSubjectArr().length;i++){
					ResultBean resultBean=new ResultBean();
					int marksObt=Integer.parseInt(resultUploadFormBean.getMarksObtained()[i]);
					int passingMarks=Integer.parseInt(resultUploadFormBean.getPassingMarks()[i]);
					int maxMarks=Integer.parseInt(resultUploadFormBean.getMaxMarks()[i]);
					resultBean.setRegNo(Long.parseLong(resultUploadFormBean.getRegNo()[i]));
					resultBean.setMarksObtn(marksObt);
					resultBean.setPassMarks(passingMarks);
					resultBean.setMaxMarks(maxMarks);
					resultBean.setStatus(resultUploadFormBean.getStatus()[i]);
					resultBean.setsClass(resultUploadFormBean.getStudentClass()[i]);
					resultBean.setSubjectName(resultUploadFormBean.getSubjectArr()[i]);

					frontOfficeDao.saveResult(resultBean);
				}

			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
