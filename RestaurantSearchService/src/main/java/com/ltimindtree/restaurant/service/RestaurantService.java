package com.ltimindtree.restaurant.service;

import java.util.List;

import com.ltimindtree.restaurant.entity.Restaurant;

public interface RestaurantService {

	public Restaurant findByRestaurantId(long restaurantId);

	public Restaurant saveRestaurant(Restaurant restaurant);

	public List<Restaurant> findByLocation(String location);

	public List<Restaurant> findByDistance(int distance);

	public List<Restaurant> findByCuisine(String Cuisine);

	public List<Restaurant> findByBudget(double budget);

	public Restaurant findByRestaurantName(String restaurantName);
}
