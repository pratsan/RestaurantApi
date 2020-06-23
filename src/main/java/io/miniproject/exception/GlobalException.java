package io.miniproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(DishException.class)
	public ResponseEntity<ErrorResponse> dishError(DishException dishException)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(dishException.getMessage());
		errorResponse.setCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<ErrorResponse> dishError(RestaurantException restaurantException)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(restaurantException.getMessage());
		errorResponse.setCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorResponse> BookingError(BookingException bookingException)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(bookingException.getMessage());
		errorResponse.setCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
