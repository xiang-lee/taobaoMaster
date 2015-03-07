package com.master.core.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.UserDao;
import com.master.core.demain.User;


@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
	return  (User)sessionFactory.getCurrentSession().createQuery("from User where username=:username").
			setParameter("username", username).uniqueResult();
	}
	
	@Override
	@Transactional(readOnly=true)
	public User findById(long id) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where id=:id")
				.setParameter("id", id).uniqueResult();
	}


}
