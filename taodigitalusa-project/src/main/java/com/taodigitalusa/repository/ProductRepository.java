package com.taodigitalusa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taodigitalusa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.status='active' order by p.updatedDate desc")
	public List<Product> findAll();
}
