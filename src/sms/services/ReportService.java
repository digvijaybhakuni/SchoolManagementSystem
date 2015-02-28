package sms.services;

import java.util.List;

import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;

public interface ReportService {

	List<VisitorDetailBean> getVisitorDetail();
	
	List<StaffRegistrationBean> getStaffDetail();
}
