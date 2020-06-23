package io.miniproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.miniproject.dto.DishDto;
import io.miniproject.dto.RestaurantDto;
import io.miniproject.entity.Restaurant;
import io.miniproject.exception.RestaurantException;
import io.miniproject.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<RestaurantDto> getAllRestaurants() throws RestaurantException{
		// List<Restaurant> res = new ArrayList<>();
		List<Restaurant> res = restaurantRepository.findAll();
    if(res.isEmpty())
    	throw new RestaurantException("Restaurant not found");
    return res.stream().map(dish->{
		RestaurantDto dishDto=new RestaurantDto();
		BeanUtils.copyProperties(dish, dishDto);
		return dishDto;
	}).collect(Collectors.toList());

	}

	public RestaurantDto getRestaurant(int rId) throws RestaurantException {
		
		Optional<Restaurant> restaurant= restaurantRepository.findById(rId);
		if(!restaurant.isPresent())
			throw new RestaurantException("Restaurant not found");
		RestaurantDto restaurantDto=new RestaurantDto();
		restaurantDto.setrCity(restaurant.get().getrCity());
		restaurantDto.setrCountry(restaurant.get().getrCountry());
		restaurantDto.setrName(restaurant.get().getrName());
		restaurantDto.setrPhone(restaurant.get().getrPhone());
		restaurantDto.setrState(restaurant.get().getrState());
		restaurantDto.setrZip(restaurant.get().getrZip());
		
		return restaurantDto;
		
		
		
	}

	public void addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	public void updateRestaurant(int rId, Restaurant restaurant) throws RestaurantException {
		try {
		Optional<Restaurant> resOptional=restaurantRepository.findById(rId);
		
		
		resOptional.get().setrCity(restaurant.getrCity());
		resOptional.get().setrCountry(restaurant.getrCountry());
		resOptional.get().setrName(restaurant.getrName());
		resOptional.get().setrState(restaurant.getrState());
		resOptional.get().setrZip(restaurant.getrZip());
		resOptional.get().setrPhone(restaurant.getrPhone());
		restaurantRepository.save(resOptional.get());
		}
		catch(Exception e)
		{
			throw new RestaurantException("restaurant id not found");
		}
	}

	public void deleteRestaurant(int rId) throws RestaurantException {
		try {
		restaurantRepository.deleteById(rId);
		}
		catch(Exception e)
		{
			throw new RestaurantException("restaurant id not found");
		}
	}

}