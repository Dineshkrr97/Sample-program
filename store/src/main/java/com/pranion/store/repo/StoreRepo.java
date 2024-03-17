package com.pranion.store.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pranion.store.model.Product;
@Repository
public interface StoreRepo extends JpaRepository<Product, String>{
	
	@Query(value="select * from product",nativeQuery = true)
	List<Product> displayAll();
	@Transactional
	@Modifying
	@Query(value="update product set qoh = ?1+?2 where productcode=?3",nativeQuery = true)
	void addQuantity(int oldqoh,int qoh,String code);
	@Transactional
	@Modifying
	@Query(value="update product set purchaseprice =?1 where productcode=?2",nativeQuery = true)
	void updatePurchasePrice(double purchaseprice,String code);
	@Transactional
	@Modifying
	@Query(value="update product set sellingprice =?1 where productcode=?2",nativeQuery = true)
	void  updateSellingPrice(double sellingprice,String code);
	
	@Query(value="select * from product where productcode=?1",nativeQuery = true)
	Product findByCode(String code);

	
	

}
