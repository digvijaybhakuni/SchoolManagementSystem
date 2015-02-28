package sms.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sms.dao.VisitorDao;
import sms.hibernateBean.VisitorDetailBean;


@Repository("visitorDao")
public class VisitorDaoImpl implements VisitorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public void saveVisitor(VisitorDetailBean objVisitorBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(objVisitorBean);
	}

}
