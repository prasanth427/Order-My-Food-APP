package com.ltimindtree.restaurant.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ltimindtree.restaurant.entity.MenuDetails;
import com.ltimindtree.restaurant.entity.Restaurant;
import com.ltimindtree.restaurant.service.impl.MenuDetailsImpl;
import com.ltimindtree.restaurant.service.impl.RestaurantServiceImpl;

@RestController
@RequestMapping("/api/resturants")
public class RestaurantSearchController {

	private Map<String, Object> responseMessage;

	@Autowired
	private RestaurantServiceImpl restaurantService;

	@Autowired
	private MenuDetailsImpl menuService;

	@GetMapping("/findByLocation/{location}")
	public ResponseEntity<Map<String, Object>> findByLocation(@PathVariable String location) {

		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurants fetched by location");
		responseMessage.put("Body", restaurantService.findByLocation(location));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/findByDistance/{distance}")
	public ResponseEntity<Map<String, Object>> findByDistance(@PathVariable int distance) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurants fetched by Distance");
		responseMessage.put("Body", restaurantService.findByDistance(distance));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/findByCuisine/{cuisine}")
	public ResponseEntity<Map<String, Object>> findByCuisine(@PathVariable String cuisine) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurants fetched by Cusinine");
		responseMessage.put("Body", restaurantService.findByCuisine(cuisine));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/findByBudget/{budget}")
	public ResponseEntity<Map<String, Object>> findByBudget(@PathVariable double budget) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurants fetched by Budget");
		responseMessage.put("Body", restaurantService.findByBudget(budget));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/findByRestaurantName/{restaurantName}")
	public ResponseEntity<Map<String, Object>> findByRestaurantName(@PathVariable String restaurantName) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurants fetched by RestaurantName");
		responseMessage.put("Body", restaurantService.findByRestaurantName(restaurantName));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/findByMenuName/{menuName}")
	public ResponseEntity<Map<String, Object>> findByMenuName(@PathVariable String menuName) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "MenuDetails fetched by MenuName");
		responseMessage.put("Body", menuService.findByMenuName(menuName));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@PostMapping("/SaveRestaurant")
	public ResponseEntity<Map<String, Object>> saveRestaurant(@RequestBody Restaurant restaurant) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "Restaurant created Successfully");
		responseMessage.put("Body", restaurantService.saveRestaurant(restaurant));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@PostMapping("/SaveMenuDetails")
	public ResponseEntity<Map<String, Object>> saveMenuDetail(@RequestBody MenuDetails menuDetails) {
		responseMessage = new HashMap<String, Object>();
		responseMessage.put("Message", "MenuDetails Created Successfully");
		responseMessage.put("Body", menuService.saveMenuDetails(menuDetails));

		return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("findByRestaurantId/{Id}")
	public Restaurant findByRestaurantId(@PathVariable("Id") long restaurantId) {
		return restaurantService.findByRestaurantId(restaurantId);
	}

	@GetMapping("findByMenuId/{Id}")
	public MenuDetails findByMenuId(@PathVariable("Id") long menuId) {
		return menuService.findByMenuId(menuId);
	}
}
