package sms.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sms.dao.LoginDao;
import sms.hibernateBean.UserRegistrationBean;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean validateUser(UserRegistrationBean userBean) {
		
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(UserRegistrationBean.class);
			criteria.add(Restrictions.eq("userName", userBean.getUserName()));
			criteria.add(Restrictions.eq("password", userBean.getPassword()));
			criteria.add(Restrictions.eq("schoolcode", userBean.getSchoolcode()));
			criteria.add(Restrictions.eq("branchCode", userBean.getBranchCode()));
			List lst=criteria.list();
			if(lst!=null && lst.size()>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
