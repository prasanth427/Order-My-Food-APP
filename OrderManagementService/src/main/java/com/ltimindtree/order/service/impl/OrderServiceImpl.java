package com.ltimindtree.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ltimindtree.order.entity.Order;
import com.ltimindtree.order.repository.OrderRepository;
import com.ltimindtree.order.response.MenuDetails;
import com.ltimindtree.order.response.ResponseDto;
import com.ltimindtree.order.response.Restaurant;

import com.ltimindtree.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseDto viewOrderByCustomerName(String customerName) {

		ResponseDto response = new ResponseDto();

		Order order =  orderRepository.findByCustomerName(customerName);

		Restaurant restaurant = restTemplate.getForObject(
				"http://localhost:9091/api/resturants/findByRestaurantId/" + order.getRestaurantId(), 
				Restaurant.class);

		MenuDetails menu = restTemplate.getForObject(
				"http://localhost:9091/api/resturants/findByMenuId/" + order.getMenuId(), 
				MenuDetails.class);

		response.setRestaurantDetailsofOrder(restaurant);
		response.setOrderDetails(order);
        response.setMenuDetailsOfOrder(menu); 

		return response;

	}

	@Override
	public ResponseDto viewOrderByOrderId(long orderId) {

		ResponseDto response = new ResponseDto();

		Order order =  orderRepository.findById(orderId).get();

		Restaurant restaurant = restTemplate.getForObject(
				"http://localhost:9091/api/resturants/findByRestaurantId/" + order.getRestaurantId(), Restaurant.class);

		MenuDetails menu = restTemplate.getForObject(
				"http://localhost:9091/api/resturants/findByMenuId/" + order.getMenuId(), MenuDetails.class);

		response.setRestaurantDetailsofOrder(restaurant);
		response.setOrderDetails(order);

		response.setMenuDetailsOfOrder(menu);

		return response;

	}

	@Override
	public Order updateOrder(long orderId, Order order) {
		Order orders =  orderRepository.findById(orderId).get();

		orders.setCustomerName(order.getCustomerName());
		orders.setCustomerPhoneNumber(order.getCustomerPhoneNumber());
		orders.setDeliveryTime(order.getDeliveryTime());
		orders.setMenuId(order.getMenuId());
		orders.setOrderTime(order.getOrderTime());
		orders.setStatusOfOrder(order.getStatusOfOrder());
		orders.setTotalPrice(order.getTotalPrice());
		orders.setRestaurantId(order.getRestaurantId());

		Order updatedOrder =  orderRepository.save(orders);

		return updatedOrder;
	}

	@Override
	public Order createOrder(Order order) {

		return  orderRepository.save(order);
	}

	@Override
	public void cancelOrder(long OrderId) {

		 orderRepository.deleteById(OrderId);

	}

}
