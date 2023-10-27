package com.taodigitalusa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taodigitalusa.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CustomProductRepository {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Product> search(String query) {
		List<Product> list = entityManager.createNativeQuery(query, Product.class).getResultList();
		return list;
	}
}
