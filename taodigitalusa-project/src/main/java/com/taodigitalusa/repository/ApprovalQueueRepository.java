package com.taodigitalusa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taodigitalusa.entity.ApprovalQueue;

public interface ApprovalQueueRepository extends JpaRepository<ApprovalQueue, Integer> {
	
	@Query("select q from ApprovalQueue q order by q.postedDate desc")
	public List<ApprovalQueue> findAll();
	
}
