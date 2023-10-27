package com.taodigitalusa.service;

import java.util.List;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.exception.InvalidIdException;
import com.taodigitalusa.exception.InvalidPriceException;

public interface ProductService {
	
	public ProductApprovalQueue save(Product product) throws InvalidPriceException;
	
	public Product approvedSave(Product product);
	
	public ProductApprovalQueue update(Product product, Integer id) throws InvalidIdException;
	
	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	public ProductApprovalQueue deleteById(Integer id) throws InvalidIdException;
	
}
