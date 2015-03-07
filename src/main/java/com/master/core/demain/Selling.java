package com.master.core.demain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "tm_selling")	
@PrimaryKeyJoinColumn(name="order_id")
public class Selling extends Order{
	private double sellUnitPrice;
	private double postage;
	private String sellCurrency="cny";
	private Buying stockpile;
	private double reducedPrice=0;
	private boolean isReceived=false;
	private boolean isRefund=false;
	private boolean isSoldToFriend=false;
	private boolean isBrush=false;
	private boolean isRepayBrushBuyer=false;
	private String buyer;
	private Date deliverDate;
	@Column(name="buyer")
	public String getBuyer() {
		return buyer;
	}
	
	@Column(name="deliver_date")
	public Date getDeliverDate() {
		return deliverDate;
	}
	
	@Column(name="postage")
	public double getPostage() {
		return postage;
	}
	
	@Column(name="reduced_price")
	public double getReducedPrice() {
		return reducedPrice;
	}
	
	@Column(name="sell_currency")
	public String getSellCurrency() {
		return sellCurrency;
	}
	
	@Column(name="sell_unit_price")
	public double getSellUnitPrice() {
		return sellUnitPrice;
	}
	
	@OneToOne(cascade=(CascadeType.PERSIST))
	@JoinColumn(name="stockpile_id")
	public Buying getStockpile() {
		return stockpile;
	}
	
	@Column(name="is_brush")
	public boolean isBrush() {
		return isBrush;
	}
	
	@Column(name="is_received")
	public boolean isReceived() {
		return isReceived;
	}
	
	@Column(name="is_refund")
	public boolean isRefund() {
		return isRefund;
	}
	
	@Column(name="is_repay_brush_buyer")
	public boolean isRepayBrushBuyer() {
		return isRepayBrushBuyer;
	}
	
	@Column(name="is_sold_to_friend")
	public boolean isSoldToFriend() {
		return isSoldToFriend;
	}
	
	public void setBrush(boolean isBrush) {
		this.isBrush = isBrush;
	}
	
	
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public void setPostage(double postage) {
		this.postage = postage;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public void setReducedPrice(double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	public void setRefund(boolean isRefund) {
		this.isRefund = isRefund;
	}
	public void setRepayBrushBuyer(boolean isRepayBrushBuyer) {
		this.isRepayBrushBuyer = isRepayBrushBuyer;
	}
	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}
	public void setSellUnitPrice(double sellUnitPrice) {
		this.sellUnitPrice = sellUnitPrice;
	}
	public void setSoldToFriend(boolean isSoldToFriend) {
		this.isSoldToFriend = isSoldToFriend;
	}
	public void setStockpile(Buying stockpile) {
		this.stockpile = stockpile;
	}
	@Override
	public String toString() {
		return "Selling [sellUnitPrice=" + sellUnitPrice + ", postage="
				+ postage + ", sellCurrency=" + sellCurrency + ", stockpile="
				+ stockpile + ", reducedPrice=" + reducedPrice
				+ ", isReceived=" + isReceived + ", isRefund=" + isRefund
				+ ", isSoldToFriend=" + isSoldToFriend + ", isBrush=" + isBrush
				+ ", isRepayBrushBuyer=" + isRepayBrushBuyer + ", buyer="
				+ buyer + ", deliverDate=" + deliverDate + ", getCurrency()="
				+ getCurrency() + ", getExchangeRate()=" + getExchangeRate()
				+ ", getId()=" + getId() + ", getInsertTime()="
				+ getInsertTime() + ", getName()=" + getName()
				+ ", getOrderNumber()=" + getOrderNumber() + ", getQuantity()="
				+ getQuantity() + ", getRecordDate()=" + getRecordDate()
				+ ", getUnitPrice()=" + getUnitPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
