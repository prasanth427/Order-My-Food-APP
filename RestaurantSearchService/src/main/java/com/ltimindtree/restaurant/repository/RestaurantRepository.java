package com.ltimindtree.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ltimindtree.restaurant.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	public List<Restaurant> findByLocation(String location);

	public List<Restaurant> findByDistance(int distance);

	public List<Restaurant> findByCuisine(String Cuisine);

	public List<Restaurant> findByBudget(double budget);

	public Restaurant findByRestaurantName(String restaurantName);

	public Restaurant findByRestaurantId(long restaurantId);

}
