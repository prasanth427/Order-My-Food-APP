package com.ltimindtree.order.service;

import com.ltimindtree.order.entity.Order;
import com.ltimindtree.order.response.ResponseDto;

public interface OrderService {

	public Order createOrder(Order order);

	public void cancelOrder(long OrderId);

	public Order updateOrder(long OrderId, Order order);

	public ResponseDto viewOrderByCustomerName(String customerName);

	public ResponseDto viewOrderByOrderId(long orderId);

}
