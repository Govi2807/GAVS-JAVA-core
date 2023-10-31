package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.model.Car;
import com.example.demo.service.BookingService;
import com.example.demo.service.CarService;


@RestController
public class CarController {
	@Autowired
	CarService service;
	@GetMapping("/car")
	public List<Car> getProductDetails() {
	return service.getAllProducts();
	}
	
	@PostMapping("/addCar")
	public String addProduct(@RequestBody Car prd) {
		System.out.println(prd);
		service.addCar(prd);
		return "Added successfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.deleteProduct(id);
		return "Deleted";
	}	
	
	@PutMapping("/update/{itemId}")
    public ResponseEntity<Car> updateItem(@PathVariable int itemId, @RequestBody Car updatedItem) {
        Car updated = service.updateItem(itemId, updatedItem);
        return ResponseEntity.ok(updated);
    }
}
