package com.taodigitalusa.service;

import java.util.List;

import com.taodigitalusa.dto.SearchIn;
import com.taodigitalusa.entity.Product;

public interface SearchProductService {
	public List<Product> search(SearchIn search);
}
