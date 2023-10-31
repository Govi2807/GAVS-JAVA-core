package com.example.demo.service;
 
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.model.Booking;
 
import com.example.demo.repositories.BookingRepository;
 
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
 
    public List<Booking> getAllProducts(){
		List<Booking> products=new ArrayList<Booking>();
		bookingRepository.findAll().forEach(products::add);
		return products;
	}
	public Booking getProduct(long id) {
		return bookingRepository.findById(id).get();
	}
	public void addProduct( Booking prd) {
		bookingRepository.save(prd);
		
	}
	public void deleteProduct(long id) {
		Booking prd=bookingRepository.findById(id).get();
		System.out.println(prd);
		bookingRepository.deleteById(id);
	}
}
