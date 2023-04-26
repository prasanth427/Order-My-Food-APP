package com.ltimindtree.restaurant.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurants_Information")
public class Restaurant {

	@Id
    private long restaurantId;

	@Column(length = 50, unique = true, nullable = false)
	private String restaurantName;

	@Column(length = 30, nullable = false)
	private String location;

	@Column(nullable = false)
	private int distance;

	@Column(length = 40, nullable = false)
	private String cuisine;

	@Column(nullable = false)
	private double budget;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
	private List<MenuDetails> menuDetails;

	public Restaurant() {

	}
	
	

	public Restaurant(long restaurantId, String restaurantName, String location, int distance, String cuisine,
			double budget) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.distance = distance;
		this.cuisine = cuisine;
		this.budget = budget;
	}



	public Restaurant(long restaurantId, String restaurantName, String location, int distance, String cuisine,
			double budget, List<MenuDetails> menuDetails) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.location = location;
		this.distance = distance;
		this.cuisine = cuisine;
		this.budget = budget;
		this.menuDetails = menuDetails;
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

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public List<MenuDetails> getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(List<MenuDetails> menuDetails) {
		this.menuDetails = menuDetails;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", location="
				+ location + ", distance=" + distance + ", cuisine=" + cuisine + ", budget=" + budget + ", menuDetails="
				+ menuDetails + "]";
	}

}
