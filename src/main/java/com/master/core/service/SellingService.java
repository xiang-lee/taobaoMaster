package com.master.core.service;

import java.util.List;

import com.master.core.demain.Selling;



public interface SellingService {

	void addSelling(Selling selling);
	Selling findById(long id);
	void deleteSelling(long id);
	void updateSelling(Selling selling);
	List<Selling> findAllSolds();
	List<Selling> findAllSoldsToFriend();
	List<Selling> findAllBrushes();
}
