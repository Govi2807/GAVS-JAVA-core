package com.example.demo.repositories;
 
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.example.demo.model.Booking;
 
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
//Booking findByuser(Long user_id);
}
 