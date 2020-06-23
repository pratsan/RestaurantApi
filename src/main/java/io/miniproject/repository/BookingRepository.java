package io.miniproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.miniproject.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

	Optional<Booking> findByEmail(String email);

	Optional<Booking> findByContactNo(String contact);
	
	Optional<Booking> findByrName(String name);

}
