package com.master.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.StatisticDao;
import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.demain.Statistic;
import com.master.core.util.StatisticHelper;


@Repository("StatisticDao")
@Transactional
public class StatisticDaoImpl implements StatisticDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * 
	 * Five types of Order:
	 * 
	 * Buying: 
	 * 1. stockpile (囤货) 			isStockpile=true
	 * 2. Addition (附加) 			isStockpile=false
	 * 
	 * Selling: 
	 * 3. Sold(卖出) 					isSoldToFriend=false && isBrush=false
	 * 4.Sold to friend(卖给朋友) 		isSoldToFriend=true
	 * 5. Brush (刷单) 				isBrush=true
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Statistic findStatistic() {
		//Find five types of order
		List<Buying> stockpiles = sessionFactory.getCurrentSession().createQuery("from Buying where stockpile=true").list();
		List<Buying> additions = sessionFactory.getCurrentSession().createQuery("from Buying where stockpile=false").list();
		List<Selling> solds = sessionFactory.getCurrentSession().createQuery("from Selling where soldToFriend=false and brush=false").list();
		List<Selling> soldToFirend = sessionFactory.getCurrentSession().createQuery("from Selling where soldToFriend=true").list();
		Statistic statistic = StatisticHelper.getStatistic(stockpiles, additions, solds, soldToFirend);
		return statistic;
	}




}
