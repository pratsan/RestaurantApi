package io.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.miniproject.dto.BookingDto;
import io.miniproject.entity.Booking;
import io.miniproject.exception.BookingException;
import io.miniproject.service.BookingService;

@RestController
public class BookingController {
@Autowired
BookingService bookingService;
	@PostMapping("/booking")
	public ResponseEntity<String> book(@RequestBody BookingDto bookingDto)
	{
		return new ResponseEntity<>(bookingService.placeOrder(bookingDto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/booking/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable String id) throws BookingException
	{
		return new ResponseEntity<>(bookingService.deleteOrder(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> getBookUsingId(@PathVariable String id) throws BookingException
	{
		return new ResponseEntity<>(bookingService.getById(id),HttpStatus.FOUND);
	}

	
	@GetMapping("/booking_name/{id}")
	public ResponseEntity<Booking> getBookByUsingName(@PathVariable String id) throws BookingException
	{
		return new ResponseEntity<>(bookingService.getByPersonName(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/booking_contact/{id}")
	public ResponseEntity<Booking> getBookByUsingContact(@PathVariable String id) throws BookingException
	{
		return new ResponseEntity<>(bookingService.getByContact(id),HttpStatus.FOUND);
	}
	@GetMapping("/booking_email/{id}")
	public ResponseEntity<Booking> getBookByUsingEmail(@PathVariable String id) throws BookingException
	{
		return new ResponseEntity<>(bookingService.getByEmail(id),HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
}
