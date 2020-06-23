package io.miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.miniproject.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

	public List<Dish> findByDishId(int id);
	public List<Dish> findByDishName(String dishName);
	public List<Dish> findByDishType(String dishType);
	public List<Dish> findByDishCuisine(String dishCuisine);
	public List<Dish> findByrName(String rName);
}