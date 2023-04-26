package com.ltimindtree.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findByCustomerName(String customerName);
}
