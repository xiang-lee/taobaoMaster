package com.master.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.BuyingDao;
import com.master.core.demain.Buying;
import com.master.core.service.BuyingService;


@Transactional
public class BuyingServiceImpl implements BuyingService{
	
	@Autowired
	private BuyingDao buyingDao;

	@Override
	public void addBuying(Buying buying) {
		buyingDao.addBuying(buying);
	}

	@Override
	public Buying findById(long id) {
		return buyingDao.findById(id);
	}

	@Override
	public void deleteBuying(long id) {
		Buying buying = buyingDao.findById(id);
		if(buying != null) buyingDao.deleteBuying(buying);
	}

	@Override
	public void updateBuying(Buying buying) {
		buyingDao.updateBuying(buying);
	}

	@Override
	public List<Buying> findAllStockpiles() {
		return buyingDao.findAllStockpiles();
	}

	@Override
	public List<Buying> findAllAdditions() {
		return buyingDao.findAllAdditions();
	}

	

}
