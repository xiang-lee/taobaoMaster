package com.master.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.master.core.dao.StatisticDao;
import com.master.core.demain.Statistic;
import com.master.core.service.StatisticService;


@Transactional
public class StatisticServiceImpl implements StatisticService{
	
	@Autowired
	private StatisticDao statisticDao;

	@Override
	public Statistic findStatistic() {
		return statisticDao.findStatistic();
	}


}
