package io.miniproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import io.miniproject.dto.DishDto;
import io.miniproject.entity.Dish;
import io.miniproject.entity.Restaurant;
import io.miniproject.entity.RestaurantDishes;
import io.miniproject.exception.DishException;
import io.miniproject.exception.RestaurantException;
import io.miniproject.repository.DishRepository;
import io.miniproject.repository.RestaurantDishesRepository;
import io.miniproject.repository.RestaurantRepository;

@Service
public class DishService {
	@Autowired
	private DishRepository dishRepository;
	@Autowired RestaurantRepository restaurantRepository;
	
	@Autowired
	RestaurantDishesRepository restaurantDishesRepository;

	public List<DishDto> getAllDish() throws DishException {
		// List<Restaurant> res = new ArrayList<>();
		List<Dish> dishes = dishRepository.findAll();

		if(dishes.isEmpty())
			
			throw new DishException("Dish not found");
		
		
			return dishes.stream().map(dish->{
				DishDto dishDto=new DishDto();
				BeanUtils.copyProperties(dish, dishDto);
				return dishDto;
			}).collect(Collectors.toList());
		}

	//public List<Dish> getDish(int rId) {
		
	//	return restaurantRepository.findById(rId).get().getDishes();
	//}

	public void addDishToRestaurent(int rId,int dishId) {
		try {
		Optional<Restaurant> restaurant=restaurantRepository.findById(rId);
		if(!restaurant.isPresent())
			throw new RestaurantException("Restaurant not found");
		Optional<Dish> dish=dishRepository.findById(dishId);
		if(!dish.isPresent())
			throw new DishException("Dish not found to add to restaurant");
	RestaurantDishes restaurantDishes=new RestaurantDishes();
	restaurantDishes.setDish(dish.get());
	restaurantDishes.setRestaurant(restaurant.get());
	
	//	restaurant.get().setDishes(dishes);
		
		restaurantDishesRepository.save(restaurantDishes);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void updateDish(int dishId, Dish dish) throws DishException {
		Optional<Dish> dishOptional=dishRepository.findById(dishId);
		if(!dishOptional.isPresent())
			throw new DishException("Dish not found to update");
		dishOptional.get().setDishCuisine(dish.getDishCuisine());
		dishOptional.get().setDishName(dish.getDishName());
		dishOptional.get().setDishPrice(dish.getDishPrice());
		dishOptional.get().setDishType(dish.getDishType());
		dishOptional.get().setrName(dish.getrName());
		dishRepository.save(dishOptional.get());
	}

	public void deleteDish(int dishId) throws DishException {
		try {
		dishRepository.deleteById(dishId);
		}
		catch(Exception e)
		{
			throw new DishException("invalid dish id");
		}
	}

	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		dishRepository.save(dish);
	}

	public List<DishDto> getDishByDishName(String dishName) throws DishException {
		// TODO Auto-generated method stub
		 
	List<Dish> dishes=	dishRepository.findByDishName(dishName);
	
	if(dishes.isEmpty())
	
		throw new DishException("Dish not found");
	
	
		return dishes.stream().map(dish->{
			DishDto dishDto=new DishDto();
			BeanUtils.copyProperties(dish, dishDto);
			return dishDto;
		}).collect(Collectors.toList());
	}

	public List<DishDto> getDishByDishType(String dishType) throws DishException {
		// TODO Auto-generated method stub
		List<Dish> dishes=	dishRepository.findByDishType(dishType);
		
		if(dishes.isEmpty())
		{
			throw new DishException("Dish not found");	
		}
		
			return dishes.stream().map(dish->{
				DishDto dishDto=new DishDto();
				BeanUtils.copyProperties(dish, dishDto);
				return dishDto;
			}).collect(Collectors.toList());
		}

	public List<DishDto> getDishByDishCuisine(String dishCuisine) throws DishException {
		// TODO Auto-generated method stub
List<Dish> dishes=	dishRepository.findByDishCuisine(dishCuisine);
		
		if(dishes.isEmpty())
		{
			throw new DishException("no Dish  found");	
		}
		
			return dishes.stream().map(dish->{
				DishDto dishDto=new DishDto();
				BeanUtils.copyProperties(dish, dishDto);
				return dishDto;
			}).collect(Collectors.toList());
		}

	public List<DishDto> getDishByRName(String rName) throws DishException {
List<Dish> dishes=	dishRepository.findByrName(rName);
		
		if(dishes.isEmpty())
		{
			throw new DishException("Dish not found");
		}
		
			return dishes.stream().map(dish->{
				DishDto dishDto=new DishDto();
				BeanUtils.copyProperties(dish, dishDto);
				return dishDto;
			}).collect(Collectors.toList());
		}

	public List<DishDto> getDishByZip(int zip) throws RestaurantException {
		List<Restaurant> restaurant=restaurantRepository.findByrZip(zip);
		if(restaurant.isEmpty())
		{
			throw new RestaurantException("no restaurant found");
		}
		List<Dish> dishes=new ArrayList<Dish>();
		for (Restaurant restaurant2 : restaurant) {
			
			for (RestaurantDishes dish2 : restaurant2.getRestaurantDishes()) {
				dishes.add(dish2.getDish());
			}
		}
		
		return dishes.stream().map(dish->{
			DishDto dishDto=new DishDto();
			BeanUtils.copyProperties(dish, dishDto);
			return dishDto;
		}).collect(Collectors.toList());
	}
	}

