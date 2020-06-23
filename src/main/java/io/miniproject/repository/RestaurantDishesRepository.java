package io.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.miniproject.entity.RestaurantDishes;

public interface RestaurantDishesRepository extends JpaRepository<RestaurantDishes, Integer> {

}
