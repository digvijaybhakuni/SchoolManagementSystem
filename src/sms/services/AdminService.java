package sms.services;

import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.UserRegistrationBean;

public interface AdminService {

	
	void saveStaff(StaffRegistrationBean staffRegBean);
	void registerUser(UserRegistrationBean userRegBean);
}
