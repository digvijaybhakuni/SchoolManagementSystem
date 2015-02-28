package sms.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sms.dao.FrontOfficeDao;
import sms.hibernateBean.MstSubjectBean;
import sms.hibernateBean.ResultBean;
import sms.hibernateBean.StudentAdmission;

@Repository("frontOfficeDao")
public class FrontOffceDaoImpl implements FrontOfficeDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	public void saveStudent(StudentAdmission studentAdmission) {
		sessionFactory.getCurrentSession().saveOrUpdate(studentAdmission);
		
	}

	@SuppressWarnings("unchecked")
	public List<MstSubjectBean> getSubjectList(String className) {
	
		return (List<MstSubjectBean>) sessionFactory.getCurrentSession().createCriteria(MstSubjectBean.class).list();
	}

	public void saveResult(ResultBean resultBean) {
		try {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(resultBean);
		session.getTransaction().commit();
		
			//sessionFactory.openSession().saveOrUpdate(resultBean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//sessionFactory.getCurrentSession().saveOrUpdate(resultBean);
		
	}

	
	
	
	
	
	
}

