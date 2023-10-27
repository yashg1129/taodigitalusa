package com.taodigitalusa.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "queue_history")
public class QueueHistory {

	@Id
	@SequenceGenerator(name = "queue-history", sequenceName = "queue_history_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "queue-history")
	private Integer id;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false, length = 10)
	private String status;

	private boolean approved;

	@Column(nullable = false, length = 10)
	private String action;
	
	@Column(name="posted_date", nullable = false)
	private Date postedDate;
	
	@Column(name="product_id", nullable = true)
	private Integer productId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}
