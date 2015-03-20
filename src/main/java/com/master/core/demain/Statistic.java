package com.master.core.demain;

public class Statistic {
	//囤货总支出
	private double stockpileRemainExpenseEuro;
	private double stockpileRemainExpenseCny;
	//卖出总支出
	private double soldExpenseEuro;
	private double soldExpenseCny;
	//朋友卖出总支出
	private double soldToFriendExpenseEuro;
	private double soldToFriendExpenseCny;
	//附加总支出
	private double addtionExpenseEuro;
	private double addtionExpenseCny;
	
	//卖出总收入
	private double soldEarning;
	//朋友卖出总收入
	private double soldToFriendEarning;
	
	public double getAddtionExpenseCny() {
		return addtionExpenseCny;
	}
	public double getAddtionExpenseEuro() {
		return addtionExpenseEuro;
	}
	public double getSoldEarning() {
		return soldEarning;
	}
	public double getSoldExpenseCny() {
		return soldExpenseCny;
	}
	public double getSoldExpenseEuro() {
		return soldExpenseEuro;
	}
	public double getSoldToFriendEarning() {
		return soldToFriendEarning;
	}
	public double getSoldToFriendExpenseCny() {
		return soldToFriendExpenseCny;
	}
	public double getSoldToFriendExpenseEuro() {
		return soldToFriendExpenseEuro;
	}
	public double getStockpileRemainExpenseCny() {
		return stockpileRemainExpenseCny;
	}
	public double getStockpileRemainExpenseEuro() {
		return stockpileRemainExpenseEuro;
	}
	public void setAddtionExpenseCny(double addtionExpenseCny) {
		this.addtionExpenseCny = addtionExpenseCny;
	}
	public void setAddtionExpenseEuro(double addtionExpenseEuro) {
		this.addtionExpenseEuro = addtionExpenseEuro;
	}
	public void setSoldEarning(double soldEarning) {
		this.soldEarning = soldEarning;
	}
	public void setSoldExpenseCny(double soldExpenseCny) {
		this.soldExpenseCny = soldExpenseCny;
	}
	public void setSoldExpenseEuro(double soldExpenseEuro) {
		this.soldExpenseEuro = soldExpenseEuro;
	}
	public void setSoldToFriendEarning(double soldToFriendEarning) {
		this.soldToFriendEarning = soldToFriendEarning;
	}
	public void setSoldToFriendExpenseCny(double soldToFriendExpenseCny) {
		this.soldToFriendExpenseCny = soldToFriendExpenseCny;
	}
	public void setSoldToFriendExpenseEuro(double soldToFriendExpenseEuro) {
		this.soldToFriendExpenseEuro = soldToFriendExpenseEuro;
	}
	public void setStockpileRemainExpenseCny(double stockpileRemainExpenseCny) {
		this.stockpileRemainExpenseCny = stockpileRemainExpenseCny;
	}
	public void setStockpileRemainExpenseEuro(double stockpileRemainExpenseEuro) {
		this.stockpileRemainExpenseEuro = stockpileRemainExpenseEuro;
	}
	@Override
	public String toString() {
		return "Statistic [stockpileRemainExpenseEuro="
				+ stockpileRemainExpenseEuro + ", stockpileRemainExpenseCny="
				+ stockpileRemainExpenseCny + ", soldExpenseEuro="
				+ soldExpenseEuro + ", soldExpenseCny=" + soldExpenseCny
				+ ", soldToFriendExpenseEuro=" + soldToFriendExpenseEuro
				+ ", soldToFriendExpenseCny=" + soldToFriendExpenseCny
				+ ", addtionExpenseEuro=" + addtionExpenseEuro
				+ ", addtionExpenseCny=" + addtionExpenseCny + ", soldEarning="
				+ soldEarning + ", soldToFriendEarning=" + soldToFriendEarning
				+ "]";
	}
}
