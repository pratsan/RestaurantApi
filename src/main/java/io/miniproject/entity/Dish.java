package io.miniproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dishId;
	String rName;
	String dishName;
	String dishCuisine;
	String dishType;
	int dishPrice;
    @OneToMany(mappedBy = "dish",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List<RestaurantDishes> restaurantDishes;
	public List<RestaurantDishes> getRestaurantDishes() {
		return restaurantDishes;
	}
	public void setRestaurantDishes(List<RestaurantDishes> restaurantDishes) {
		this.restaurantDishes = restaurantDishes;
	}
	public Dish(int dishId, String rName, String dishName, String dishCuisine, String dishType, int dishPrice,
			List<RestaurantDishes> restaurantDishes) {
		super();
		this.dishId = dishId;
		this.rName = rName;
		this.dishName = dishName;
		this.dishCuisine = dishCuisine;
		this.dishType = dishType;
		this.dishPrice = dishPrice;
		this.restaurantDishes = restaurantDishes;
	}
	public Dish() {
		
	}
	public Dish(int dishId, String rName, String dishName, String dishCuisine, String dishType, int dishPrice
			) {
		super();
		this.dishId = dishId;
		this.rName = rName;
		this.dishName = dishName;
		this.dishCuisine = dishCuisine;
		this.dishType = dishType;
		this.dishPrice = dishPrice;
		
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishCuisine() {
		return dishCuisine;
	}

	public void setDishCuisine(String dishCuisine) {
		this.dishCuisine = dishCuisine;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	
	
	

}
