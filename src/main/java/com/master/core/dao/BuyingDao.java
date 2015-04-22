package com.master.core.dao;

import java.util.List;

import com.master.core.demain.Buying;
import com.master.core.orm.GeneralDAO;
import com.master.core.orm.Page;



public interface BuyingDao extends GeneralDAO<Buying, Long>{




	void updateBuying(Buying buying);

	List<Buying> findAllStockpiles();

	List<Buying> findAllAdditions();

	List<Buying> findAllStockpilesWithRemain();

	Page<Buying> findAllStockpiles(Page<Buying> page);
}
