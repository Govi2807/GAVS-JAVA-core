package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Car;
import com.example.demo.repositories.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarService {
	
	@Autowired
	CarRepository repository;
	public List<Car> getAllProducts(){
		List<Car> car=new ArrayList<Car>();
		repository.findAll().forEach(car::add);
		return car;
	}
	
	public Car addCar( Car prd) {
		return repository.save(prd);
	}
	
	public void deleteProduct(int id) {
		Car car=repository.findById(id).get();
		System.out.println(car);
		repository.deleteById(id);
	}
	
	public Car updateItem(int itemId, Car updatedItem) {
        Car existingItem = repository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        existingItem.setCapacity(updatedItem.getCapacity());
        existingItem.setFuel(updatedItem.getFuel());
        existingItem.setRateper_km(updatedItem.getRateper_km());
        existingItem.setRentper_day(updatedItem.getRentper_day());
        existingItem.setStatus(updatedItem.getStatus());
        existingItem.setType(updatedItem.getType());
        existingItem.setVehicle_name(updatedItem.getVehicle_name());

        return repository.save(existingItem);
    }
	

}
