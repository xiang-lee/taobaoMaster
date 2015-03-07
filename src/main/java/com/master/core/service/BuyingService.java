package com.master.core.service;

import com.master.core.demain.Buying;



public interface BuyingService {

	void addBuying(Buying buying);
	Buying findById(long id);
	void deleteBuying(long id);
	void updateBuying(Buying buying);
}
