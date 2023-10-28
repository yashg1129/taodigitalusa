package com.taodigitalusa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taodigitalusa.dto.ProductApprovalQueue;
import com.taodigitalusa.entity.ApprovalQueue;
import com.taodigitalusa.entity.Product;
import com.taodigitalusa.exception.InvalidIdException;
import com.taodigitalusa.exception.InvalidPriceException;
import com.taodigitalusa.repository.ApprovalQueueRepository;
import com.taodigitalusa.repository.ProductRepository;
import com.taodigitalusa.service.ProductService;
import com.taodigitalusa.utils.TaoConstants;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String PRODUCT_ID_DOES_NOT_EXIST = "Product ID does not exist.";

	private static final String PRICE_SHOULD_NOT_BE_MORE_THAN = "Price should not be more than ";

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ApprovalQueueRepository queueRepo;

	@Override
	public ProductApprovalQueue save(Product product) throws InvalidPriceException {
		ProductApprovalQueue productQueue = null;
		if (product.getPrice() > TaoConstants.MAX_PRICE) {
			throw new InvalidPriceException(PRICE_SHOULD_NOT_BE_MORE_THAN + TaoConstants.MAX_PRICE);
		} else if (product.getPrice() > TaoConstants.PRICE) {
			ApprovalQueue queue = generateApprovalQueue(product);
			queue.setAction(TaoConstants.INSERT);
			queue.setApproved(false);
			productQueue = new ProductApprovalQueue();
			productQueue.setApprovalQueue(queueRepo.save(queue));
		} else {
			productQueue = new ProductApprovalQueue();
			product.setPostedDate(new Date());
			product.setUpdatedDate(new Date());
			productQueue.setProduct(productRepo.save(product));
		}
		return productQueue;
	}

	private ApprovalQueue generateApprovalQueue(Product product) {
		ApprovalQueue queue = new ApprovalQueue();
		queue.setStatus(product.getStatus());
		queue.setName(product.getName());
		queue.setPrice(product.getPrice());
		queue.setPostedDate(new Date());
		queue.setProductId(product.getId());
		return queue;
	}

	@Override
	public ProductApprovalQueue update(Product updateProduct, Integer id) throws InvalidIdException {
		ProductApprovalQueue productQueue = null;
		Product product = findById(id);
		if (product == null) {
			throw new InvalidIdException(PRODUCT_ID_DOES_NOT_EXIST);
		}
		if (updateProduct.getPrice() > (product.getPrice() + (product.getPrice() * 50 / 100))) {
			ApprovalQueue queue = generateApprovalQueue(product);
			queue.setPrice(updateProduct.getPrice());
			queue.setAction(TaoConstants.UPDATE);
			queue.setApproved(false);
			productQueue = new ProductApprovalQueue();
			productQueue.setApprovalQueue(queueRepo.save(queue));
		} else {
			product.setUpdatedDate(new Date());
			product.setStatus(updateProduct.getStatus());
			product.setPrice(updateProduct.getPrice());
			product.setName(updateProduct.getName());
			productQueue = new ProductApprovalQueue();
			productQueue.setProduct(productRepo.save(product));
		}

		return productQueue;
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public ProductApprovalQueue deleteById(Integer id) throws InvalidIdException {
		ProductApprovalQueue productQueue = null;
		Product product = findById(id);
		if (product == null) {
			throw new InvalidIdException(PRODUCT_ID_DOES_NOT_EXIST);
		}
		ApprovalQueue queue = generateApprovalQueue(product);
		queue.setAction(TaoConstants.DELETE);
		queue.setApproved(false);
		queue.setProductId(id);
		productQueue = new ProductApprovalQueue();
		productQueue.setApprovalQueue(queueRepo.save(queue));

		return productQueue;
	}

	@Override
	public Product approvedSave(Product product) {
		return productRepo.save(product);
	}

}
