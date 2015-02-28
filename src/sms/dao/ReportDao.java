package sms.dao;

import java.util.List;

import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;

public interface ReportDao {

	List<VisitorDetailBean> getVisitorDetail();

	List<StaffRegistrationBean> getStaffDetail();
}
