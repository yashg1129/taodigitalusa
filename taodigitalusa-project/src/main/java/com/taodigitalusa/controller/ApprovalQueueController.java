package com.taodigitalusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.ApprovalQueue;
import com.taodigitalusa.exception.InvalidIdException;
import com.taodigitalusa.service.ApprovalQueueService;

@RestController
@RequestMapping("api/products/approval-queue")
public class ApprovalQueueController {

	@Autowired
	private ApprovalQueueService queueService;
	
	
	
	@GetMapping
	public List<ApprovalQueue> findAll() {
		return queueService.findAll();
	}
	
	@PutMapping("/{id}/{approval}")
	public ProductApprovalQueue update(@PathVariable("id") Integer id, @PathVariable("approval") String approval) throws InvalidIdException {
		return queueService.update(id, approval);
	}
}
