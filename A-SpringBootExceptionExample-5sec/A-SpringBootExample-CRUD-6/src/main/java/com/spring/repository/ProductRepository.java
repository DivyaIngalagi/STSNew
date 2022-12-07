package com.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Transactional
	@Modifying
	@Query("update Product p set p.productPrice=:x where p.productId=:y")
	int updateProductPrice(@Param(value="x")double productprice,@Param(value="y")long id);
}
