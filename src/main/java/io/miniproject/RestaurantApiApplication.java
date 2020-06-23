package io.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class RestaurantApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApiApplication.class, args);
	}

}
