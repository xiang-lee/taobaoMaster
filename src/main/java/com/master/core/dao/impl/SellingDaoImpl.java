package com.master.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.SellingDao;
import com.master.core.demain.Selling;


@Repository("SellingDao")
@Transactional
public class SellingDaoImpl extends GeneralDAOImpl<Selling, Long> implements SellingDao{

	public SellingDaoImpl() {
		super(Selling.class);
	}

	// Sold(卖出)		isSoldToFriend=false && isBrush=false
	@SuppressWarnings("unchecked")
	@Override
	public List<Selling> findAllSolds() {
		return find("from Selling where soldToFriend=false and brush=false order by id desc");
	}

	//Sold to friend(卖给朋友)	isSoldToFriend=true
	@SuppressWarnings("unchecked")
	@Override
	public List<Selling> findAllSoldsToFriend() {
		return find("from Selling where soldToFriend=true order by id desc");
	}

	//Brush (刷单)	isBrush=true
	@SuppressWarnings("unchecked")
	@Override
	public List<Selling> findAllBrushes() {
		return find("from Selling where brush=true order by id desc");
	}




}
