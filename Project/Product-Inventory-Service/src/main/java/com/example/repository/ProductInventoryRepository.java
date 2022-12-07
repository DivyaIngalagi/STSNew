package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Product;



@Repository
public interface ProductInventoryRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
	@Query(value = "select * from product_details p where p.prod_qty<10",nativeQuery = true)
	List<Product> getLowStockProduct();
}
