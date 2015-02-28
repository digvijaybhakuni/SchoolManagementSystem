package sms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sms.dao.ExpansesDao;
import sms.daoImpl.ExpansesDaoImpl;
import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StudentFeeBean;
import sms.services.ExpansesService;



@Service("expansesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExpansesServiceImpl implements ExpansesService{

	@Autowired
	ExpansesDao expansesDao;
	

	public void saveExpanses(ExpansesHibernateBean objExpBean) {
		expansesDao.saveExpanses(objExpBean);
		
	}


	public void feeSubmit(StudentFeeBean feeBean) {
		expansesDao.feeSubmit(feeBean);
		
	}

}
