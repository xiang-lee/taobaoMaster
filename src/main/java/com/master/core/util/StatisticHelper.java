package com.master.core.util;

import java.util.List;

import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.demain.Statistic;
import com.master.core.demain.enu.Currency;

public class StatisticHelper {
	public static Statistic getStatistic(List<Buying> stockpiles,List<Buying> additions, List<Selling> solds,
			List<Selling> soldToFirend) {
		Statistic statistic = new Statistic();
		//囤货总支出
		double stockpileRemainExpenseEuro=0;
		double stockpileRemainExpenseCny=0;
		//卖出总支出
		double soldExpenseEuro=0;
		double soldExpenseCny=0;
		//朋友卖出总支出
		double soldToFriendExpenseEuro=0;
		double soldToFriendExpenseCny=0;
		
		//附加总支出 
		double addtionExpenseEuro=0;
		double addtionExpenseCny=0;
		
		//卖出总收入
		double soldEarning=0;
		//朋友卖出总收入
		double soldToFriendEarning=0;
		
		
		//囤货总支出
		for (Buying s : stockpiles) {
			double price = s.getRemain() * s.getUnitPrice();
			if(Currency.euro.getLabel().equals(s.getCurrency())) {
				stockpileRemainExpenseEuro += price;
			}
			else {
				stockpileRemainExpenseCny += price;
			}
		}
		
		//卖出总支出
		for (Selling s : solds) {
			if(s.isRefund()) continue;
			double price = s.getQuantity() * s.getUnitPrice();
			if(Currency.euro.getLabel().equals(s.getCurrency())) {
				soldExpenseEuro += price;
			}
			else {
				soldExpenseCny += price;
			}
		}
		
		//朋友卖出总支出
		for (Selling s : soldToFirend) {
			if(s.isRefund()) continue;
			double price = s.getQuantity() * s.getUnitPrice();
			if(Currency.euro.getLabel().equals(s.getCurrency())) {
				soldToFriendExpenseEuro += price;
			}
			else {
				soldToFriendExpenseCny += price;
			}
		}
		
		//附加总支出 
		for (Buying a : additions) {
			double price = a.getQuantity() * a.getUnitPrice();
			if(Currency.euro.getLabel().equals(a.getCurrency())) {
				addtionExpenseEuro += price;
			}
			else {
				addtionExpenseCny += price;
			}
		}

		//卖出总收入
		for (Selling s : solds) {
			if(s.isRefund()) continue;
			double price = s.getQuantity() * s.getSellUnitPrice() + s.getPostage() - s.getReducedPrice();
			soldEarning += price;
		}
		
		//朋友卖出总收入
		for (Selling s : soldToFirend) {
			if(s.isRefund()) continue;
			double price = s.getQuantity() * s.getSellUnitPrice() + s.getPostage() - s.getReducedPrice();
			soldToFriendEarning += price;
		}
		statistic.setStockpileRemainExpenseEuro(stockpileRemainExpenseEuro);
		statistic.setStockpileRemainExpenseCny(stockpileRemainExpenseCny);
		
		statistic.setSoldExpenseEuro(soldExpenseEuro);
		statistic.setSoldExpenseCny(soldExpenseCny);
		
		statistic.setSoldToFriendExpenseEuro(soldToFriendExpenseEuro);
		statistic.setSoldToFriendExpenseCny(soldToFriendExpenseCny);
		
		statistic.setAddtionExpenseEuro(addtionExpenseEuro);
		statistic.setAddtionExpenseCny(addtionExpenseCny);
		
		statistic.setSoldEarning(soldEarning);
		statistic.setSoldToFriendEarning(soldToFriendEarning);
		
		
		
		return statistic;
	}
}
