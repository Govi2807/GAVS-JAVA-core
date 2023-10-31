
package com.example.demo.model;
 
import java.util.Date;
 
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
 
@Entity

public class Booking {

	@Id

     private int booking_id;

     private Date booking_date;

     private String place;

     @ManyToOne

     @JoinColumn(name = "user_uid",referencedColumnName = "user_id")

     private User user;

     @ManyToOne

     @JoinColumn(name = "car_uid",referencedColumnName = "car_id")

     private Car car;
 
	public int getBooking_id() {

		return booking_id;

	}
 
	public void setBooking_id(int booking_id) {

		this.booking_id = booking_id;

	}
 
	public Date getBooking_date() {

		return booking_date;

	}
 
	public void setBooking_date(Date booking_date) {

		this.booking_date = booking_date;

	}
 
	public String getPlace() {

		return place;

	}
 
	public void setPlace(String place) {

		this.place = place;

	}
 
	public User getUser() {

		return user;

	}
 
	public void setUser(User user) {

		this.user = user;

	}
 
	public Car getCar() {

		return car;

	}
 
	public void setCar(Car car) {

		this.car = car;

	}     

}