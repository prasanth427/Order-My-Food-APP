package com.ltimindtree.order.response;

public class Restaurant {

	private long restaurantId;

	private String restaurantName;

	private String location;

	private int distance;

	private String cuisine;

	public Restaurant() {

	}

	public Restaurant(long restaurantId, String restaurantName, String location, int distance, String cuisine) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.distance = distance;
		this.cuisine = cuisine;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", distance=" + distance + ", cuisine=" + cuisine + "]";
	}

}
