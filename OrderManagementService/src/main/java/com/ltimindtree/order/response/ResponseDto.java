package com.ltimindtree.order.response;

import com.ltimindtree.order.entity.Order;

public class ResponseDto {

	private Order orderDetails;

	private Restaurant restaurantDetailsofOrder;

	private MenuDetails menuDetailsOfOrder;

	public ResponseDto() {

	}

	public ResponseDto(Order orderDetails, Restaurant restaurantDetailsofOrder, MenuDetails menuDetailsOfOrder) {
		super();
		this.orderDetails = orderDetails;
		this.restaurantDetailsofOrder = restaurantDetailsofOrder;
		this.menuDetailsOfOrder = menuDetailsOfOrder;
	}

	public Order getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Order orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Restaurant getRestaurantDetailsofOrder() {
		return restaurantDetailsofOrder;
	}

	public void setRestaurantDetailsofOrder(Restaurant restaurantDetailsofOrder) {
		this.restaurantDetailsofOrder = restaurantDetailsofOrder;
	}

	public MenuDetails getMenuDetailsOfOrder() {
		return menuDetailsOfOrder;
	}

	public void setMenuDetailsOfOrder(MenuDetails menuDetailsOfOrder) {
		this.menuDetailsOfOrder = menuDetailsOfOrder;
	}

	@Override
	public String toString() {
		return "ResponseDto [orderDetails=" + orderDetails + ", restaurantDetailsofOrder=" + restaurantDetailsofOrder
				+ ", menuDetailsOfOrder=" + menuDetailsOfOrder + "]";
	}

}
