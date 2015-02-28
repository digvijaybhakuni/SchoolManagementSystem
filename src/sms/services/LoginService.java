package sms.services;

import sms.hibernateBean.UserRegistrationBean;

public interface LoginService {

	boolean validateUser(UserRegistrationBean userBean);
}
