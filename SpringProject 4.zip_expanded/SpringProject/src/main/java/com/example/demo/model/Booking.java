package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
     
     public Booking() {
    	 super();
     }
     public Booking( int booking_id,Date booking_date, String place, User user, Car car, int days, int total_cost) {
		super();
	this.booking_id=booking_id;
		this.booking_date = booking_date;
		this.place = place;
		this.user = user;
		this.car = car;
		this.days = days;
		this.total_cost = total_cost;
	}

	private int days;
     private int total_cost;
     
	public long getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

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