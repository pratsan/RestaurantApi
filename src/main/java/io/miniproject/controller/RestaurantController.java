package io.miniproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.miniproject.dto.RestaurantDto;
import io.miniproject.entity.Restaurant;
import io.miniproject.exception.RestaurantException;
import io.miniproject.service.RestaurantService;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDto>> getAllRestaurant() throws RestaurantException {
		return new ResponseEntity<List<RestaurantDto>>(restaurantService.getAllRestaurants(),HttpStatus.FOUND);
	}

	@GetMapping("/restaurants/{rId}")
	public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable int rId) throws RestaurantException {
		return new ResponseEntity<RestaurantDto>(restaurantService.getRestaurant(rId),HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restaurants")
	public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<String>("Restaurant added successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurants/{rId}")
	public ResponseEntity<String> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable int rId) throws RestaurantException {
		restaurantService.updateRestaurant(rId, restaurant);
		return new ResponseEntity<String>("Restaurant updated successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurants/{rId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int rId) throws RestaurantException {
		restaurantService.deleteRestaurant(rId);
		return new ResponseEntity<String>("Restaurant deleted successfully",HttpStatus.ACCEPTED);
	}
	

}
