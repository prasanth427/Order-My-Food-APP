package com.ltimindtree.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.restaurant.entity.Restaurant;
import com.ltimindtree.restaurant.repository.RestaurantRepository;
import com.ltimindtree.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Override
	public List<Restaurant> findByLocation(String location) {

		return restaurantRepo.findByLocation(location);
	}

	@Override
	public List<Restaurant> findByDistance(int distance) {

		return restaurantRepo.findByDistance(distance);
	}

	@Override
	public List<Restaurant> findByCuisine(String Cuisine) {

		return restaurantRepo.findByCuisine(Cuisine);
	}

	@Override
	public List<Restaurant> findByBudget(double budget) {

		return restaurantRepo.findByBudget(budget);
	}

	@Override
	public Restaurant findByRestaurantName(String restaurantName) {

		return restaurantRepo.findByRestaurantName(restaurantName);
	}

	@Override
	public Restaurant findByRestaurantId(long restaurantId) {

		return restaurantRepo.findById(restaurantId).get();
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {

		return restaurantRepo.save(restaurant);

	}

}
