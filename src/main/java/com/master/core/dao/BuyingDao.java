package com.master.core.dao;

import java.util.List;

import com.master.core.demain.Buying;



public interface BuyingDao extends GeneralDAO<Buying, Long>{




	void updateBuying(Buying buying);

	List<Buying> findAllStockpiles();

	List<Buying> findAllAdditions();

	List<Buying> findAllStockpilesWithRemain();

	
}
