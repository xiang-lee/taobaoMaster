package com.master.core.dao;

import java.util.List;

import com.master.core.demain.Buying;



public interface BuyingDao {

	void addBuying(Buying buying);

	Buying findById(long id);

	void deleteBuying(Buying buying);

	void updateBuying(Buying buying);

	List<Buying> findAllStockpiles();

	List<Buying> findAllAdditions();

	List<Buying> findAllStockpilesWithRemain();

	
}
