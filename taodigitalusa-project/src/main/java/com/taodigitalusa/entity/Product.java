package com.taodigitalusa.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@SequenceGenerator(name="product", sequenceName = "products_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "product")
	private Integer id;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false, length = 10)
	private String status;
	
	@Column(name = "posted_date", nullable = false)
	private Date postedDate;
	
	@Column(name = "update_date", nullable = false)
	private Date updatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
