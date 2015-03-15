package com.master.core.dao.impl;

import java.util.List;

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

	// Sold(卖出)		isSoldToFriend=false && isBrush=false
	@Override
	public List<Selling> findAllSolds() {
		return sessionFactory.getCurrentSession().createQuery("from Selling where soldToFriend=false and brush=false order by id desc").list();
	}

	//Sold to friend(卖给朋友)	isSoldToFriend=true
			
	@Override
	public List<Selling> findAllSoldsToFriend() {
		return sessionFactory.getCurrentSession().createQuery("from Selling where soldToFriend=true order by id desc").list();
	}

	//Brush (刷单)	isBrush=true
	@Override
	public List<Selling> findAllBrushes() {
		return sessionFactory.getCurrentSession().createQuery("from Selling where brush=true order by id desc").list();
	}




}