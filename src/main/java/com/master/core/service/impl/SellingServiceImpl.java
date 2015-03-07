package com.master.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.SellingDao;
import com.master.core.demain.Selling;
import com.master.core.service.SellingService;


@Transactional
public class SellingServiceImpl implements SellingService{
	
	@Autowired
	private SellingDao sellingDao;

	@Override
	public void addSelling(Selling selling) {
		sellingDao.addSelling(selling);
	}

	@Override
	public Selling findById(long id) {
		return sellingDao.findById(id);
	}

	@Override
	public void deleteSelling(long id) {
		sellingDao.deleteSelling(sellingDao.findById(id));
	}

	@Override
	public void updateSelling(Selling newSelling) {
		Selling s = sellingDao.findById(newSelling.getId());
		if(s ==null) return;
		s.setBrush(newSelling.isBrush());
		s.setBuyer(newSelling.getBuyer());
		s.setCurrency(newSelling.getCurrency());
		s.setDeliverDate(newSelling.getDeliverDate());
		s.setExchangeRate(newSelling.getExchangeRate());
		s.setName(newSelling.getName());
		s.setOrderNumber(newSelling.getOrderNumber());
		s.setPostage(newSelling.getPostage());
		s.setQuantity(newSelling.getQuantity());
		s.setReceived(newSelling.isReceived());
		s.setRecordDate(newSelling.getRecordDate());
		s.setReducedPrice(newSelling.getReducedPrice());
		s.setRefund(newSelling.isRefund());
		s.setRepayBrushBuyer(newSelling.isRepayBrushBuyer());
		s.setSellCurrency(newSelling.getSellCurrency());
		s.setSellUnitPrice(newSelling.getSellUnitPrice());
		s.setSoldToFriend(newSelling.isSoldToFriend());
		s.setStockpile(newSelling.getStockpile());
		s.setUnitPrice(newSelling.getUnitPrice());
	}


	

}
