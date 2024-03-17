package com.pranion.store.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pranion.store.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

	@Query(value="select * from cart",nativeQuery = true)
	List<Cart> displayAll();
	
	@Query(value="select * from cart where billno=?1",nativeQuery = true)
	List<Cart> displaybyBill(int billno);
	
	
	@Query(value="select sum(amount) from cart group by billno having billno=?1",nativeQuery = true)
	double totalAmount(int billno);
}
