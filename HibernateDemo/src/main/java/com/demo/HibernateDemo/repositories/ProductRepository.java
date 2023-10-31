package com.demo.HibernateDemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.HibernateDemo.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
