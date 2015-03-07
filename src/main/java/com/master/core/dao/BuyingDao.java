package com.master.core.dao;

import com.master.core.demain.Buying;



public interface BuyingDao {

	void addBuying(Buying buying);

	Buying findById(long id);

	void deleteBuying(Buying buying);

	void updateBuying(Buying buying);

	
}
