package com.master.core.dao;

import java.io.Serializable;
import java.util.List;

import com.master.core.demain.Selling;



public interface SellingDao extends GeneralDAO<Selling, Serializable>{

	List<Selling> findAllSolds();

	List<Selling> findAllSoldsToFriend();

	List<Selling> findAllBrushes();

	
}
