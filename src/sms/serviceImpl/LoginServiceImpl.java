package sms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sms.dao.LoginDao;
import sms.daoImpl.LoginDaoImpl;
import sms.hibernateBean.UserRegistrationBean;
import sms.services.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	public boolean validateUser(UserRegistrationBean userBean) {
		
		return loginDao.validateUser(userBean);
	}

	
}
