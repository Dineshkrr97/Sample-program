package com.pranion.store.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pranion.store.model.Product;
import com.pranion.store.model.Cart;
import com.pranion.store.service.CartService;
import com.pranion.store.service.StoreService;

@Controller
public class StoreController {
	@Autowired
	private StoreService service;
	
	@Autowired
	private CartService cartserv;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/addproduct")
	public String addProduct(Model model) {
		Product product=new Product();
		model.addAttribute("product", product);
		return "addproduct";
		
	}
	@PostMapping("/save")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		ModelAndView mav=new ModelAndView("save.html");
	    service.save(product);
	    mav.addObject("product", product);
	    return mav;
			
	}
	@GetMapping("/display")
	public ModelAndView displayProduct() {
		ModelAndView mav=new ModelAndView("viewproduct.html");
	    List<Product> product=service.displayAll();
	    mav.addObject("product", product);
	    return mav;
			
	}
	@GetMapping("/purchaseproduct")
	public String updateProduct() {
		
		return "update";
	}
		
	@PostMapping("/beforeupdate")
	public ModelAndView purchaseProduct(@RequestParam String productcode) {
		ModelAndView mav=new ModelAndView("update.html");
	   Product product=service.findProduct(productcode);
	    mav.addObject("product", product);
	    return mav;
			
	}
	
	@PostMapping("/afterupdate")
	public String update(@RequestParam String productcode,@RequestParam double purchaseprice,@RequestParam double sellingprice,@RequestParam int qoh) {
	 
		service.updateProduct(purchaseprice, sellingprice, qoh, productcode);
	  
	  // service.save(product);
	    return "update";
			
	}
	@GetMapping("/saleproduct")
	public String saleProduct() {
		
		return "sale";
	}
	
	@PostMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam String productcode) {
		ModelAndView mav = new ModelAndView("viewcart.html");
		Product product = service.findProduct(productcode);
		mav.addObject("product", product);
		return mav;

	}
		
	@PostMapping("/sale")
	public String sale(@RequestParam String productcode,@RequestParam int purchasequantity,@RequestParam int billno/*,@RequestParam int sno*/) {
		
		Product product = service.saleProduct(productcode, purchasequantity);
		double amount = service.totalAmount(purchasequantity,productcode);
		cartserv.saveCart(product.getProductcode(),product.getProductname(),product.getSellingprice(),purchasequantity,amount,billno);
		return "sale";

	}
	@GetMapping("/tofindbillno")
	public String tofindbillno() {
		
	    return "saleproducts";
			
	}
	
	@PostMapping("/displaysaleProducts")
	public ModelAndView displayCartProducts(@RequestParam int billno) {
		ModelAndView mav=new ModelAndView("saleproducts.html");
		List<Cart> bill=cartserv.displayByBillNo(billno);
		double Total=cartserv.displayTotal(billno);
		mav.addObject("bill", bill);
		mav.addObject("Total",Total);
	    return mav;
			
	}
	
	
	
	/*
	@PostMapping("/savecart")
	public String savecart(@ModelAttribute("productcode") String code,@ModelAttribute("productname") String name,@ModelAttribute("sellingprice") double price,
			@ModelAttribute("qoh") int quantity,@ModelAttribute("cartno") int cartno) {
		cartserv.saveCart(cartno,code,name,price,quantity);
	    return "sale";

	}
	@PostMapping("/tosale")
	public void tosale(@RequestParam("code") String productcode) {
		ModelAndView mav = new ModelAndView("displaycart.html");
		Product product = service.findProduct(productcode);
		System.out.println(product);
		
	}
	*/

}
