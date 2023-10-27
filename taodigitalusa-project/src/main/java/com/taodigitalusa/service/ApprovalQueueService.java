package com.taodigitalusa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.ApprovalQueue;
import com.taodigitalusa.exception.InvalidIdException;

@Service
public interface ApprovalQueueService {

	public ApprovalQueue save(ApprovalQueue queue);
	
	public ApprovalQueue findById(Integer id);
	
	public ProductApprovalQueue update(Integer id, String approval) throws InvalidIdException;
	
	public List<ApprovalQueue> findAll();
	
	public void deleteById(Integer id);
}
