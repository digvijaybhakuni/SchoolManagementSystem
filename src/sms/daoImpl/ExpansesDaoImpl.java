package sms.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sms.dao.ExpansesDao;
import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StudentFeeBean;


@Repository("expansesDao")
public class ExpansesDaoImpl implements ExpansesDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public void saveExpanses(ExpansesHibernateBean objExpBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(objExpBean);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void feeSubmit(StudentFeeBean feeBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(feeBean);
			session.getTransaction().commit();	
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
