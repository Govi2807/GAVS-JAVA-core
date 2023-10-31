package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository repository;
	public List<Car> getAllProducts(){
		List<Car> car=new ArrayList<Car>();
		repository.findAll().forEach(car::add);
		return car;
	}

}
