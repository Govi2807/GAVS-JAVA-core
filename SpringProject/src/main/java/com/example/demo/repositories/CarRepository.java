package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer>{

}
