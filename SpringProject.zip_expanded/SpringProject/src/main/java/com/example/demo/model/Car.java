package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	private int carId;
	private String vehicleName;
	private String fuel;
	private int capacity;
	private int rentperDay;
	private int rateperKm;
	private String status;
	
	public Car() {
		super();
	}
	
	public Car(int carId, String vehicleName, String fuel, int capacity, int rentperDay, int rateperKm, String status) {
		super();
		this.carId = carId;
		this.vehicleName = vehicleName;
		this.fuel = fuel;
		this.capacity = capacity;
		this.rentperDay = rentperDay;
		this.rateperKm = rateperKm;
		this.status = status;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
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
	public int getRentperDay() {
		return rentperDay;
	}
	public void setRentperDay(int rentperDay) {
		this.rentperDay = rentperDay;
	}
	public int getRateperKm() {
		return rateperKm;
	}
	public void setRateperKm(int rateperKm) {
		this.rateperKm = rateperKm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", vehicleName=" + vehicleName + ", fuel=" + fuel + ", capacity=" + capacity
				+ ", rentperDay=" + rentperDay + ", rateperKm=" + rateperKm + ", status=" + status + "]";
	}
	

}
