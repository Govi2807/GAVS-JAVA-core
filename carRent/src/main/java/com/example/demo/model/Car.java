
package com.example.demo.model;
 
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
 
@Entity

public class Car {

	@Id

	private int car_id;

	private String vehicle_name;

	private String fuel;

	private int capacity;

	private int rentper_day;

	private int rateper_km;

	private String status;

	public Car() {

		super();

	}
 
	public int getCar_id() {

		return car_id;

	}
 
	public void setCar_id(int car_id) {

		this.car_id = car_id;

	}
 
	public String getVehicle_name() {

		return vehicle_name;

	}
 
	public void setVehicle_name(String vehicle_name) {

		this.vehicle_name = vehicle_name;

	}
 
	public String getFuel() {

		return fuel;

	}
 
	public void setFuel(String fuel) {

		this.fuel = fuel;

	}
 
	public int getCapacity() {

		return capacity;

	}
 
	public void setCapacity(int capacity) {

		this.capacity = capacity;

	}
 
	public int getRentper_day() {

		return rentper_day;

	}
 
	public void setRentper_day(int rentper_day) {

		this.rentper_day = rentper_day;

	}
 
	public int getRateper_km() {

		return rateper_km;

	}
 
	public void setRateper_km(int rateper_km) {

		this.rateper_km = rateper_km;

	}
 
	public String getStatus() {

		return status;

	}
 
	public void setStatus(String status) {

		this.status = status;

	}
 
	public Car(int car_id, String vehicle_name, String fuel, int capacity, int rentper_day, int rateper_km,

			String status) {

		super();

		this.car_id = car_id;

		this.vehicle_name = vehicle_name;

		this.fuel = fuel;

		this.capacity = capacity;

		this.rentper_day = rentper_day;

		this.rateper_km = rateper_km;

		this.status = status;

	}
 
	@Override

	public String toString() {

		return "Car [car_id=" + car_id + ", vehicle_name=" + vehicle_name + ", fuel=" + fuel + ", capacity=" + capacity

				+ ", rentper_day=" + rentper_day + ", rateper_km=" + rateper_km + ", status=" + status + "]";

	}

}