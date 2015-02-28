package sms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sms.dao.AdminDao;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.UserRegistrationBean;
import sms.services.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void saveStaff(StaffRegistrationBean staffRegBean) {
		adminDao.saveStaff(staffRegBean);
		
	}

	public void registerUser(UserRegistrationBean userRegBean) {

		adminDao.registerUser(userRegBean);
		
	}

}
