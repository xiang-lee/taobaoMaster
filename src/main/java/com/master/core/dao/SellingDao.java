package com.master.core.dao;

import java.util.List;

import com.master.core.demain.Selling;
import com.master.core.orm.GeneralDAO;



public interface SellingDao extends GeneralDAO<Selling, Long>{

	List<Selling> findAllSolds();

	List<Selling> findAllSoldsToFriend();

	List<Selling> findAllBrushes();

	
}
