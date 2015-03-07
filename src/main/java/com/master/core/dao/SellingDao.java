package com.master.core.dao;

import java.util.List;

import com.master.core.demain.Selling;



public interface SellingDao {

	void addSelling(Selling selling);

	Selling findById(long id);

	void deleteSelling(Selling selling);

	List<Selling> findAllSolds();

	List<Selling> findAllSoldsToFriend();

	List<Selling> findAllBrushes();

	
}
