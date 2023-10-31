package com.example.demo.service;
 
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.model.Booking;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingService {
	@Autowired
	BookingRepository repository;
	
	@Autowired
	CarRepository rs;
	public List<Booking> getAllProducts(){
		List<Booking> booking=new ArrayList<Booking>();
		repository.findAll().forEach(booking::add);
		return booking;
	}
	
//	public List<Booking> getProduct(User user){
//		 return (List<Booking>) repository.findByuser(user.getUser_id());
//	}
	
	public Booking addProduct( Booking prd) {
		Car a=rs.findById(prd.getCar().getCar_id()).get();
		int tc=a.getRentper_day();
		int total_cost=tc*prd.getDays();
		Booking obj = new Booking(prd.getBooking_id(),prd.getBooking_date(), prd.getPlace(),prd.getUser(),prd.getCar(),prd.getDays(),total_cost);
		return repository.save(obj);
	}
	
	public void deleteProduct(int id) {
		Booking car=repository.findById(id).get();
		System.out.println(car);
		repository.deleteById(id);
	}
	
	public Booking updateItem(int itemId, Booking updatedItem) {
        Booking existingItem = repository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        existingItem.setPlace(updatedItem.getPlace());
        existingItem.setBooking_date(updatedItem.getBooking_date());
        
        return repository.save(existingItem);
    }
}
