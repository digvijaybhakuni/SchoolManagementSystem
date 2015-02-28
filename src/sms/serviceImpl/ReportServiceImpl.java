package sms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sms.dao.ReportDao;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;
import sms.services.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportDao reportDao;
	
	public List<VisitorDetailBean> getVisitorDetail() {
		return reportDao.getVisitorDetail();
	}

	public List<StaffRegistrationBean> getStaffDetail() {
		
		return reportDao.getStaffDetail();
	}

}
