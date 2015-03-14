package com.master.core.dao.impl;

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
public class BuyingDaoImpl implements BuyingDao {

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
	public void addBuying(Buying buying) {
		sessionFactory.getCurrentSession().save(buying);
	}

	@Override
	public Buying findById(long id) {
		return (Buying) sessionFactory.getCurrentSession().createQuery("from Buying where id=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Override
	public void deleteBuying(Buying buying) {
		sessionFactory.getCurrentSession().delete(buying);
	}

	@Override
	public void updateBuying(Buying buying) {
		Buying b = (Buying)sessionFactory.getCurrentSession().createQuery("from Buying where id=:id")
				.setParameter("id", buying.getId()).uniqueResult();
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
	}

	@Override
	public List<Buying> findAllStockpiles() {
		return sessionFactory.getCurrentSession().createQuery("from Buying where stockpile=true order by id desc").list();
	}

	@Override
	public List<Buying> findAllAdditions() {
		return sessionFactory.getCurrentSession().createQuery("from Buying where stockpile=false order by id desc").list();
	}

	@Override
	public List<Buying> findAllStockpilesWithRemain() {
		return sessionFactory.getCurrentSession().createQuery("from Buying where stockpile=true and remain>0 order by id desc").list();
	}

	


}
