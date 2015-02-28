package sms.dao;

import sms.hibernateBean.UserRegistrationBean;

public interface LoginDao {

	boolean validateUser(UserRegistrationBean userBean);
}
