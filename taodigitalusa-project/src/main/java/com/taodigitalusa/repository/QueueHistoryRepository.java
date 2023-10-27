package com.taodigitalusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taodigitalusa.entity.QueueHistory;

public interface QueueHistoryRepository extends JpaRepository<QueueHistory, Integer> {

}
