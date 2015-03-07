package com.master.core.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.SellingDao;
import com.master.core.demain.Selling;


@Repository("SellingDao")
@Transactional
public class SellingDaoImpl implements SellingDao {

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
	public void addSelling(Selling selling) {
		sessionFactory.getCurrentSession().save(selling);
	}

	@Override
	public Selling findById(long id) {
		return (Selling)sessionFactory.getCurrentSession().createQuery("from Selling where id=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public void deleteSelling(Selling selling) {
		sessionFactory.getCurrentSession().delete(selling);
	}




}
