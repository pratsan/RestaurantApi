package io.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.miniproject.dto.DishDto;
import io.miniproject.entity.Dish;
import io.miniproject.exception.DishException;
import io.miniproject.service.DishService;

@RestController
public class DishController {
	@Autowired
	private DishService dishService;

	@PostMapping("/dishes")
	public ResponseEntity<String> addDish(@RequestBody Dish dish)
	{
		 dishService.addDish(dish);
			return new ResponseEntity<String>("Dish added Successfully",HttpStatus.ACCEPTED);
	}
	@RequestMapping("/dishes")
	public ResponseEntity<List<DishDto>> getAllDish() throws DishException {
		return new ResponseEntity<List<DishDto>>( dishService.getAllDish(),HttpStatus.FOUND);
	}

	/*
	 * @RequestMapping("/restaurants/{rId}") public List<Dish>
	 * getDish(@PathVariable("rId") int rId) { return dishService.getDish(rId); }
	 */

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurants/{rId}/dish/{dId}")
	public ResponseEntity<String> adddishToRestaurant(@PathVariable("rId") int rId,@PathVariable("dId") int dId) {
		dishService.addDishToRestaurent(rId, dId);
		return new ResponseEntity<String>("Dish Successfully added to restaurant",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurants/{rId}/dishes/{dishId}")
	public ResponseEntity<String> updateRestaurant(@RequestBody Dish dish, @PathVariable int dishId) throws DishException {
		dishService.updateDish(dishId, dish);
		return new ResponseEntity<String>("Dish Updated Successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dishes/{dishId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int dishId) throws DishException {
		dishService.deleteDish(dishId);
		return new ResponseEntity<String>("Dish deleted Successfully",HttpStatus.ACCEPTED);
	}
}
