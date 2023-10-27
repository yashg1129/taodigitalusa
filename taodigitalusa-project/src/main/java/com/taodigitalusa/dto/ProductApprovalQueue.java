package com.taodigitalusa.dto;

import com.taodigitalusa.entity.ApprovalQueue;
import com.taodigitalusa.entity.Product;

public class ProductApprovalQueue {

	private Product product;
	private ApprovalQueue approvalQueue;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ApprovalQueue getApprovalQueue() {
		return approvalQueue;
	}

	public void setApprovalQueue(ApprovalQueue approvalQueue) {
		this.approvalQueue = approvalQueue;
	}

}
