package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
