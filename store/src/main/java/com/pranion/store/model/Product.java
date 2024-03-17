package com.pranion.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private String productcode;
	private String productname;
	private double purchaseprice;
	private double sellingprice;
	private int qoh;
	public String getProductcode() {
		return productcode;
	}
	public String getProductname() {
		return productname;
	}
	public double getPurchaseprice() {
		return purchaseprice;
	}
	public double getSellingprice() {
		return sellingprice;
	}
	public int getQoh() {
		return qoh;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
}

