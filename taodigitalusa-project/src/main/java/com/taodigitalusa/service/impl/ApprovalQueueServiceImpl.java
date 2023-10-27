package com.taodigitalusa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.ApprovalQueue;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.entity.QueueHistory;
import com.taodigitalusa.exception.InvalidIdException;
import com.taodigitalusa.repository.ApprovalQueueRepository;
import com.taodigitalusa.repository.ProductRepository;
import com.taodigitalusa.repository.QueueHistoryRepository;
import com.taodigitalusa.service.ApprovalQueueService;
import com.taodigitalusa.utils.TaoConstants;

import jakarta.transaction.Transactional;

@Service
public class ApprovalQueueServiceImpl implements ApprovalQueueService {

	private static final String APPROVAL_QUEUE_ID_DOESN_T_EXIST = "Approval Queue ID doesn't exist.";

	@Autowired
	private ApprovalQueueRepository queueRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private QueueHistoryRepository historyRepo;
	
	@Override
	public ApprovalQueue save(ApprovalQueue queue) {
		return queueRepo.save(queue);
	}

	@Override
	public List<ApprovalQueue> findAll() {
		return queueRepo.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		queueRepo.deleteById(id);
	}

	@Transactional
	@Override
	public ProductApprovalQueue update(Integer id, String approval) throws InvalidIdException {
		ApprovalQueue queue = findById(id);
		if(queue == null) {
			throw new InvalidIdException(APPROVAL_QUEUE_ID_DOESN_T_EXIST);
		}
		ProductApprovalQueue productQueue = null;
		QueueHistory history = generateQueueHistory(queue);
		if(TaoConstants.APPROVE.equals(approval)) {
			Product resProduct=null;
			productQueue = new ProductApprovalQueue();
			if(TaoConstants.INSERT.equals(queue.getAction())) {
				Product product = generateProduct(queue, new Product());				
				resProduct = productRepo.save(product);
			} else if(TaoConstants.UPDATE.equals(queue.getAction())) {
				Product product = generateProduct(queue, productRepo.findById(queue.getProductId()).get());	
				resProduct = productRepo.save(product);
			} else if(TaoConstants.DELETE.equals(queue.getAction())) {
				productRepo.deleteById(queue.getProductId());
			}

			productQueue.setProduct(resProduct);	
			queueRepo.deleteById(id);			
			history.setApproved(true);
			historyRepo.save(history);
			
			queueRepo.deleteById(id);
			historyRepo.save(history);
			
		} else if(TaoConstants.REJECT.equals(approval)) {
			history.setApproved(queue.isApproved());
			
			queueRepo.deleteById(id);
			historyRepo.save(history);
		}
			
		return productQueue;
	}

	private Product generateProduct(ApprovalQueue queue, Product product) {
		product.setName(queue.getName());
		product.setPrice(queue.getPrice());
		product.setStatus(queue.getStatus());
		product.setPostedDate(queue.getPostedDate());
		product.setUpdatedDate(new Date());
		return product;
	}
	
	private QueueHistory generateQueueHistory(ApprovalQueue queue) {
		QueueHistory queueHistory = new QueueHistory();
		queueHistory.setName(queue.getName());
		queueHistory.setPrice(queue.getPrice());
		queueHistory.setStatus(queue.getStatus());
		queueHistory.setPostedDate(queue.getPostedDate());
		queueHistory.setProductId(queue.getProductId());
		queueHistory.setAction(queue.getAction());
		return queueHistory;
	}

	@Override
	public ApprovalQueue findById(Integer id) {
		return queueRepo.findById(id).orElse(null);
	}
	
	
}
