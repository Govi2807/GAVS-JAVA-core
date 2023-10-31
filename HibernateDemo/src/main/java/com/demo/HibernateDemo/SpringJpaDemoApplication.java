package com.demo.HibernateDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import com.demo.HibernateDemo.entities.Product;
import com.demo.HibernateDemo.repositories.ProductRepository;

@Configuration
@SpringBootApplication
public class SpringJpaDemoApplication<CommandLineRunner> {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository) {
        return(args)->{
            // Create Products
            Product product1 = new Product("Java", "Book", 700);
            Product product2 = new Product("Spring", "Book", 800);
            Product product3 = new Product("Hibernate", "Book", 750);
            
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            
            // Read Product by ID
            Product retrievedProduct = productRepository.findById(1).get();
            System.out.println("Retrieved Product: " + retrievedProduct);
            
            // Update Product
            retrievedProduct.setPrdName("New Java Book");
            retrievedProduct.setPrdPrice(900);
            productRepository.save(retrievedProduct);
            
            // Delete Product
            productRepository.delete(retrievedProduct);
            
            // List all Products
            System.out.println("Product Listing:");
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
