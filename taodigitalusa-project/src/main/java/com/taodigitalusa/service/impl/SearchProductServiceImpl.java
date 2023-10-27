package com.taodigitalusa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taodigitalusa.dto.SearchProduct;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.repository.CustomProductRepository;
import com.taodigitalusa.service.SearchProductService;

import io.micrometer.common.util.StringUtils;

@Service
public class SearchProductServiceImpl implements SearchProductService {

	private static final String _23_59_59 = " 23:59:59";
	private static final String _00_00_00 = " 00:00:00";
	
	@Autowired
	private CustomProductRepository repo;
	
	@Override
	public List<Product> search(SearchProduct search) {
		StringBuilder query = new StringBuilder("select * from products p ");
		StringBuilder condition = new StringBuilder();
		
		if(StringUtils.isNotEmpty(search.getProductName())) {
			condition.append("p.name='").append(search.getProductName()).append("'");
		}
		
		if(search.getMinPrice() != 0.0) {
			andAppened(condition);
			condition.append("p.price >=").append(search.getMinPrice());
		}
		
		if(search.getMaxPrice() != 0.0) {
			andAppened(condition);
			condition.append("p.price <=").append(search.getMaxPrice());
		}
		
		if(StringUtils.isNotEmpty(search.getMinPostedDate()) && StringUtils.isNotEmpty(search.getMaxPostedDate())) {
			andAppened(condition);
			condition.append("p.posted_date > '").append(search.getMinPostedDate()).append(_00_00_00).append("'")
			.append(" AND ").append("p.posted_Date < '").append(search.getMaxPostedDate()).append(_23_59_59).append("'");
		} else if(StringUtils.isNotEmpty(search.getMinPostedDate())) {
			andAppened(condition);
			condition.append("p.posted_date > '").append(search.getMinPostedDate()).append("'");
		} else if(StringUtils.isNotEmpty(search.getMaxPostedDate())) {
			andAppened(condition);
			condition.append("p.posted_Date < '").append(search.getMaxPostedDate()).append("'");
		}
		
		if(!condition.isEmpty()) {
			query.append(" WHERE ").append(condition);
		}
		
		System.out.println(query.toString());
		
		return repo.search(query.toString());
	}

	private void andAppened(StringBuilder condition) {
		if(!condition.isEmpty()) {
			condition.append(" AND ");
		}
	}

}
