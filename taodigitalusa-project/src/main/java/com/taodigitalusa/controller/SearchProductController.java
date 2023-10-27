package com.taodigitalusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taodigitalusa.dto.SearchProduct;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.service.SearchProductService;

@RestController
@RequestMapping("/api/products/search")
public class SearchProductController {

	@Autowired
	private SearchProductService searchProductService;
	
	/**
	 * 
	 * @param 
	 * {
	 *   productName: String,
	 *   minPrice: double
	 *   maxPrice: double
	 *   minPostedDate: dd-mm-yyyy
	 *   maxPostedDate: dd-mm-yyyy	
	 * }
	 * @return
	 */
	@GetMapping
	public List<Product> search(@RequestBody SearchProduct search) {
		return searchProductService.search(search);
	}
}
