package com.ltimindtree.order.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ltimindtree.order.entity.Order;
import com.ltimindtree.order.exception.OrderException;
import com.ltimindtree.order.response.ResponseDto;
import com.ltimindtree.order.service.impl.OrderServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private Map<String, Object> responseMessage;

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/createOrder")
	public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Order order) {

		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "order created successfully");
		responseMessage.put("Body", orderService.createOrder(order));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@PutMapping("updateOrder/{orderId}")
	public ResponseEntity<Map<String, Object>> updateOrder(@PathVariable long orderId, @RequestBody Order order) throws OrderException {

		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "order Updated successfully");
		responseMessage.put("Body", orderService.updateOrder(orderId, order));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@DeleteMapping("cancelOrder/{orderId}")
	public ResponseEntity<Map<String, Object>> cancelOrder(@PathVariable long orderId) throws OrderException {

		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "order Cancelled successfully , If you pay for the order your will get refund with one day");
		orderService.cancelOrder(orderId);

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	private static final String OrderManagementService ="orderManagementService";
	@GetMapping("viewOrder/{CustomerName}")
	@CircuitBreaker(name = OrderManagementService , fallbackMethod="viewMessage")
	public ResponseDto viewOrders(@PathVariable String CustomerName) throws OrderException {

		return orderService.viewOrderByCustomerName(CustomerName);
	}

	
	@GetMapping("viewOrders/{orderId}")
	public ResponseDto viewOrdersByOrderId(@PathVariable long orderId) {

		return orderService.viewOrderByOrderId(orderId);
	}

	
	public String viewMessage(Exception e) {
		
		return "Service is taking longer time than excepted please try again later";
	}
}
