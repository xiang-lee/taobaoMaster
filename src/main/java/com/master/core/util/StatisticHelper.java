package com.master.core.util;

import java.util.List;

import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.demain.Statistic;

public class StatisticHelper {
	public static Statistic getStatistic(List<Buying> stockpiles,List<Buying> additions, List<Selling> solds,
			List<Selling> soldToFirend) {
		Statistic statistic = new Statistic();
		double totalExpense=0;
		double totalEarning=0;
		
		//stockpiles
		for (Buying s : stockpiles) {
			totalExpense += s.getRemain() * s.getUnitPrice();
		}
		
		
		//additions
		for (Buying a : additions) {
			totalExpense += a.getQuantity() * a.getUnitPrice();
		}
		
		//solds
		for (Selling s : solds) {
			if(!s.isRefund()) {
				totalEarning += s.getQuantity() * s.getSellUnitPrice() + s.getPostage() - s.getReducedPrice();
			}
		}
		
		//soldToFirend
		for (Selling s : soldToFirend) {
			totalEarning += s.getQuantity() * s.getSellUnitPrice() + s.getPostage() - s.getReducedPrice();
		}
		
		
		statistic.setTotalEarning(totalEarning);
		statistic.setTotalExpense(totalExpense);
		
		return statistic;
	}
}
