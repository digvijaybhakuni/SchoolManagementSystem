package sms.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sms.dao.AdminDao;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.UserRegistrationBean;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveStaff(StaffRegistrationBean staffRegBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(staffRegBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void registerUser(UserRegistrationBean userRegBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(userRegBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
