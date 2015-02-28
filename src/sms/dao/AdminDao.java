package sms.dao;

import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.UserRegistrationBean;

public interface AdminDao {

	void saveStaff(StaffRegistrationBean staffRegBean);
	
	void registerUser(UserRegistrationBean userRegBean);
}
