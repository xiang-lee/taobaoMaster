package com.master.core.dao;

import com.master.core.demain.Selling;



public interface SellingDao {

	void addSelling(Selling selling);

	Selling findById(long id);

	void deleteSelling(Selling selling);

	
}
