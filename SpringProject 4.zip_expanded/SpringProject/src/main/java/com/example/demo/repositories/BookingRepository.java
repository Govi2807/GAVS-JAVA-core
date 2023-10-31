package com.example.demo.repositories;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.example.demo.model.Booking;
 
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
    // Add custom query methods if needed
}
 