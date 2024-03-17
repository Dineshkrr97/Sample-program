package com.pranion.store.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranion.store.model.Cart;
import com.pranion.store.model.Product;
import com.pranion.store.repo.CartRepo;
import com.pranion.store.repo.StoreRepo;

@Service
public class StoreService {
	@Autowired
	private StoreRepo repo;

	public void save(Product product) {
		 repo.save(product);
		
	}
	
	public List<Product> displayAll(){
		return repo.displayAll();
		
	}
	
	public void updateProduct(double purchaseprice,double sellingprice,int qoh,String productcode) {
		Product product=repo.findByCode(productcode);
//		product.setPurchaseprice(purchaseprice);
//		product.setSellingprice(sellingprice);
		//product.setQoh(product.getQoh()+qoh);
		repo.addQuantity(product.getQoh(),qoh, productcode);
		repo.updatePurchasePrice(purchaseprice, productcode);
		repo.updateSellingPrice(sellingprice, productcode);
		
		//return product;
	}
	public Product findProduct(String productcode) {
		
		return repo.findByCode(productcode);
		
	}
	public Product saleProduct(String productcode,int purchasequantity) {
		System.out.println(productcode);
		Product product=repo.findByCode(productcode);
		product.setQoh(product.getQoh()-purchasequantity);
		return product;
	}
	public double totalAmount(int purchasequantity,String productcode) {
		Product product=repo.findByCode(productcode);
		double amount=purchasequantity*product.getSellingprice();
		return amount;
		
	}
	
	
}
