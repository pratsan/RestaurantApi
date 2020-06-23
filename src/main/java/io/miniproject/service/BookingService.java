package io.miniproject.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.miniproject.dto.BookingDto;
import io.miniproject.entity.Booking;
import io.miniproject.exception.BookingException;
import io.miniproject.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;
	public String placeOrder(BookingDto bookingDto)
	{
		try {
		Booking booking =new Booking();
		
		BeanUtils.copyProperties(bookingDto, booking);
		booking.setDate(new Date());
		booking.setBookingId(UUID.randomUUID().toString().substring(0, 8));
		bookingRepository.save(booking);
		return booking.getBookingId();
		}
		catch(Exception e)
		{
			return "something went wrong";
		}
		
	}
	
	public String deleteOrder(String id) throws BookingException
	{
		
			Optional<Booking> booking=bookingRepository.findById(id);
			if(!booking.isPresent())
				throw new BookingException("invalid booking id");
			bookingRepository.deleteById(id);
			return "deleted successfully";
		}

	public Booking getById(String id) throws BookingException {
		Optional<Booking> booking=bookingRepository.findById(id);
		if(!booking.isPresent())
			throw new BookingException("invalid booking id");
		return booking.get();
	}
	
	public Booking getByEmail(String email) throws BookingException {
		Optional<Booking> booking=bookingRepository.findByEmail(email);
		if(!booking.isPresent())
			throw new BookingException("invalid booking id");
		return booking.get();
	}
	
	public Booking getByContact(String contact) throws BookingException {
		Optional<Booking> booking=bookingRepository.findByContactNo(contact);
		if(!booking.isPresent())
			throw new BookingException("invalid booking id");
		return booking.get();
	}
	public Booking getByPersonName(String email) throws BookingException {
		Optional<Booking> booking=bookingRepository.findByrName(email);
		if(!booking.isPresent())
			throw new BookingException("invalid booking id");
		return booking.get();
	}
	
	
	
	
	}


