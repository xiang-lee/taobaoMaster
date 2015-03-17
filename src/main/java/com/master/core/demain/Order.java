package com.master.core.demain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.master.core.demain.enu.Currency;


@Entity
@Table(name = "tm_order")	
@Inheritance(strategy=InheritanceType.JOINED)
public class Order {
	private long id;
	private String name;
	private Date recordDate;
	private int quantity;
	private Timestamp insertTime = new Timestamp(new java.util.Date().getTime());;
	private double unitPrice;
	private String currency=Currency.euro.getLabel();
	private double exchangeRate;
	private String orderNumber="";
	private String comment="";
	
	
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	@Column(name = "exchange_rate")
	public double getExchangeRate() {
		return exchangeRate;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	public long getId() {
		return id;
	}
	
	@Column(name = "insert_time")
	public Timestamp getInsertTime() {
		return insertTime;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@Column(name = "order_number")
	public String getOrderNumber() {
		return orderNumber;
	}
	
	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}
	
	@Column(name = "record_date")
	public Date getRecordDate() {
		return recordDate;
	}
	
	@Column(name = "unit_price")
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
}
