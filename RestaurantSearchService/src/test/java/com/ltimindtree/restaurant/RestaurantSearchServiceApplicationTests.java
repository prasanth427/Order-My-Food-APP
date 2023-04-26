package com.ltimindtree.restaurant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ltimindtree.restaurant.entity.MenuDetails;
import com.ltimindtree.restaurant.entity.Restaurant;
import com.ltimindtree.restaurant.repository.MenuDetailsRepository;
import com.ltimindtree.restaurant.repository.RestaurantRepository;

@SpringBootTest
class RestaurantSearchServiceApplicationTests {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private MenuDetailsRepository menuRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Rollback
	public void CreateRestaurentTest() {
		Restaurant restaurant = new Restaurant(1, "Trident", "hyderabad", 20, "Aisan", 3000.0);
		Restaurant savedRestaurant = restaurantRepo.save(restaurant);

		assertNotNull(savedRestaurant);
	}

	@Test
	public void findByRestaurantNameTest() {
		String name = "Trident";
		Restaurant restaurant = (Restaurant) restaurantRepo.findByRestaurantName(name);

		assertThat(restaurant.getRestaurantName()).isEqualTo(name);
	}

	@Test
	public void findByLocationTest() {
		String location = "hyderabad";
		List<Restaurant> restaurant = restaurantRepo.findByLocation(location);
		assertThat(restaurant).size().isGreaterThan(0);
	}

	@Test

	public void findByDistanceTest() {
		int distance = 20;
		List<Restaurant> restaurant = restaurantRepo.findByDistance(distance);
		assertThat(restaurant).size().isGreaterThan(0);
	}

	@Test

	public void findByBudgetTest() {
		double budget = 3000.0;
		List<Restaurant> restaurant = restaurantRepo.findByBudget(budget);
		assertThat(restaurant).size().isGreaterThan(0);
	}

	@Test

	public void findByCuisineTest() {
		String cuisine = "Aisan";
		List<Restaurant> restaurant = restaurantRepo.findByCuisine(cuisine);

		assertThat(restaurant).size().isGreaterThan(0);
	}

	@Test
	public void CreateMenuDeatilsTest() {
		MenuDetails menuDetail = new MenuDetails(1, "MuttonBriyani", "Single Plate", 350);
		MenuDetails savedMenu = menuRepository.save(menuDetail);
		assertNotNull(savedMenu);
	}

	@Test

	public void getRestaurantTest() {

		Restaurant restaurant = restaurantRepo.findByRestaurantId(1);

		assertThat(restaurant.getRestaurantId()).isEqualTo(1);

	}

}
