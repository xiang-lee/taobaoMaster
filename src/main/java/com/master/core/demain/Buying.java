package com.master.core.demain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tm_buying")	
@PrimaryKeyJoinColumn(name="order_id")
public class Buying extends Order{
	private String payer;
	private Date arriveDate = Date.valueOf( "2015-01-01" );
	private int remain;
	private boolean isStockpile;
	@Column(name = "arrive_date")
	public Date getArriveDate() {
		return arriveDate;
	}
	
	
	@Column(name = "payer")
	public String getPayer() {
		return payer;
	}
	@Column(name = "remain")
	public int getRemain() {
		return remain;
	}
	@Column(name = "is_stockpile")
	public boolean isStockpile() {
		return isStockpile;
	}
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	
	
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public void setStockpile(boolean isStockpile) {
		this.isStockpile = isStockpile;
	}
	@Override
	public String toString() {
		return "Buying [payer=" + payer + ", arriveDate=" + arriveDate
				+ ", remain=" + remain + ", isStockpile=" + isStockpile
				+ ", getCurrency()=" + getCurrency() + ", getExchangeRate()="
				+ getExchangeRate() + ", getId()=" + getId()
				+ ", getInsertTime()=" + getInsertTime() + ", getName()="
				+ getName() + ", getOrderNumber()=" + getOrderNumber()
				+ ", getQuantity()=" + getQuantity() + ", getRecordDate()="
				+ getRecordDate() + ", getUnitPrice()=" + getUnitPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
}
