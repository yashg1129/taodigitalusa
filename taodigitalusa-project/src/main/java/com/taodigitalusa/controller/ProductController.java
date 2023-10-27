package com.taodigitalusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.exception.InvalidIdException;
import com.taodigitalusa.exception.InvalidPriceException;
import com.taodigitalusa.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ProductApprovalQueue save(@RequestBody Product product) throws InvalidPriceException {
		return productService.save(product);
	}
	
	@PutMapping("/{id}")
	public ProductApprovalQueue update(@RequestBody Product product, @PathVariable("id") Integer id) throws InvalidIdException {
		return productService.update(product, id);
	}
	
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public ProductApprovalQueue delete(@PathVariable("id") Integer id) throws InvalidIdException {
		return productService.deleteById(id);
	}
}
