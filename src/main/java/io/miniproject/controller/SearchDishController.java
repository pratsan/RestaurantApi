package io.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.miniproject.dto.DishDto;
import io.miniproject.exception.DishException;
import io.miniproject.exception.RestaurantException;
import io.miniproject.repository.DishRepository;
import io.miniproject.service.DishService;

@RestController
public class SearchDishController {
	@Autowired
	DishRepository dishRepository;
	@Autowired
	DishService dishService;
	
	@GetMapping("dishSearchDishName/{dishName}")
public ResponseEntity<List<DishDto>> searchDishByDishName(@PathVariable("dishName")String dishName) throws DishException
{
	return new ResponseEntity<List<DishDto>>(dishService.getDishByDishName(dishName),HttpStatus.FOUND);
}
	
	@GetMapping("dishSearchType/{dishType}")
public ResponseEntity<List<DishDto>> searchDishByDishType(@PathVariable("dishType")String dishType)throws DishException
{
	return new ResponseEntity<List<DishDto>>(dishService.getDishByDishType(dishType),HttpStatus.FOUND);
}
	
	
	
	@GetMapping("dishSearchCuisine/{dishCuisine}")
	public ResponseEntity<List<DishDto>> searchDishByDishCuisine(@PathVariable("dishCuisine")String dishCuisine)throws DishException
	{
		return new ResponseEntity<>(dishService.getDishByDishCuisine(dishCuisine),HttpStatus.FOUND);
	}
	@GetMapping("dishSearchrName/{rName}")
	public ResponseEntity<List<DishDto>> searchDishByRName(@PathVariable("rName")String rName)throws DishException
	{
		return new ResponseEntity<List<DishDto>>(dishService.getDishByRName(rName),HttpStatus.FOUND);
	}
	@GetMapping("dishSearchZip/{zip}")
	public ResponseEntity<List<DishDto>> searchDishByzip(@PathVariable("zip")int zip)throws RestaurantException
	{
		return new ResponseEntity<List<DishDto>>(dishService.getDishByZip(zip),HttpStatus.FOUND);
	}
	
}
