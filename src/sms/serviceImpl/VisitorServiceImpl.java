package sms.serviceImpl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sms.dao.VisitorDao;
import sms.hibernateBean.VisitorDetailBean;
import sms.services.VisitorService;




@Service("visitorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorDao visitorDao;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveVisitor(VisitorDetailBean objVisitorBean) {
		objVisitorBean.setBranchCode("abc");
		objVisitorBean.setEntryTime(new Date().toString());
		objVisitorBean.setExitTime(new Date().toString());
		visitorDao.saveVisitor(objVisitorBean);
	}

}
