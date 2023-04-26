package com.ltimindtree.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class Order {

	@Id
	private long orderId;

	@Column(nullable = false)
	private long restaurantId;

	@Column(nullable = false)
	private long menuId;

	@Column(nullable = false)
	private double totalPrice;

	@Column(nullable = false)
	private String orderTime;

	@Column(nullable = false)
	private String deliveryTime;

	@Column(nullable = false)
	private String paymentId;

	@Column(nullable = false, length = 30)
	private String customerName;

	@Column(nullable = false, length = 10)
	private long customerPhoneNumber;

	@Column(nullable = false, updatable = true, length = 25)
	private String statusOfOrder;

	@Column(nullable = false, updatable = true)
	private int quantity;

	public Order() {

	}

	public Order(long orderId, long restaurantId, long menuId, double totalPrice, String orderTime, String deliveryTime,
			String paymentId, String customerName, long customerPhoneNumber, String statusOfOrder, int quantity) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.paymentId = paymentId;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.statusOfOrder = statusOfOrder;
		this.quantity = quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getStatusOfOrder() {
		return statusOfOrder;
	}

	public void setStatusOfOrder(String statusOfOrder) {
		this.statusOfOrder = statusOfOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", restaurantId=" + restaurantId + ", menuId=" + menuId + ", totalPrice="
				+ totalPrice + ", orderTime=" + orderTime + ", deliveryTime=" + deliveryTime + ", paymentId="
				+ paymentId + ", customerName=" + customerName + ", customerPhoneNumber=" + customerPhoneNumber
				+ ", statusOfOrder=" + statusOfOrder + ", quantity=" + quantity + "]";
	}

}
