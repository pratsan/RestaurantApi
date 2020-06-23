package io.miniproject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {
@Id
public String bookingId;
public String rName;
public String dishName;

@Temporal(TemporalType.TIMESTAMP)
public Date date;
public String email;
public long contactNo;
public String getBookingId() {
	return bookingId;
}
public void setBookingId(String bookingId) {
	this.bookingId = bookingId;
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

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getContactNo() {
	return contactNo;
}
public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}

}
