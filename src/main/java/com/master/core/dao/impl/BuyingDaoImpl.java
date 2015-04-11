package com.master.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.BuyingDao;
import com.master.core.demain.Buying;


@Repository("BuyingDao")
@Transactional
public class BuyingDaoImpl extends GeneralDAOImpl<Buying, Serializable> implements BuyingDao{

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
	public void updateBuying(Buying buying) {
		Buying b = findById(buying.getId());
		b.setArriveDate(buying.getArriveDate());
		b.setCurrency(buying.getCurrency());
		b.setExchangeRate(buying.getExchangeRate());
		b.setName(buying.getName());
		b.setOrderNumber(buying.getOrderNumber());
		b.setPayer(buying.getPayer());
		b.setQuantity(buying.getQuantity());
		b.setRecordDate(buying.getRecordDate());
		b.setRemain(buying.getRemain());
		b.setStockpile(buying.isStockpile());
		b.setUnitPrice(buying.getUnitPrice());
		b.setComment(buying.getComment());
	}

	@SuppressWarnings("unchecked") 
	@Override
	public List<Buying> findAllStockpiles() {
		return find("from Buying where stockpile=? order by id desc", true);
	}

	@SuppressWarnings("unchecked") 
	@Override
	public List<Buying> findAllAdditions() {
		return find("from Buying where stockpile=? order by id desc", false);
	}

	@SuppressWarnings("unchecked") 
	@Override
	public List<Buying> findAllStockpilesWithRemain() {
		return find("from Buying where stockpile=? and remain>0 order by id desc", true);
	}

}
