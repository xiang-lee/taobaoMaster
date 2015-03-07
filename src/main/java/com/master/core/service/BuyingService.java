package com.master.core.service;

import java.util.List;

import com.master.core.demain.Buying;



public interface BuyingService {

	void addBuying(Buying buying);
	Buying findById(long id);
	void deleteBuying(long id);
	void updateBuying(Buying buying);
	List<Buying> findAllStockpiles();
	List<Buying> findAllAdditions();
}
