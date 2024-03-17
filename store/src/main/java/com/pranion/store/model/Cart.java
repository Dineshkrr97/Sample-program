package com.pranion.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;
	private int billno;
	private String code;
	private String name;
	private double price;
	private int pquantity;
	private double amount;
	
	public int getSno() {
		return sno;
	}
	public int getBillno() {
		return billno;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getPquantity() {
		return pquantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
