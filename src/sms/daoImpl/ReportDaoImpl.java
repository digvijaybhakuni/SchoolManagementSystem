package sms.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sms.dao.ReportDao;
import sms.hibernateBean.MstSubjectBean;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<VisitorDetailBean> getVisitorDetail() {
		
		return (List<VisitorDetailBean>) sessionFactory.openSession().createCriteria(VisitorDetailBean.class).list();
		
	}

	public List<StaffRegistrationBean> getStaffDetail() {
		
		return (List<StaffRegistrationBean>) sessionFactory.openSession().createCriteria(StaffRegistrationBean.class).list();
	}

}
