package com.example.demo.model;
 
import jakarta.persistence.*;
import java.time.LocalDate;
 
@Entity
public class Booking {
    @Id
    private Long booking_id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "car_id",referencedColumnName = "car_id")
    private Car car;
 
    private LocalDate booking_date;
    private String place;
 
    // Constructors
 
    public Booking() {
    }
 
    public Booking(User user, Car car, LocalDate bookingDate, String place) {
        this.user = user;
        this.car = car;
        this.booking_date = bookingDate;
        this.place=place;
    }
 
    // Getters and setters
 
    public Long getId() {
        return booking_id;
    }
 
    public void setId(Long booking_id) {
        this.booking_id = booking_id;
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
 
    public LocalDate getBookingDate() {
        return booking_date;
    }
 
    public void setBookingDate(LocalDate bookingDate) {
        this.booking_date = bookingDate;
    }
 
	public String getPlace() {
		return place;
	}
 
	public void setPlace(String place) {
		this.place = place;
	}
    
    
 
    
 
    
}