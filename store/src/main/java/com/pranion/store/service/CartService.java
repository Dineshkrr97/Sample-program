package com.pranion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranion.store.model.Cart;
import com.pranion.store.repo.CartRepo;

@Service
public class CartService {
	@Autowired
	private CartRepo crepo;
	
	public void saveCart(Cart product) {
		 crepo.save(product);
		
	}
	
	public List<Cart> displayAllcart(){
		return crepo.displayAll();
		
	}

	
	public void saveCart(String productcode, String productname, double sellingprice, int purchasequantity,
			double amount,int billno) {
		Cart cart=new Cart();
		cart.setBillno(billno);
		//cart.setSno(sno);
		cart.setCode(productcode);
		cart.setName(productname);
		cart.setPrice(sellingprice);
		cart.setPquantity(purchasequantity);
		cart.setAmount(amount);
		crepo.save(cart);
		
	}
	public List<Cart> displayByBillNo(int billno){
		return crepo.displaybyBill(billno);
		
	}
	public double displayTotal(int billno) {
		return crepo.totalAmount(billno);
		
	}

}
